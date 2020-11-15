package models.items;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "products_filter_values")
public class ProductsFilterValues implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pfv_id")
    private Integer id;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 88)
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
