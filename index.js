const express = require('express');
const bodyParser = require('body-parser');
const http = require('http');

const cors = require('cors');



const port = process.env.PORT || 3500;
const app = express();
app.server = http.createServer(app);
app.use(cors());

app.get('/api/version', (req, res) => {
  res.send({
    version: '8.5',
    date: '2019-02-09',
  });
});


app.get('/api/order/details', (req, res) => new Promise((resolve, reject) => {
  mdls.OrdersModel.findAll({
    include: [
      {
        model: mdls.OrderItemModel,
        as: 'items',
        required: true,
        include: [
          {
            model: mdls.editionsModel,
            attributes: ['ediId', 'ediPrintedOn'],
            as: 'edition',
            required: true,
            include: [
              {
                model: mdls.BooksModel,
                attributes: ['bokTitle'],
                as: 'book',
                required: true,
              }],
          },
          {
            model: mdls.OrderItemHistoryModel,
            as: 'history',
            required: true,
            include: [
              {
                model: mdls.StatusesModel,
                as: 'status',
                required: true,
              }],
          }],
      }],
  }).then((data) => {
    resolve(res.send(data));
  }).catch((err) => {
    console.log(err);
  });
}));



app.listen(port, (req, res) => {
  console.log('Server listening on port number', port);
});