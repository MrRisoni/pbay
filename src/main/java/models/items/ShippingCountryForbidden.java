
package models.items;

import models.sellers.Selling;

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
    private Integer shfId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "shf_country_code")
    private String shfCountryCode;

    @JoinColumn(name = "shf_selling_id", referencedColumnName = "sll_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Selling shfSellingId;

    public ShippingCountryForbidden() {
    }

    public ShippingCountryForbidden(Integer shfId) {
        this.shfId = shfId;
    }

    public ShippingCountryForbidden(Integer shfId, String shfCountryCode) {
        this.shfId = shfId;
        this.shfCountryCode = shfCountryCode;
    }

    public Integer getShfId() {
        return shfId;
    }

    public void setShfId(Integer shfId) {
        this.shfId = shfId;
    }

    public String getShfCountryCode() {
        return shfCountryCode;
    }

    public void setShfCountryCode(String shfCountryCode) {
        this.shfCountryCode = shfCountryCode;
    }

    public Selling getShfSellingId() {
        return shfSellingId;
    }

    public void setShfSellingId(Selling shfSellingId) {
        this.shfSellingId = shfSellingId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shfId != null ? shfId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShippingCountryForbidden)) {
            return false;
        }
        ShippingCountryForbidden other = (ShippingCountryForbidden) object;
        if ((this.shfId == null && other.shfId != null) || (this.shfId != null && !this.shfId.equals(other.shfId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.items.ShippingCountryForbidden[ shfId=" + shfId + " ]";
    }
    
}
