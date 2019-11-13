const Sequelize = require('sequelize');
const moment = require('moment');


module.exports =

    class WordController {

        constructor(models) {

            this.models = models;

        }



        getOrders(userId) {
            const self = this;
            return new Promise((resolve, reject) => {

                self.models.wordsMdl.findAll({
                        where: {
                            langId: langId
                        },
                    }
                ).then(results => {
                    resolve(results);
                }).catch(err => {
                    reject({errMsg: err, data: []});
                })
            });
        }

    };
