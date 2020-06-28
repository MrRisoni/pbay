mdlOrders.belongsTo(mdlShippingAddress, {foreignKey: 'ord_shipaddress_id', as: 'shipTo'});
mdlOrders.belongsTo(mdlBillingAddress, {foreignKey: 'ord_billaddress_id', as: 'bilTo'});


mdlOrders.hasMany(mdlOrderItems, {foreignKey: 'itm_order_id', as: 'items'});
mdlSelling.hasMany(mdlShippingCosts, {foreignKey: 'shc_selling_id', as: 'shipCosts'});
mdlSelling.hasMany(mdlShippingCostsExceptions, {foreignKey: 'shcx_selling_id', as: 'shipCostsExcept'});
mdlSelling.hasMany(mdlShippingForbidden, {foreignKey: 'shf_selling_id', as: 'shipForbidden'});


mdlProducts.hasMany(mdlProductFiltersValues, {foreignKey: 'pfv_product_id', as: 'filtersVals'});
mdlProductFiltersValues.belongsTo(mdlProductFilters, {foreignKey: 'pfv_filter_id', as: 'filter'});


mdlSelling.belongsTo(mdlProducts, {foreignKey: 'sll_product_id', as: 'sellProduct'});
mdlSelling.belongsTo(mdlSellers, {foreignKey: 'sll_seller_id', as: 'sellerObj'});
mdlListings.belongsTo(mdlSelling, {foreignKey: 'lis_selling_id', as: 'sellItem'});


mdlOrderItems.belongsTo(mdlProducts, {foreignKey: 'itm_product_id', as: 'product'});
mdlOrderItems.belongsTo(mdlSellers, {foreignKey: 'itm_seller_id', as: 'seller'});
mdlOrderItems.belongsTo(mdlOrderStatus, {foreignKey: 'itm_status_id', as: 'status'});

mdlShippingAddress.belongsTo(mdlCountries, {foreignKey: 'shp_country_id', as: 'country'});
