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

            const userCurrencyId  =3 ; // CHF
            const userCurrencyCode  ='CHF' ; // CHF

            return new Promise((resolve, reject) => {
                Promise.all([helps.getContinents(self.mdls), this.getItemSellsLastDays(listingId),this.getItem(listingId),helps.getCountries(self.mdls), helps.getCurrencies(self.mdls)]).then(allRes => {


                    const continentsData = allRes[0];
                    const countriesData = allRes[3];
                    const currencyData = allRes[4];


                    allRes[2].sellItem.shipCosts = allRes[2].sellItem.shipCosts.map( (scost) => {

                        let obj = continentsData.filter( (con) => {
                            return con.id === scost.continentId
                        });

                        return {...scost, ...{continentName:obj[0].title}}
                    });


                    allRes[2].sellItem.shipForbidden = allRes[2].sellItem.shipForbidden.map( (forbid) => {

                        let obj = countriesData.filter( (crn) => {
                            return crn.id === forbid.countryId
                        });
                        return {...forbid, ...{countryName:obj[0].title}}
                    });

                    allRes[2].sellItem.shipCostsExcept = allRes[2].sellItem.shipCostsExcept.map( (costEx) => {

                        let obj = countriesData.filter( (crn) => {
                            return crn.id === costEx.countryId
                        });
                        return {...costEx, ...{countryName:obj[0].title}}
                    });

                    let sellerCountryObj = countriesData.filter( (crn) => {
                        return crn.id === allRes[2].sellItem.sellerObj.countryId
                    });

                    Object.assign(allRes[2].sellItem.sellerObj, {countryName:sellerCountryObj[0].title});


                    allRes[2].sellItem.shipCosts = allRes[2].sellItem.shipCosts.map( (scost) => {

                        let obj = continentsData.filter( (con) => {
                            return con.id === scost.continentId
                        });

                        return {...scost, ...{continentName:obj[0].title}}
                    });

                    let productCurrencyObj = currencyData.filter( (cr) => {
                        return cr.id ===  allRes[2].currenyId;
                    })[0];

                    console.log('productCurrencyObj');
                    console.log(productCurrencyObj);



                    Object.assign(allRes[2], {userCurrencyCode});
                    Object.assign(allRes[2], {productCurrencyCode:productCurrencyObj.code });
                    Object.assign(allRes[2], {userSeesPrice:  helps.currencyConvert(productCurrencyObj.code, userCurrencyCode, currencyData, allRes[2].price)});


                    resolve(allRes[2]);
                    // resolve({...allRes[0],...allRes[1]});
                }).catch(err => {
                    console.log(err);
                    reject([]);
                });

            });
        };


        getItemSellsLastDays(listingId){
            const self = this;
            // multi line string in ``
        const q = `SELECT COUNT(O.ord_id) AS soldLastDays
                 FROM  listings L 
                JOIN selling S ON S.sll_id = L.lis_selling_id
                JOIN  order_items OI ON OI.itm_product_id = S.sll_id 
                JOIN  orders O ON O.ord_id =  OI.itm_order_id
                 WHERE L.lis_id = '` + listingId +`' AND OI.itm_void = 0
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
                    resolve(data[0].get({ plain: true }));
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
