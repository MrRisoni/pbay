
package models.general;

import com.fasterxml.jackson.annotation.JsonView;
import models.JackSonViewer;
import models.users.BillingAddresses;
import models.sellers.Sellers;
import models.users.ShippingAddresses;

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
    @JsonView({JackSonViewer.IOrder.class, JackSonViewer.IListing.class})
    private Short id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ctr_title")
    @JsonView({JackSonViewer.IOrder.class, JackSonViewer.IListing.class})
    private String title;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ctr_code")
    @JsonView({JackSonViewer.IOrder.class, JackSonViewer.IListing.class})
    private String code;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countryObj", fetch = FetchType.LAZY)
    private Collection<ShippingAddresses> shippingAddressesCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countryObj", fetch = FetchType.LAZY)
    private Collection<BillingAddresses> billingAddressesCollection;

    @JoinColumn(name = "ctr_continent_id", referencedColumnName = "con_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Continents ctrContinentId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countryObj", fetch = FetchType.LAZY)
    private Collection<Sellers> sellersCollection;

    public Countries() {
    }

    public Countries(Short id) {
        this.id = id;
    }

    public Countries(Short id, String ctrTitle, String ctrCode) {
        this.id = id;
        this.title = ctrTitle;
        this.code = ctrCode;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Countries)) {
            return false;
        }
        Countries other = (Countries) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.general.Countries[ ctrId=" + id + " ]";
    }
    
}
