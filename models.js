const Sequelize = require('sequelize');

const dbname = process.env.DB_NAME || 'pbaydb';

const user = process.env.DB_USER || 'root';
const passwd = process.env.DB_PASS || '';
const host = process.env.DB_HOST || '';

const sequelize = new Sequelize(dbname, user, passwd, {
    host: host,
    dialect: 'mysql',
    pool: {
        max: 5,
        min: 0,
        acquire: 30000,
        idle: 10000
    },
    logging: console.log,
});


sequelize
    .authenticate()
    .then(() => {
        console.log('Connection has been established successfully.');
    })
    .catch(err => {
        console.error('Unable to connect to the database:', err);
    });


var mdlShippingAddress = sequelize.define('shipping_addresses', {
        id: {
            type: Sequelize.INTEGER.UNSIGNED,
            field: 'shp_id',
            autoIncrement: true,
            primaryKey: true,
        },
        countryId: {
            type: Sequelize.INTEGER,
            field: 'shp_country_id'
        },
        city: {
            type: Sequelize.CHAR,
            field: 'shp_city'
        },
        region: {
            type: Sequelize.CHAR,
            field: 'shp_region'
        },
        street: {
            type: Sequelize.CHAR,
            field: 'shp_street'
        },
        street_no: {
            type: Sequelize.CHAR,
            field: 'shp_street_no'
        },
        code: {
            type: Sequelize.CHAR,
            field: 'shp_code'
        },
        surname: {
            type: Sequelize.CHAR,
            field: 'shp_surname'
        },
        name: {
            type: Sequelize.CHAR,
            field: 'shp_name'

        }
    },
    {
        timestamps: false,
        freezeTableName: true
    }
);


var mdlBillingAddress = sequelize.define('billing_addresses', {
        id: {
            type: Sequelize.INTEGER.UNSIGNED,
            field: 'bla_id',
            autoIncrement: true,
            primaryKey: true,
        },
        countryId: {
            type: Sequelize.INTEGER,
            field: 'bla_country_id'

        },
        city: {
            type: Sequelize.CHAR,
            field: 'bla_city'

        },
        region: {
            type: Sequelize.CHAR,
            field: 'bla_region'

        },
        street: {
            type: Sequelize.CHAR,
            field: 'bla_street'

        },
        street_no: {
            type: Sequelize.CHAR,
            field: 'bla_street_no'

        },
        code: {
            type: Sequelize.CHAR,
            field: 'bla_code'

        },
        surname: {
            type: Sequelize.CHAR,
            field: 'bla_surname'

        },
        name: {
            type: Sequelize.CHAR,
            field: 'bla_name'
        },
    },
    {
        timestamps: false,
        freezeTableName: true
    }
);


var mdlOrders = sequelize.define('orders', {
        id: {
            type: Sequelize.INTEGER.UNSIGNED,
            field: 'ord_id',
            autoIncrement: true,
            primaryKey: true,
        },
        transactionId: {
            type: Sequelize.CHAR,
            field: 'ord_bank_transaction_id'
        },
        userId: {
            type: Sequelize.INTEGER.UNSIGNED,
            field: 'ord_user_id'
        },
        total: {
            type: Sequelize.FLOAT,
            field: 'ord_total'
        },
        goods_total: {
            type: Sequelize.FLOAT,
            field: 'ord_goods_total'
        },
        ships_total: {
            type: Sequelize.FLOAT,
            field: 'ord_ship_total'
        },
        fee: {
            type: Sequelize.FLOAT,
            field: 'ord_fee'
        },
        rate: {
            type: Sequelize.FLOAT,
            field: 'ord_rate'
        },
        createdAt: {
            type: Sequelize.DATE,
            field: 'ord_created'
        },
    },
    {
        timestamps: false,
        freezeTableName:
            true
    }
);


