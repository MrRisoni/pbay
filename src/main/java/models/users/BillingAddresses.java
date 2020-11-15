
package models.users;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import models.JackSonViewer;
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
@Table(name = "billing_addresses")
public class BillingAddresses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bla_id")
    private Long id;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "bla_city")
    private String city;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "bla_region")
    private String region;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "bla_street")
    private String streetNam;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "bla_street_no")
    private String streetNo;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "bla_code")
    private String code;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "bla_surname")
    private String surname;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "bla_name")
    private String name;

    @JoinColumn(name = "bla_country_id", referencedColumnName = "ctr_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Countries countryObj;

    @JoinColumn(name = "bla_user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Users userObj;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billAddressObj", fetch = FetchType.LAZY)
    private Collection<Orders> ordersCollection;

    public BillingAddresses() {
    }

    public BillingAddresses(Long blaId) {
        this.id = blaId;
    }

    public BillingAddresses(Long blaId, String blaCity, String blaRegion, String blaStreet, String blaStreetNo, String blaCode, String blaSurname, String blaName) {
        this.id = blaId;
        this.city = blaCity;
        this.region = blaRegion;
        this.streetNam = blaStreet;
        this.streetNo = blaStreetNo;
        this.code = blaCode;
        this.surname = blaSurname;
        this.name = blaName;
    }


    public Countries getCountryObj() {
        return countryObj;
    }

    public void setCountryObj(Countries countryObj) {
        this.countryObj = countryObj;
    }

    public Users getUserObj() {
        return userObj;
    }

    public void setUserObj(Users userObj) {
        this.userObj = userObj;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

}
