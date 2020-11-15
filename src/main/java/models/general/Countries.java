
package models.general;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
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

import javax.xml.bind.annotation.XmlTransient;


@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "countries")
public class Countries implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ctr_id")
    @JsonView({ JackSonViewer.IListing.class})
    private Short id;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ctr_title")
    @JsonView({ JackSonViewer.IListing.class})
    private String title;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ctr_code")
    @JsonView({ JackSonViewer.IListing.class})
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


}
