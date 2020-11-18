package models.items;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Collection;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "products_filters")
public class ProductsFilters implements Serializable {

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
    private String title;

    @JoinColumn(name = "product_category_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProductsCategories categoryObj;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "filterObj", fetch = FetchType.LAZY)
    private Collection<ProductsFilterValues> productsFilterValuesCollection;

    public ProductsFilters() {
    }

    public ProductsFilters(Long filId) {
        this.id = filId;
    }

    public ProductsFilters(Long filId, String filTitle) {
        this.id = filId;
        this.title = filTitle;
    }

    public ProductsCategories getCategoryObj() {
        return categoryObj;
    }

    public void setCategoryObj(ProductsCategories categoryObj) {
        this.categoryObj = categoryObj;
    }

    @XmlTransient
    public Collection<ProductsFilterValues> getProductsFilterValuesCollection() {
        return productsFilterValuesCollection;
    }

    public void setProductsFilterValuesCollection(Collection<ProductsFilterValues> productsFilterValuesCollection) {
        this.productsFilterValuesCollection = productsFilterValuesCollection;
    }
}
