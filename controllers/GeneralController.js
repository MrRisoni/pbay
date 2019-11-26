const Sequelize = require('sequelize');
const moment = require('moment');

module.exports =
    class GeneralController {

        constructor(models) {
            this.mdls = models;
        }

        getCategories(userId) {
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


        getCountries(userId) {
            const self = this;
            return new Promise( (resolve, reject) => {
                self.mdls.mdlC.findAll({
                }).then((data) => {
                    resolve(data);
                }).catch((err) => {
                    reject([]);
                });
            });
        }



        getContinents(userId) {
            const self = this;
            return new Promise( (resolve, reject) => {
                self.mdls.mdlC.findAll({
                }).then((data) => {
                    resolve(data);
                }).catch((err) => {
                    reject([]);
                });
            });
        }



        getCurrenies(userId) {
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
