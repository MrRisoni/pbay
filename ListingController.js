

getItemDetails(listingId) {
    const self = this;

    const userCurrencyCode = 'CHF'; // CHF
    const userId = 2;

    return new Promise((resolve, reject) => {
        Promise.all([helps.getShippingContinents(self.mdls, userId),
                this.getItem(listingId),
                helps.getCurrencies(self.mdls),
                helps.getShippingCountries(self.mdls, userId),
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


getListings( ) {
    const searchParams = {
        categoryIds:[1, 2, 3],
        searchTxt: 'Potter och',
    };

    const self = this;
    return new Promise((resolve, reject) => {
        self.mdls.mdlListings.findAll({
            where: {
                showFrom: {
                    [Sequelize.Op.lt]: self.todayStr
                },
                showTo: {
                    [Sequelize.Op.gt]: self.todayStr
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
                                    [Sequelize.Op.or]: [searchParams.categoryIds]
                                },
                                title: {
                                    [Sequelize.Op.like]: '%' + searchParams.searchTxt +'%'
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
          //  const sqlRes = data;
        }).catch((err) => {
            console.log(err);
            reject([]);
        });
    });
}



getFilterValsForSearch()
{
    const self = this;
    // multi line string in ``
    const q = ` SELECT  PF.fil_title AS filterTitle , PFV.pfv_value AS val, PF.fil_id AS filtrId
            FROM  listings L
            JOIN  selling S ON S.sll_id = L.lis_selling_id
            JOIN products P ON P.prod_id = S.sll_product_id
            JOIN  products_filter_values PFV ON  PFV.pfv_product_id  = P.prod_id
            JOIN products_filters PF ON PF.fil_id = PFV.pfv_filter_id
            WHERE PF.fil_filterable = 1
            ORDER BY pfv_filter_id `;

    return new Promise((resolve, reject) => {
        self.mdls.dbObj.query(q, {type: Sequelize.QueryTypes.SELECT})
            .then(res => {
                resolve(res);
            }).catch(errSql => {
            console.log(errSql)
            reject({errMsg: errSql});
        });
    });
}


getListingsAndFilters() {
    return new Promise((resolve, reject) => {

        Promise.all([this.getFilterValsForSearch(),
                this.getListings()
            ]
        ).then(allRes => {
            let uniqueFilterVals = {};
            let allFilterVals = {};

            allRes[0].forEach((filtro) => {
                if ( typeof allFilterVals[filtro.filterTitle] !== 'undefined') {
                    allFilterVals[filtro.filterTitle]['values'].push(filtro.val);
                }
                else {
                    allFilterVals[filtro.filterTitle] = { values: [filtro.val], Id :filtro.filtrId }
                }
            })

            console.log(allFilterVals);

           for (var filtrKey in allFilterVals) {
               uniqueFilterVals[filtrKey] = { Id:allFilterVals[filtrKey]['Id'],  values:  _.uniqBy(allFilterVals[filtrKey]['values']) };
            }

            resolve({filterVals:uniqueFilterVals,listings:allRes[1]});
        }).catch(err => {
            console.log(err)
            reject({errMsg: err});
        });
    });
}





