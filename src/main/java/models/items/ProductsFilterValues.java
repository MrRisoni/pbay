
package models.items;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "products_filter_values")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductsFilterValues.findAll", query = "SELECT p FROM ProductsFilterValues p")})
public class ProductsFilterValues implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pfv_id")
    private Integer id;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductsFilterValues)) {
            return false;
        }
        ProductsFilterValues other = (ProductsFilterValues) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.items.ProductsFilterValues[ pfvId=" + id + " ]";
    }
    
}
