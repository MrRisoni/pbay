
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
@Table(name = "countries")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Countries.findAll", query = "SELECT c FROM Countries c")})
public class Countries implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ctr_id")
    private Short ctrId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ctr_title")
    private String ctrTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ctr_code")
    private String ctrCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shpCountryId", fetch = FetchType.LAZY)
    private Collection<ShippingAddresses> shippingAddressesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "blaCountryId", fetch = FetchType.LAZY)
    private Collection<BillingAddresses> billingAddressesCollection;
    @JoinColumn(name = "ctr_continent_id", referencedColumnName = "con_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Continents ctrContinentId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "selCountryId", fetch = FetchType.LAZY)
    private Collection<Sellers> sellersCollection;

    public Countries() {
    }

    public Countries(Short ctrId) {
        this.ctrId = ctrId;
    }

    public Countries(Short ctrId, String ctrTitle, String ctrCode) {
        this.ctrId = ctrId;
        this.ctrTitle = ctrTitle;
        this.ctrCode = ctrCode;
    }

    public Short getCtrId() {
        return ctrId;
    }

    public void setCtrId(Short ctrId) {
        this.ctrId = ctrId;
    }

    public String getCtrTitle() {
        return ctrTitle;
    }

    public void setCtrTitle(String ctrTitle) {
        this.ctrTitle = ctrTitle;
    }

    public String getCtrCode() {
        return ctrCode;
    }

    public void setCtrCode(String ctrCode) {
        this.ctrCode = ctrCode;
    }

    @XmlTransient
    public Collection<ShippingAddresses> getShippingAddressesCollection() {
        return shippingAddressesCollection;
    }

    public void setShippingAddressesCollection(Collection<ShippingAddresses> shippingAddressesCollection) {
        this.shippingAddressesCollection = shippingAddressesCollection;
    }

    @XmlTransient
    public Collection<BillingAddresses> getBillingAddressesCollection() {
        return billingAddressesCollection;
    }

    public void setBillingAddressesCollection(Collection<BillingAddresses> billingAddressesCollection) {
        this.billingAddressesCollection = billingAddressesCollection;
    }

    public Continents getCtrContinentId() {
        return ctrContinentId;
    }

    public void setCtrContinentId(Continents ctrContinentId) {
        this.ctrContinentId = ctrContinentId;
    }

    @XmlTransient
    public Collection<Sellers> getSellersCollection() {
        return sellersCollection;
    }

    public void setSellersCollection(Collection<Sellers> sellersCollection) {
        this.sellersCollection = sellersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ctrId != null ? ctrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Countries)) {
            return false;
        }
        Countries other = (Countries) object;
        if ((this.ctrId == null && other.ctrId != null) || (this.ctrId != null && !this.ctrId.equals(other.ctrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Countries[ ctrId=" + ctrId + " ]";
    }
    
}
