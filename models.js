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
    logging: true
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


mdlOrders.belongsTo(mdlShippingAddress, {foreignKey: 'ord_shipaddress_id', as: 'shipTo'});
mdlOrders.belongsTo(mdlBillingAddress, {foreignKey: 'ord_billaddress_id', as: 'bilTo'});


mdlOrders.hasMany(mdlOrderItems, {foreignKey: 'itm_order_id', as: 'items'});



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
};





