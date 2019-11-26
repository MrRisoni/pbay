const Sequelize = require('sequelize');

function getContinents(mdls) {
    return new Promise((resolve, reject) => {
        mdls.mdlContinents.findAll({
            raw: true,
        }).then((data) => {
            resolve(data)
        }).catch((err) => {
            console.log(err);
            reject([]);
        });
    });
}


function getCountries(mdls) {
    return new Promise((resolve, reject) => {
        mdls.mdlCountries.findAll({
            raw: true,
        }).then((data) => {
            resolve(data);
        }).catch((err) => {
            console.log(err);
            reject([]);
        });
    });
}


function getCurrencies(mdls) {
    const self = this;
    return new Promise((resolve, reject) => {
        mdls.mdlCurrencies.findAll({
            raw: true,
        }).then((data) => {
            resolve(data);
        }).catch((err) => {
            reject([]);
        });
    });
}

function currencyConvert(from, to, rates, amount ) {
    if (from === to) {
        return amount;
    }
    else {
        // convert to EUR
        //eg USD to CHF
        const fromEurRate = rates.filter( (cur) => {
           return (cur.code == from);
        })[0].rate;

        const AmountEur = amount / fromEurRate;

        const toThatRate = rates.filter( (cur) => {
            return (cur.code == to);
        })[0].rate;

        const AmountTo = Math.ceil(AmountEur * toThatRate).toFixed(2);

        return AmountTo;

    }
}


function   getShippingCountries(mdls, userId) {
    const self = this;
    // multi line string in ``
    const q = " SELECT DISTINCT(shp_country_id) FROM shipping_addresses WHERE shp_user_id = '" + userId +"'";

    return new Promise((resolve, reject) => {
        mdls.dbObj.query(q, {type: Sequelize.QueryTypes.SELECT})
            .then(res => {
                console.log(res);
                resolve(res);
            }).catch(errSql => {
                console.log('%%%%%%%%%%%%%%%%%%%%%%%%%%%%')
                console.log(errSql)
            reject({errMsg: errSql});
        });
    });
}


module.exports = {getContinents, getCountries, getCurrencies,currencyConvert,getShippingCountries}
