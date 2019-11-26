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
            const userId =2 ;

            return new Promise((resolve, reject) => {
                Promise.all([helps.getContinents(self.mdls),
                    this.getItemSellsLastDays(listingId),
                    this.getItem(listingId),
                    helps.getCountries(self.mdls),
                    helps.getCurrencies(self.mdls),
                    helps.getShippingCountries(self.mdls, userId)]).then(allRes => {


                    const continentsData = allRes[0];
                    const countriesData = allRes[3];
                    const currencyData = allRes[4];
                    const shippingCountries = allRes[5];


                    let productCurrencyObj = currencyData.filter((cr) => {
                        return cr.id === allRes[2].currenyId;
                    })[0];

                    let sellerCountryObj = countriesData.filter((crn) => {
                        return crn.id === allRes[2].sellItem.sellerObj.countryId
                    });

                    Object.assign(allRes[2].sellItem.sellerObj, {countryName: sellerCountryObj[0].title});


                        allRes[2].sellItem.shipForbidden = allRes[2].sellItem.shipForbidden.map((forbid) => {

                        let obj = countriesData.filter((crn) => {
                            return crn.id === forbid.countryId
                        });
                        return {...forbid, ...{countryName: obj[0].title}}
                    });


                    allRes[2].sellItem.shipCosts = allRes[2].sellItem.shipCosts.map((scost) => {

                        let obj = continentsData.filter((con) => {
                            return con.id === scost.continentId
                        });

                        return {
                            ...scost, ...{
                                continentName: obj[0].title,
                                userSeesPrice: helps.currencyConvert(productCurrencyObj.code, userCurrencyCode, currencyData, scost.cost)
                            }
                        }
                    });

                    allRes[2].sellItem.shipCostsExcept = allRes[2].sellItem.shipCostsExcept.map((costEx) => {

                        let obj = countriesData.filter((crn) => {
                            return crn.id === costEx.countryId
                        });

                        return {
                            ...costEx, ...{
                                countryName: obj[0].title,
                                userSeesPrice: helps.currencyConvert(productCurrencyObj.code, userCurrencyCode, currencyData, costEx.cost)
                            }
                        }
                    });

                    let maybeShippingCountryForbidden = false;
                    let maybeShippingCostExceptions = false;

                    let forbiddenShippingList =[];
                    findIfShippingIsForbidden:
                        for (let sf = 0; sf < allRes[2].sellItem.shipForbidden.length; sf++) {
                            for (let scon = 0; scon < shippingCountries.length; scon++) {
                                if (allRes[2].sellItem.shipForbidden[sf].countryId === shippingCountries[scon].shp_country_id) {
                                    maybeShippingCountryForbidden = true;
                                    forbiddenShippingList.push(allRes[2].sellItem.shipForbidden[sf].countryName);
                                }
                            }
                        }

                    let exceptionShippingList =[];
                    for (let sf = 0; sf < allRes[2].sellItem.shipCostsExcept.length; sf++) {
                        for (let scon = 0; scon < shippingCountries.length; scon++) {
                            if (allRes[2].sellItem.shipCostsExcept[sf].countryId === shippingCountries[scon].shp_country_id) {
                                maybeShippingCostExceptions = true;
                                exceptionShippingList.push(allRes[2].sellItem.shipCostsExcept[sf]);
                            }
                        }
                    }

                    Object.assign(allRes[2], {notShipTo:forbiddenShippingList.join(',')});

                    Object.assign(allRes[2], {userCurrencyCode});
                    Object.assign(allRes[2], {productCurrencyCode: productCurrencyObj.code});
                    Object.assign(allRes[2], {userSeesPrice: helps.currencyConvert(productCurrencyObj.code, userCurrencyCode, currencyData, allRes[2].price)});


                    Object.assign(allRes[2], {userCurrencyCode});
                    Object.assign(allRes[2], {maybeShippingCountryForbidden});
                    Object.assign(allRes[2], {maybeShippingCostExceptions});


                    if (maybeShippingCostExceptions) {
                        // only show the exception that match the user shipping address list

                         Object.assign(allRes[2], {sellItem :
                                Object.assign(allRes[2].sellItem, {shipCostsExcept : exceptionShippingList})
                         });
                    }

                    if (maybeShippingCountryForbidden){
                        // only show the forbidden that match the user shipping address list

                    }

                    Object.assign(allRes[2], allRes[1]);

                    resolve(allRes[2]);
                }).catch(err => {
                    console.log(err);
                    reject([]);
                });

            });
        };


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


        getListings(categoryIds = [2, 3]) {
            const self = this;
            return new Promise((resolve, reject) => {
                self.mdls.mdlListings.findAll({
                    where: {
                        showFrom: {
                            [Sequelize.Op.lt]: new Date()
                        },
                        showTo: {
                            [Sequelize.Op.gt]: new Date()
                        }
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
                                    }
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
