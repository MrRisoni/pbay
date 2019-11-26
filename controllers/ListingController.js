const Sequelize = require('sequelize');
const moment = require('moment');

module.exports =
    class ListingController {

        constructor(models) {
            this.mdls = models;
        }


        getItemDetails(listingId) {
            return new Promise((resolve, reject) => {
                Promise.all([this.getItemSellsLastDays(listingId),this.getItem(listingId)]).then(allRes => {
                    resolve({...allRes[0],...allRes[1]});
                }).catch(err => {
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
