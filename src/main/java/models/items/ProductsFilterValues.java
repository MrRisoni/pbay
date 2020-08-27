
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
    private Integer pfvId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 88)
    @Column(name = "pfv_value")
    private String pfvValue;

    @JoinColumn(name = "pfv_filter_id", referencedColumnName = "fil_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProductsFilters pfvFilterId;

    @JoinColumn(name = "pfv_product_id", referencedColumnName = "prod_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Products pfvProductId;

    public ProductsFilterValues() {
    }

    public ProductsFilterValues(Integer pfvId) {
        this.pfvId = pfvId;
    }

    public ProductsFilterValues(Integer pfvId, String pfvValue) {
        this.pfvId = pfvId;
        this.pfvValue = pfvValue;
    }

    public Integer getPfvId() {
        return pfvId;
    }

    public void setPfvId(Integer pfvId) {
        this.pfvId = pfvId;
    }

    public String getPfvValue() {
        return pfvValue;
    }

    public void setPfvValue(String pfvValue) {
        this.pfvValue = pfvValue;
    }

    public ProductsFilters getPfvFilterId() {
        return pfvFilterId;
    }

    public void setPfvFilterId(ProductsFilters pfvFilterId) {
        this.pfvFilterId = pfvFilterId;
    }

    public Products getPfvProductId() {
        return pfvProductId;
    }

    public void setPfvProductId(Products pfvProductId) {
        this.pfvProductId = pfvProductId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pfvId != null ? pfvId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductsFilterValues)) {
            return false;
        }
        ProductsFilterValues other = (ProductsFilterValues) object;
        if ((this.pfvId == null && other.pfvId != null) || (this.pfvId != null && !this.pfvId.equals(other.pfvId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.items.ProductsFilterValues[ pfvId=" + pfvId + " ]";
    }
    
}