var mdlOrderItems = sequelize.define('order_items', {
        id: {
            type: Sequelize.INTEGER.UNSIGNED,
            field: 'itm_id',
            autoIncrement: true,
            primaryKey: true,
        },
        trackingNums: {
            type: Sequelize.CHAR,
            field: 'itm_tracking_nums'
        },
        total: {
            type: Sequelize.FLOAT,
            field: 'itm_total'
        },
        goods_total: {
            type: Sequelize.FLOAT,
            field: 'itm_goods_total'
        },
        ships_total: {
            type: Sequelize.FLOAT,
            field: 'itm_ship_total'
        },
        currencyId: {
            type: Sequelize.INTEGER,
            field: 'itm_currency_id'
        }
    },
    {
        timestamps: false,
        freezeTableName:
            true
    }
);


var mdlSellers = sequelize.define('sellers', {
        id: {
            type: Sequelize.INTEGER.UNSIGNED,
            field: 'sel_id',
            autoIncrement: true,
            primaryKey: true,
        },
        title: {
            type: Sequelize.CHAR,
            field: 'sel_title'
        },
        countryId: {
            type: Sequelize.INTEGER,
            field: 'sel_country_id'
        },
        rating: {
            type: Sequelize.FLOAT,
            field: 'sel_stars_avg'
        }
    },
    {
        timestamps: false,
        freezeTableName: true
    }
);


var mdlProducts = sequelize.define('products', {
        id: {
            type: Sequelize.INTEGER.UNSIGNED,
            field: 'prod_id',
            autoIncrement: true,
            primaryKey: true,
        },
        title: {
            type: Sequelize.CHAR,
            field: 'prod_title'
        },
        otherTitle: {
            type: Sequelize.CHAR,
            field: 'prod_other_title'
        },
        descr: {
            type: Sequelize.CHAR,
            field: 'prod_descr'
        },
        categoryId: {
            type: Sequelize.INTEGER,
            field: 'prod_category_id'
        },
        preOwned: {
            type: Sequelize.INTEGER.UNSIGNED,
            field: 'prod_preowned',
        }
    },
    {
        timestamps: false,
        freezeTableName: true
    }
);



var mdlCurrencies = sequelize.define('currencies', {
        id: {
            type: Sequelize.INTEGER.UNSIGNED,
            field: 'cur_id',
            autoIncrement: true,
            primaryKey: true,
        },
        title: {
            type: Sequelize.CHAR,
            field: 'cur_title'
        }
    },
    {
        timestamps: false,
        freezeTableName: true
    }
);

var mdlCountries = sequelize.define('countries', {
        id: {
            type: Sequelize.INTEGER.UNSIGNED,
            field: 'ctr_id',
            autoIncrement: true,
            primaryKey: true,
        },
        title: {
            type: Sequelize.CHAR,
            field: 'ctr_title'
        },
        code: {
            type: Sequelize.CHAR,
            field: 'ctr_code'
        }
    },
    {
        timestamps: false,
        freezeTableName: true
    }
);



var mdlContinents = sequelize.define('continents', {
        id: {
            type: Sequelize.INTEGER.UNSIGNED,
            field: 'con_id',
            autoIncrement: true,
            primaryKey: true,
        },
        title: {
            type: Sequelize.CHAR,
            field: 'con_title'
        },
        code: {
            type: Sequelize.CHAR,
            field: 'con_code'
        }
    },
    {
        timestamps: false,
        freezeTableName: true
    }
);




var mdlListings = sequelize.define('listings', {
        id: {
            type: Sequelize.INTEGER.UNSIGNED,
            field: 'lis_id',
            autoIncrement: true,
            primaryKey: true,
        },
        price: {
            type: Sequelize.FLOAT,
            field: 'lis_price'
        },
        showFrom: {
            type: Sequelize.DATE,
            field: 'lis_from'
        },
        showTo: {
            type: Sequelize.DATE,
            field: 'lis_to'
        },
        watching: {
            type: Sequelize.INTEGER.UNSIGNED,
            field: 'lis_watching'
        },
    },
    {
        timestamps: false,
        freezeTableName: true
    }
);


var mdlSelling = sequelize.define('selling', {
        id: {
            type: Sequelize.INTEGER.UNSIGNED,
            field: 'sll_id',
            autoIncrement: true,
            primaryKey: true,
        },
        quantity: {
            type: Sequelize.INTEGER,
            field: 'sll_quantity'
        },
        mailerCo: {
            type: Sequelize.CHAR,
            field: 'sll_mailer_co'
        }
    },
    {
        timestamps: false,
        freezeTableName: true
    }
);



