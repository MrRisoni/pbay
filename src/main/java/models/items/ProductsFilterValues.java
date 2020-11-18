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
    @Column
    private Long id;

    @Getter
    @Setter
    @Column
    private String value;

    @JoinColumn(name = "filter_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProductsFilters filterObj;

    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Products productObj;

    public ProductsFilterValues() {
    }

    public ProductsFilterValues(Long pfvId) {
        this.id = pfvId;
    }

    public ProductsFilterValues(Long pfvId, String pfvValue) {
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
