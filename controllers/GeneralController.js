const Sequelize = require('sequelize');
const moment = require('moment');
const helps = require('./helpers');


module.exports =
    class GeneralController {

        constructor(models) {
            this.mdls = models;
        }

        getCategories() {
            const self = this;
            return new Promise((resolve, reject) => {
                self.mdls.mdlProductCategories.findAll({}).then((data) => {
                    resolve(data);
                }).catch((err) => {
                    reject([]);
                });
            });
        }


        getCountries() {
            const self = this;
            return new Promise((resolve, reject) => {
                resolve(helps.getCountries(self.mdls));
            });
        }


        getContinents() {
            const self = this;
            return new Promise((resolve, reject) => {
                resolve(helps.getContinents(self.mdls));
            });
        }


        getCurrencies() {
            const self = this;
            return new Promise((resolve, reject) => {
                resolve(helps.getCountries(self.mdls));

            });
        }


        getShippingAddresses(userId) {
            const self = this;
            return new Promise((resolve, reject) => {
                self.mdls.mdlShippingAddress.findAll({
                    where: {
                        userId: userId
                    },
                    include: [
                        {
                            model: self.mdls.mdlCountries,
                            as: 'country',
                            required: true
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
