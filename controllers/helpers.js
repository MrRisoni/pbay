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

        console.log('from eur rate ' + fromEurRate);
        const AmountEur = amount / fromEurRate;

        const toThatRate = rates.filter( (cur) => {
            return (cur.code == to);
        })[0].rate;

        console.log('to that rate ' + toThatRate);
        const AmountTo = Math.ceil(AmountEur * toThatRate).toFixed(2);

        console.log(AmountTo);

        return AmountTo

    }
}

module.exports = {getContinents, getCountries, getCurrencies,currencyConvert}
