package models.items;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "products_filter_values")
public class ProductsFilterValues implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pfv_id")
    private Integer id;

    @Getter
    @Setter
    @Column(name = "pfv_value")
    private String value;

    @JoinColumn(name = "pfv_filter_id", referencedColumnName = "fil_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProductsFilters filterObj;

    @JoinColumn(name = "pfv_product_id", referencedColumnName = "prod_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Products productObj;

    public ProductsFilterValues() {
    }

    public ProductsFilterValues(Integer pfvId) {
        this.id = pfvId;
    }

    public ProductsFilterValues(Integer pfvId, String pfvValue) {
        this.id = pfvId;
        this.value = pfvValue;
    }

    public ProductsFilters getFilterObj() {
        return filterObj;
    }

    public void setFilterObj(ProductsFilters filterObj) {
        this.filterObj = filterObj;
    }

    public Products getProductObj() {
        return productObj;
    }

    public void setProductObj(Products productObj) {
        this.productObj = productObj;
    }
}
