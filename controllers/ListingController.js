const Sequelize = require('sequelize');
const moment = require('moment');

module.exports =
    class ListingController {

        constructor(models) {
            this.mdls = models;
        }

        getListings(categoryId = 1) {
            const self = this;
            return new Promise( (resolve, reject) => {
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
                                    required: true
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
