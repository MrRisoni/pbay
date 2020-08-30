
package models.items;

import com.fasterxml.jackson.annotation.JsonView;
import models.JackSonViewer;
import models.sellers.Selling;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Collection;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "products")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p")})
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prod_id")
    @JsonView({JackSonViewer.IListing.class, JackSonViewer.IOrder.class})
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "prod_title")
    @JsonView({JackSonViewer.IListing.class, JackSonViewer.IOrder.class})
    private String title;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "prod_other_title")
    @JsonView({JackSonViewer.IListing.class, JackSonViewer.IOrder.class})
    private String otherTitle;

    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "prod_descr")
    @JsonView(JackSonViewer.IOrder.class)
    private String description;

    @Basic(optional = false)
    @NotNull
    @Column(name = "prod_preowned")
    @JsonView(JackSonViewer.IOrder.class)
    private short isPreOwned;

    @JoinColumn(name = "prod_category_id", referencedColumnName = "cat_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonView({JackSonViewer.IListing.class, JackSonViewer.IOrder.class})
    private ProductsCategories categoryObj;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "filterObj", fetch = FetchType.LAZY)
    private Collection<ProductsFilterValues> productsFilterValuesCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productObj", fetch = FetchType.LAZY)
    private Collection<Selling> sellingCollection;

    public Products() {
    }

    public Products(Integer prodId) {
        this.id = prodId;
    }

    public Products(Integer prodId, String prodTitle, String prodOtherTitle, String prodDescr, short prodPreowned) {
        this.id = prodId;
        this.title = prodTitle;
        this.otherTitle = prodOtherTitle;
        this.description = prodDescr;
        this.isPreOwned = prodPreowned;
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

    public String getOtherTitle() {
        return otherTitle;
    }

    public void setOtherTitle(String otherTitle) {
        this.otherTitle = otherTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public short getIsPreOwned() {
        return isPreOwned;
    }

    public void setIsPreOwned(short isPreOwned) {
        this.isPreOwned = isPreOwned;
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

    @XmlTransient
    public Collection<Selling> getSellingCollection() {
        return sellingCollection;
    }

    public void setSellingCollection(Collection<Selling> sellingCollection) {
        this.sellingCollection = sellingCollection;
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
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.items.Products[ prodId=" + id + " ]";
    }
    
}
