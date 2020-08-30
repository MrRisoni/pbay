
package models.items;

import java.io.Serializable;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.*;
import java.util.Collection;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "products_filters")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductsFilters.findAll", query = "SELECT p FROM ProductsFilters p")})
public class ProductsFilters implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fil_id")
    private Integer id;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductsFilters)) {
            return false;
        }
        ProductsFilters other = (ProductsFilters) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.items.ProductsFilters[ filId=" + id + " ]";
    }
    
}
