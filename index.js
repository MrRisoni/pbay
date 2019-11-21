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
const OrderController = require('./controllers/OrderController');

let ordCtrl = new OrderController(mdls);

app.get('/api/version', (req, res) => {
    res.send({
        version: '8.5',
        date: '2019-02-09',
    });
});


app.get('/api/order', (req, res) => {

    ordCtrl.getOrders(1).then(result => {
        res.send(result);
    });
});


app.listen(port, (req, res) => {
    console.log('Server listening on port number', port);
});
