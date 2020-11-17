package models.users;

import lombok.Getter;
import lombok.Setter;
import models.orders.Orders;
import models.general.Countries;

import java.io.Serializable;

import javax.persistence.*;
import java.util.Collection;


import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "billing_addresses")
public class BillingAddresses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Getter
    @Setter
    @Column
    private String city;

    @Getter
    @Setter
    @Column
    private String region;

    @Getter
    @Setter
    @Column
    private String streetNam;

    @Getter
    @Setter
    @Column
    private String streetNo;

    @Getter
    @Setter
    @Column
    private String code;

    @Getter
    @Setter
    @Column
    private String surname;

    @Getter
    @Setter
    @Column
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
