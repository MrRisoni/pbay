
package models.items;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.*;
import java.util.Collection;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "products_filters")
public class ProductsFilters implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fil_id")
    private Integer id;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "fil_title")
    private String title;

    @JoinColumn(name = "fil_product_category", referencedColumnName = "cat_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProductsCategories categoryObj;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "filterObj", fetch = FetchType.LAZY)
    private Collection<ProductsFilterValues> productsFilterValuesCollection;

    public ProductsFilters() {
    }

    public ProductsFilters(Integer filId) {
        this.id = filId;
    }

    public ProductsFilters(Integer filId, String filTitle) {
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
