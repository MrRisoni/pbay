function getContinents(mdls) {
    return new Promise( (resolve, reject) => {
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

module.exports = {getContinents:getContinents}
