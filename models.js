








var mdlShippingAddress = sequelize.define('Task', {
  countryId: Sequelize.STRING,
  city: Sequelize.VARCHAR,
 region: Sequelize.VARCHAR,
   street: Sequelize.VARCHAR,
 code: Sequelize.VARCHAR,
   surname: Sequelize.VARCHAR,
 name: Sequelize.VARCHAR

})






var mdlBillingAddress = sequelize.define('Task', {
  countryId: Sequelize.STRING,
  city: Sequelize.VARCHAR,
 region: Sequelize.VARCHAR,
   street: Sequelize.VARCHAR,
 code: Sequelize.VARCHAR,
   surname: Sequelize.VARCHAR,
 name: Sequelize.VARCHAR

})



var mdlOrders = sequelize.define('Task', {
  transactionId: Sequelize.VARCHAR,
  total: Sequelize.FLOAT,
 goods_total: Sequelize.FLOAT,
   ships_total: Sequelize.FLOAT,
 fee: Sequelize.FLOAT,
  rate: Sequelize.FLOAT,
createdAt: Sequelize.DATE


})



var mdlOrderItems = sequelize.define('Task', {
	trackingNums:Sequelize.VARCHAR
  total: Sequelize.FLOAT,
 goods_total: Sequelize.FLOAT,
   ships_total: Sequelize.FLOAT,
 fee: Sequelize.FLOAT,
  rate: Sequelize.FLOAT,
 currencyId: Sequelize.VARCHAR
createdAt: Sequelize.DATE

})


var mdlSellers = sequelize.define('Task', {
	sel_title:Sequelize.VARCHAR

  })



var mdlProducts = sequelize.define('Task', {
	title:Sequelize.VARCHAR

  })




var mdlOrderStatus = sequelize.define('Task', {
	title:Sequelize.VARCHAR

  });