var mdlProductCategories = sequelize.define('products_categories', {
        id: {
            type: Sequelize.INTEGER.UNSIGNED,
            field: 'cat_id',
            autoIncrement: true,
            primaryKey: true,
        },
        title: {
            type: Sequelize.CHAR,
            field: 'cat_title'
        },
    },
    {
        timestamps: false,
        freezeTableName: true
    }
);

var mdlOrderStatus = sequelize.define('order_statuses', {
        id: {
            type: Sequelize.INTEGER.UNSIGNED,
            field: 'stat_id',
            autoIncrement: true,
            primaryKey: true,
        },
        title: {
            type: Sequelize.CHAR,
            field: 'stat_title'
        },
    },
    {
        timestamps: false,
        freezeTableName: true
    }
);


var mdlShippingCosts = sequelize.define('shipping_costs', {
        id: {
            type: Sequelize.INTEGER.UNSIGNED,
            field: 'shc_id',
            autoIncrement: true,
            primaryKey: true,
        },
        continentId: {
            type: Sequelize.INTEGER.UNSIGNED,
            field: 'shc_continent_id'
        },
        currencyId: {
            type: Sequelize.INTEGER.UNSIGNED,
            field: 'shc_currency_id'
        },
        cost: {
            type: Sequelize.FLOAT,
            field: 'shc_cost'
        },
    },
    {
        timestamps: false,
        freezeTableName: true
    }
);


var mdlShippingCostsExceptions = sequelize.define('shipping_costs_exceptions', {
        id: {
            type: Sequelize.INTEGER.UNSIGNED,
            field: 'shcx_id',
            autoIncrement: true,
            primaryKey: true,
        },
        countryId: {
            type: Sequelize.INTEGER.UNSIGNED,
            field: 'shcx_country_id'
        },
        currencyId: {
            type: Sequelize.INTEGER.UNSIGNED,
            field: 'shcx_currency_id'
        },
        cost: {
            type: Sequelize.FLOAT,
            field: 'shcx_cost'
        },
    },
    {
        timestamps: false,
        freezeTableName: true
    }
);


var mdlShippingForbidden = sequelize.define('shipping_country_forbidden', {
        id: {
            type: Sequelize.INTEGER.UNSIGNED,
            field: 'shf_id',
            autoIncrement: true,
            primaryKey: true,
        },
        countryId: {
            type: Sequelize.INTEGER.UNSIGNED,
            field: 'shf_country_id'
        }
    },
    {
        timestamps: false,
        freezeTableName: true
    }
);


var mdlProductFilters = sequelize.define('products_filters', {
        id: {
            type: Sequelize.INTEGER.UNSIGNED,
            field: 'fil_id',
            autoIncrement: true,
            primaryKey: true,
        },
        title: {
            type: Sequelize.CHAR,
            field: 'fil_title'
        }
    },
    {
        timestamps: false,
        freezeTableName: true
    }
);


var mdlProductFiltersValues = sequelize.define('products_filter_values', {
        id: {
            type: Sequelize.INTEGER.UNSIGNED,
            field: 'pfv_id',
            autoIncrement: true,
            primaryKey: true,
        },
        val: {
            type: Sequelize.CHAR,
            field: 'pfv_value'
        }
    },
    {
        timestamps: false,
        freezeTableName: true
    }
);





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





module.exports = {
    dbObj: sequelize,
    mdlOrderStatus,
    mdlProducts,
    mdlSellers,
    mdlOrderItems,
    mdlOrders,
    mdlBillingAddress,
    mdlShippingAddress,
    mdlProductCategories,
    mdlSelling,
    mdlListings,
    mdlShippingCosts,
    mdlCurrencies,
    mdlShippingCostsExceptions,
    mdlShippingForbidden,
    mdlProductFilters,
    mdlProductFiltersValues,
    mdlContinents,
    mdlCountries
};





