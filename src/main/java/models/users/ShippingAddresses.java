package models.users;

import lombok.Getter;
import lombok.Setter;
import models.orders.Orders;
import models.general.Countries;

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
@Table(name = "shipping_addresses")
public class ShippingAddresses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "shp_id")
    private Long id;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "shp_city")
    private String city;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "shp_region")
    private String region;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "shp_street")
    private String street;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "shp_street_no")
    private String streetNo;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "shp_code")
    private String code;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "shp_surname")
    private String surname;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "shp_name")
    private String name;

    @JoinColumn(name = "shp_user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Users userObj;

    @JoinColumn(name = "shp_country_id", referencedColumnName = "ctr_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)

    private Countries countryObj;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shipAddressObj", fetch = FetchType.LAZY)
    private Collection<Orders> ordersCollection;

    public ShippingAddresses() {
    }

    public ShippingAddresses(Long shpId) {
        this.id = shpId;
    }

    public ShippingAddresses(Long shpId, String shpCity, String shpRegion, String shpStreet, String shpStreetNo, String shpCode, String shpSurname, String shpName) {
        this.id = shpId;
        this.city = shpCity;
        this.region = shpRegion;
        this.street = shpStreet;
        this.streetNo = shpStreetNo;
        this.code = shpCode;
        this.surname = shpSurname;
        this.name = shpName;
    }

    public Users getUserObj() {
        return userObj;
    }

    public void setUserObj(Users userObj) {
        this.userObj = userObj;
    }

    public Countries getCountryObj() {
        return countryObj;
    }

    public void setCountryObj(Countries countryObj) {
        this.countryObj = countryObj;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }
}
