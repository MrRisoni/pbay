const Sequelize = require('sequelize');
const moment = require('moment');
const helps = require('./helpers');


module.exports =
    class ListingController {

        constructor(models) {
            this.mdls = models;
        }


        getItemDetails(listingId) {
            const self = this;

            const userCurrencyCode = 'CHF'; // CHF
            const userId = 2;

            return new Promise((resolve, reject) => {
                Promise.all([helps.getShippingContinents(self.mdls, userId),
                        this.getItemSellsLastDays(listingId),
                        this.getItem(listingId),
                        helps.getCurrencies(self.mdls),
                        helps.getShippingCountries(self.mdls, userId),
                        this.getTotalBidsLastDays(listingId),
                        this.getBestBid(listingId),
                        helps.getCountries(self.mdls)
                    ]
                ).then(allRes => {

                    const userShipContinents = allRes[0];
                    const itemsSoldLastData = allRes[1];
                    const itemData = allRes[2];
                    const currencyList = allRes[3];
                    const userShipCountries = allRes[4];
                    const totalBidsCount = allRes[5];
                    const bestBidData = allRes[6];
                    const countriesList = allRes[7];


                    let productCurrencyObj = currencyList.filter((cr) => {
                        return cr.id === itemData.currenyId;
                    })[0];

                    let sellerCountryObj = countriesList.filter((crn) => {
                        return crn.id === itemData.sellItem.sellerObj.countryId
                    });

                    Object.assign(itemData.sellItem.sellerObj, {countryName: sellerCountryObj[0].title});

                    itemData.sellItem.shipForbidden = itemData.sellItem.shipForbidden.filter((forbid) => {
                        return userShipCountries.some((el) => {
                            return (el.id === forbid.countryId);
                        })
                    }).map((forbid) => {

                        let obj = userShipCountries.filter((crn) => {
                            return crn.id === forbid.countryId
                        });

                        if (obj.length > 0) {
                            return {...forbid, ...{countryName: obj[0].title}}
                        }
                    });



                    let avgShipPrice = 0;

                    itemData.sellItem.shipCosts = itemData.sellItem.shipCosts.filter((scost) => {

                        return userShipContinents.some((conEl) => {
                            return (conEl.id === scost.continentId);
                        })
                    }).map((scost) => {

                        let obj = userShipContinents.filter((con) => {
                            return con.id == scost.continentId
                        });

                        let userSeesPriceShip = helps.currencyConvert(productCurrencyObj.code, userCurrencyCode, currencyList, scost.cost)
                        avgShipPrice += userSeesPriceShip;
                        return {
                            ...scost, ...{
                                continentName: obj[0].title,
                                userSeesPrice: userSeesPriceShip
                            }
                        }

                    });

                    avgShipPrice /= itemData.sellItem.shipCosts.length;
                    avgShipPrice = avgShipPrice.toFixed(2);
                    Object.assign(itemData, {avgShipPrice: avgShipPrice});


                    itemData.sellItem.shipCostsExcept = itemData.sellItem.shipCostsExcept.filter((costEx) => {
                        return userShipCountries.some((el) => {
                            return (el.id === costEx.countryId);
                        })
                    }).map((costEx) => {

                        let obj = userShipCountries.filter((crn) => {
                            return crn.id === costEx.countryId
                        });

                        if (obj.length > 0) {
                            return {
                                ...costEx, ...{
                                    countryName: obj[0].title,
                                    userSeesPrice: helps.currencyConvert(productCurrencyObj.code, userCurrencyCode, currencyList, costEx.cost)
                                }
                            }
                        }
                    });


                    let maybeShippingCountryForbidden = false;
                    let maybeShippingCostExceptions = false;

                    let forbiddenShippingList = [];
                    for (let sf = 0; sf < itemData.sellItem.shipForbidden.length; sf++) {
                        maybeShippingCountryForbidden = true;
                        forbiddenShippingList.push(itemData.sellItem.shipForbidden[sf].countryName);
                    }

                    let exceptionShippingList = [];
                    for (let sf = 0; sf < itemData.sellItem.shipCostsExcept.length; sf++) {
                        maybeShippingCostExceptions = true;
                        exceptionShippingList.push(itemData.sellItem.shipCostsExcept[sf]);
                    }

                    Object.assign(itemData, {notShipTo: forbiddenShippingList.join(',')});

                    Object.assign(itemData, {userCurrencyCode});
                    Object.assign(itemData, {productCurrencyCode: productCurrencyObj.code});
                    Object.assign(itemData, {userSeesPrice: helps.currencyConvert(productCurrencyObj.code, userCurrencyCode, currencyList, itemData.price)});


                    Object.assign(itemData, {userCurrencyCode});
                    Object.assign(itemData, {maybeShippingCountryForbidden});
                    Object.assign(itemData, {maybeShippingCostExceptions});


                    if (maybeShippingCostExceptions) {

                        Object.assign(itemData, {
                            sellItem:
                                Object.assign(itemData.sellItem, {shipCostsExcept: exceptionShippingList})
                        });
                    }

                    Object.assign(itemData, itemsSoldLastData);

                    if (itemData.isAuction === 1) {
                        Object.assign(itemData, {
                            highestBidding: {
                                price: helps.currencyConvert('EUR', userCurrencyCode, currencyData, bestBidData.bestBid),
                                hoursAgo: bestBidData.hoursAgo
                            }
                        });

                        Object.assign(itemData, getTotalBidsLastDays);
                    }


                    resolve(itemData);
                }).catch(err => {
                    console.log(err);
                    reject([]);
                });

            });
        };


        getTotalBidsLastDays(listingId) {
            const self = this;
            const q = `SELECT COUNT(bid_id) AS totalBids FROM biddings
                WHERE bid_active = 1 AND bid_listing_id = '` + listingId + `'
                 AND 
                 DATEDIFF(CURRENT_DATE, DATE(bid_created_at)) <=2
                 AND 
                 DATEDIFF(CURRENT_DATE, DATE(bid_created_at)) >=0`;
            return new Promise((resolve, reject) => {
                self.mdls.dbObj.query(q, {type: Sequelize.QueryTypes.SELECT})
                    .then(res => {
                        resolve(res[0]);
                    }).catch(errSql => {
                    console.log('%%%%%%%%%%%%%%%%%%%%%%%%%%');
                    console.log(errSql);
                    reject({errMsg: errSql});
                });
            });
        }

        getBestBid(listingId) {
            const self = this;
            const q = `SELECT bid_price_eur AS bestBid,  TIMESTAMPDIFF(HOUR,bid_created_at,NOW()) 
                AS hoursAgo
                FROM biddings
                WHERE bid_active = 1 AND bid_listing_id = '` + listingId + `'
                ORDER BY bid_price_eur DESC LIMIT 1`;
            return new Promise((resolve, reject) => {
                self.mdls.dbObj.query(q, {type: Sequelize.QueryTypes.SELECT})
                    .then(res => {
                        resolve(res[0]);
                    }).catch(errSql => {
                    console.log('%%%%%%%%%%%%%%%%%%%%%%%%%%');
                    console.log(errSql);
                    reject({errMsg: errSql});
                });
            });
        }


        getItemSellsLastDays(listingId) {
            const self = this;
            // multi line string in ``
            const q = `SELECT COUNT(O.ord_id) AS soldLastDays
                 FROM  listings L 
                JOIN selling S ON S.sll_id = L.lis_selling_id
                JOIN  order_items OI ON OI.itm_product_id = S.sll_id 
                JOIN  orders O ON O.ord_id =  OI.itm_order_id
                 WHERE L.lis_id = '` + listingId + `' AND OI.itm_void = 0
                 AND O.ord_success = 1
                 AND 
                 DATEDIFF(CURRENT_DATE, DATE(O.ord_created)) <=2
                 AND 
                  DATEDIFF(CURRENT_DATE, DATE(O.ord_created)) >=0`;

            return new Promise((resolve, reject) => {
                self.mdls.dbObj.query(q, {type: Sequelize.QueryTypes.SELECT})
                    .then(res => {
                        resolve(res[0]);
                    }).catch(errSql => {
                    reject({errMsg: errSql});
                });
            });
        }


        getItem(listingId) {
            const self = this;
            return new Promise((resolve, reject) => {
                self.mdls.mdlListings.findAll({
                    where: {
                        id: listingId
                    },
                    include: [
                        {
                            model: self.mdls.mdlSelling,
                            as: 'sellItem',
                            required: true,
                            include: [
                                {
                                    model: self.mdls.mdlProducts,
                                    as: 'sellProduct',
                                    required: true,
                                    include: [
                                        {
                                            model: self.mdls.mdlProductFiltersValues,
                                            as: 'filtersVals',
                                            required: true,
                                            include: [
                                                {
                                                    model: self.mdls.mdlProductFilters,
                                                    as: 'filter',
                                                    required: true
                                                }]
                                        }]
                                },
                                {
                                    model: self.mdls.mdlShippingCosts,
                                    as: 'shipCosts',
                                    required: true
                                },
                                {
                                    model: self.mdls.mdlShippingCostsExceptions,
                                    as: 'shipCostsExcept'
                                },
                                {
                                    model: self.mdls.mdlShippingForbidden,
                                    as: 'shipForbidden'
                                },
                                {
                                    model: self.mdls.mdlSellers,
                                    as: 'sellerObj',
                                    required: true
                                }]
                        }]
                }).then((data) => {
                    resolve(data[0].get({plain: true}));
                }).catch((err) => {
                    console.log(err);
                    reject([]);
                });
            });


        }


        getListings(categoryIds = [1, 2, 3]) {
            const self = this;
            return new Promise((resolve, reject) => {
                self.mdls.mdlListings.findAll({
                    where: {
                        showFrom: {
                            [Sequelize.Op.lt]: new Date()
                        },
                        showTo: {
                            [Sequelize.Op.gt]: new Date()
                        },
                        bought:0,
                        isActive: 1,
                    },
                    include: [
                        {
                            model: self.mdls.mdlSelling,
                            as: 'sellItem',
                            required: true,
                            include: [
                                {
                                    model: self.mdls.mdlProducts,
                                    as: 'sellProduct',
                                    required: true,
                                    where: {
                                        categoryId: {
                                            [Sequelize.Op.or]: [categoryIds]
                                        }
                                    },
                                    include: [
                                        {
                                            model: self.mdls.mdlProductFiltersValues,
                                            as: 'filtersVals',
                                            required: true
                                        }]
                                },
                                {
                                    model: self.mdls.mdlSellers,
                                    as: 'sellerObj',
                                    required: true
                                }]
                        }]
                }).then((data) => {
                    resolve(data);
                }).catch((err) => {
                    console.log(err);
                    reject([]);
                });
            });
        }

    };
