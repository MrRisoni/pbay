
package models;

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
import javax.persistence.Lob;
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
    private Integer prodId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "prod_title")
    private String prodTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "prod_other_title")
    private String prodOtherTitle;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "prod_descr")
    private String prodDescr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prod_preowned")
    private short prodPreowned;
    @JoinColumn(name = "prod_category_id", referencedColumnName = "cat_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProductsCategories prodCategoryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pfvProductId", fetch = FetchType.LAZY)
    private Collection<ProductsFilterValues> productsFilterValuesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sllProductId", fetch = FetchType.LAZY)
    private Collection<Selling> sellingCollection;

    public Products() {
    }

    public Products(Integer prodId) {
        this.prodId = prodId;
    }

    public Products(Integer prodId, String prodTitle, String prodOtherTitle, String prodDescr, short prodPreowned) {
        this.prodId = prodId;
        this.prodTitle = prodTitle;
        this.prodOtherTitle = prodOtherTitle;
        this.prodDescr = prodDescr;
        this.prodPreowned = prodPreowned;
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public String getProdTitle() {
        return prodTitle;
    }

    public void setProdTitle(String prodTitle) {
        this.prodTitle = prodTitle;
    }

    public String getProdOtherTitle() {
        return prodOtherTitle;
    }

    public void setProdOtherTitle(String prodOtherTitle) {
        this.prodOtherTitle = prodOtherTitle;
    }

    public String getProdDescr() {
        return prodDescr;
    }

    public void setProdDescr(String prodDescr) {
        this.prodDescr = prodDescr;
    }

    public short getProdPreowned() {
        return prodPreowned;
    }

    public void setProdPreowned(short prodPreowned) {
        this.prodPreowned = prodPreowned;
    }

    public ProductsCategories getProdCategoryId() {
        return prodCategoryId;
    }

    public void setProdCategoryId(ProductsCategories prodCategoryId) {
        this.prodCategoryId = prodCategoryId;
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
        hash += (prodId != null ? prodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.prodId == null && other.prodId != null) || (this.prodId != null && !this.prodId.equals(other.prodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Products[ prodId=" + prodId + " ]";
    }
    
}
