
package models.items;

import models.sellers.Selling;

import java.io.Serializable;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "shipping_country_forbidden")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShippingCountryForbidden.findAll", query = "SELECT s FROM ShippingCountryForbidden s")})
public class ShippingCountryForbidden implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "shf_id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "shf_country_code")
    private String countryCode;

    @JoinColumn(name = "shf_selling_id", referencedColumnName = "sll_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Selling sellingObj;

    public ShippingCountryForbidden() {
    }

    public ShippingCountryForbidden(Integer shfId) {
        this.id = shfId;
    }

    public ShippingCountryForbidden(Integer shfId, String shfCountryCode) {
        this.id = shfId;
        this.countryCode = shfCountryCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Selling getSellingObj() {
        return sellingObj;
    }

    public void setSellingObj(Selling sellingObj) {
        this.sellingObj = sellingObj;
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
        if (!(object instanceof ShippingCountryForbidden)) {
            return false;
        }
        ShippingCountryForbidden other = (ShippingCountryForbidden) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.items.ShippingCountryForbidden[ shfId=" + id + " ]";
    }
    
}
