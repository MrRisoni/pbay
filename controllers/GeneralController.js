

class GeneralController {

getShippingAddresses(userId) {
    const self = this;
    return new Promise((resolve, reject) => {
        self.mdls.mdlShippingAddress.findAll({
            where: {
                userId: userId
            },
            include: [
                {
                    model: self.mdls.mdlCountries,
                    as: 'country',
                    required: true
                }]
        }).then((data) => {
            resolve(data);
        }).catch((err) => {
            console.log(err);
            reject([]);
        });
    });


}



