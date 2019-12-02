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
const GeneralController = require('./controllers/GeneralController');
const ListingController = require('./controllers/ListingController');


let ordCtrl = new OrderController(mdls);
let genCtrl = new GeneralController(mdls);
let listCtrl = new ListingController(mdls);


app.get('/api/categories', (req, res) => {
    genCtrl.getCategories().then(result => {
        res.send(result);
    });
});

app.get('/api/listings', (req, res) => {
    listCtrl.getCleanedListings().then(result => {
        res.send(result);
    });
});


app.get('/api/item', (req, res) => {

    listCtrl.getItemDetails(3).then(result => {
        res.send(result);
    });

});


app.get('/api/order', (req, res) => {

    ordCtrl.getSpecificOrder(1).then(result => {
        res.send(result);
    });
});

app.get('/api/orders', (req, res) => {

    ordCtrl.getOrders(2).then(result => {
        res.send(result);
    });
});


app.get('/api/currencies', (req, res) => {
    genCtrl.getCurrencies().then(result => {
        res.send(result);
    });
});


app.get('/api/countries', (req, res) => {
    genCtrl.getCountries().then(result => {
        res.send(result);
    });
});



app.get('/api/continents', (req, res) => {
    genCtrl.getContinents().then(result => {
        res.send(result);
    });
});



app.get('/api/shipping_addresses', (req, res) => {
    genCtrl.getShippingAddresses(2).then(result => {
        res.send(result);
    });
});



app.listen(port, (req, res) => {
    console.log('Server listening on port number', port);
});
