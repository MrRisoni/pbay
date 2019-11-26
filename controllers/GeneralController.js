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
            return new Promise( (resolve, reject) => {
                self.mdls.mdlProductCategories.findAll({
                }).then((data) => {
                    resolve(data);
                }).catch((err) => {
                    reject([]);
                });
            });
        }


        getCountries() {
            const self = this;
            return new Promise( (resolve, reject) => {
                self.mdls.mdlCountries.findAll({
                }).then((data) => {
                    resolve(data);
                }).catch((err) => {
                    reject([]);
                });
            });
        }



        getContinents() {
            const self = this;
            return new Promise( (resolve, reject) => {
                self.mdls.mdlContinents.findAll({
                    raw: true,
                }).then((data) => {
                    resolve(data);
                }).catch((err) => {
                    reject([]);
                });
            });
        }



        getCurrencies() {
            const self = this;
            return new Promise( (resolve, reject) => {
                self.mdls.mdlCurrencies.findAll({
                }).then((data) => {
                    resolve(data);
                }).catch((err) => {
                    reject([]);
                });
            });
        }


    };
