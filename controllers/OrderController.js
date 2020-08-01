const Sequelize = require('sequelize');
const moment = require('moment');


module.exports =

    class OrderController {

        constructor(models) {

            this.mdls = models;

        }



        getOrders(userId) {
            const self = this;
            return new Promise( (resolve, reject) => {
                self.mdls.mdlOrders.findAll({
                    where : {
                        userId:userId,
                        success:1
                    },
                    order : [['createdAt','DESC']],
                    include: [
                        {
                            model: self.mdls.mdlOrderItems,
                            as: 'items',
                            required: true
                        }],
                }).then((data) => {
                    resolve(data);
                }).catch((err) => {
                    reject([]);
                });
            });

        }


        getSpecificOrder(orderId) {
            const self = this;
            return new Promise( (resolve, reject) => {
                self.mdls.mdlOrders.findAll({
                    where : {
                        id:orderId
                    },
                    include: [
                        {
                            model: self.mdls.mdlShippingAddress,
                            as: 'shipTo',
                            required: true
                        },
                        {
                            model: self.mdls.mdlBillingAddress,
                            as: 'bilTo',
                            required: true
                        },

                        {
                            model: self.mdls.mdlOrderItems,
                            as: 'items',
                            required: true,
                            include: [
                                {
                                    model: self.mdls.mdlProducts,
                                    as: 'product',
                                    required: true
                                },
                                {
                                    model: self.mdls.mdlSellers,
                                    as: 'seller',
                                    required: true
                                },
                                {
                                    model: self.mdls.mdlOrderStatus,
                                    as: 'status',
                                    required: true
                                }],
                        }],
                }).then((data) => {
                    resolve(data[0]);
                }).catch((err) => {
                    reject([]);
                });
            });

        }

    };