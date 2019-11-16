const port = process.env.PORT || 3500;
const express = require('express');
const app = express();
const http = require('http').Server(app);
const bodyParser = require('body-parser');
const cors = require('cors');
const Sequelize = require('sequelize');


app.use(bodyParser.json());
app.use(cors());

const mdls = require('./models');


app.get('/api/version', (req, res) => {
    res.send({
        version: '8.5',
        date: '2019-02-09',
    });
});


app.get('/api/order', (req, res) => new Promise((resolve, reject) => {
    mdls.mdlOrders.findAll({
        include: [
            {
                model: mdls.mdlShippingAddress,
                as: 'shipTo',
                required: true
            },
            {
                model: mdls.mdlBillingAddress,
                as: 'bilTo',
                required: true
            },

            {
                model: mdls.mdlOrderItems,
                as: 'items',
                required: true,
                include: [
                    {
                        model: mdls.mdlProducts,
                        as: 'product',
                        required: true
                    },
                    {
                        model: mdls.mdlSellers,
                        as: 'seller',
                        required: true
                    },
                    {
                        model: mdls.mdlOrderStatus,
                        as: 'status',
                        required: true
                    }],
            }],
    }).then((data) => {
        resolve(res.send(data[0]));
    }).catch((err) => {
        console.log(err);
    });
}));


app.listen(port, (req, res) => {
    console.log('Server listening on port number', port);
});
