




getListings( ) {
    const searchParams = {
        categoryIds:[1, 2, 3],
        searchTxt: 'Potter och',
    };

    const self = this;
    return new Promise((resolve, reject) => {
        self.mdls.mdlListings.findAll({
            where: {
                showFrom: {
                    [Sequelize.Op.lt]: self.todayStr
                },
                showTo: {
                    [Sequelize.Op.gt]: self.todayStr
                },
                bought:0,
                isActive: 1,
            },
            include: [
                {
                    model: self.mdls.mdlSelling,
                    as: 'sellItem',
                    required: true,
                    include: [
                        {
                            model: self.mdls.mdlProducts,
                            as: 'sellProduct',
                            required: true,
                            where: {
                                categoryId: {
                                    [Sequelize.Op.or]: [searchParams.categoryIds]
                                },
                                title: {
                                    [Sequelize.Op.like]: '%' + searchParams.searchTxt +'%'
                                }
                            },
                            include: [
                                {
                                    model: self.mdls.mdlProductFiltersValues,
                                    as: 'filtersVals',
                                    required: true
                                }]
                        },
                        {
                            model: self.mdls.mdlSellers,
                            as: 'sellerObj',
                            required: true
                        }]
                }]
        }).then((data) => {
            resolve(data);
          //  const sqlRes = data;
        }).catch((err) => {
            console.log(err);
            reject([]);
        });
    });
}



getFilterValsForSearch()
{
    const self = this;
    // multi line string in ``
    const q = ` SELECT  PF.fil_title AS filterTitle , PFV.pfv_value AS val, PF.fil_id AS filtrId
            FROM  listings L
            JOIN  selling S ON S.sll_id = L.lis_selling_id
            JOIN products P ON P.prod_id = S.sll_product_id
            JOIN  products_filter_values PFV ON  PFV.pfv_product_id  = P.prod_id
            JOIN products_filters PF ON PF.fil_id = PFV.pfv_filter_id
            WHERE PF.fil_filterable = 1
            ORDER BY pfv_filter_id `;

    return new Promise((resolve, reject) => {
        self.mdls.dbObj.query(q, {type: Sequelize.QueryTypes.SELECT})
            .then(res => {
                resolve(res);
            }).catch(errSql => {
            console.log(errSql)
            reject({errMsg: errSql});
        });
    });
}


getListingsAndFilters() {
    return new Promise((resolve, reject) => {

        Promise.all([this.getFilterValsForSearch(),
                this.getListings()
            ]
        ).then(allRes => {
            let uniqueFilterVals = {};
            let allFilterVals = {};

            allRes[0].forEach((filtro) => {
                if ( typeof allFilterVals[filtro.filterTitle] !== 'undefined') {
                    allFilterVals[filtro.filterTitle]['values'].push(filtro.val);
                }
                else {
                    allFilterVals[filtro.filterTitle] = { values: [filtro.val], Id :filtro.filtrId }
                }
            })

            console.log(allFilterVals);

           for (var filtrKey in allFilterVals) {
               uniqueFilterVals[filtrKey] = { Id:allFilterVals[filtrKey]['Id'],  values:  _.uniqBy(allFilterVals[filtrKey]['values']) };
            }

            resolve({filterVals:uniqueFilterVals,listings:allRes[1]});
        }).catch(err => {
            console.log(err)
            reject({errMsg: err});
        });
    });
}






