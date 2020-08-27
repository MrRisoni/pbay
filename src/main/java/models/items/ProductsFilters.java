
package models.items;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
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
    private Integer filId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "fil_title")
    private String filTitle;

    @JoinColumn(name = "fil_product_category", referencedColumnName = "cat_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProductsCategories filProductCategory;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pfvFilterId", fetch = FetchType.LAZY)
    private Collection<ProductsFilterValues> productsFilterValuesCollection;

    public ProductsFilters() {
    }

    public ProductsFilters(Integer filId) {
        this.filId = filId;
    }

    public ProductsFilters(Integer filId, String filTitle) {
        this.filId = filId;
        this.filTitle = filTitle;
    }

    public Integer getFilId() {
        return filId;
    }

    public void setFilId(Integer filId) {
        this.filId = filId;
    }

    public String getFilTitle() {
        return filTitle;
    }

    public void setFilTitle(String filTitle) {
        this.filTitle = filTitle;
    }

    public ProductsCategories getFilProductCategory() {
        return filProductCategory;
    }

    public void setFilProductCategory(ProductsCategories filProductCategory) {
        this.filProductCategory = filProductCategory;
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
        hash += (filId != null ? filId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductsFilters)) {
            return false;
        }
        ProductsFilters other = (ProductsFilters) object;
        if ((this.filId == null && other.filId != null) || (this.filId != null && !this.filId.equals(other.filId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.items.ProductsFilters[ filId=" + filId + " ]";
    }
    
}
