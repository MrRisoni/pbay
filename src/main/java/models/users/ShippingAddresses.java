
package models.users;

import com.fasterxml.jackson.annotation.JsonView;
import models.JackSonViewer;
import models.orders.Orders;
import models.general.Countries;

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
@Table(name = "shipping_addresses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShippingAddresses.findAll", query = "SELECT s FROM ShippingAddresses s")})
public class ShippingAddresses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "shp_id")
    @JsonView(JackSonViewer.IOrder.class)
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "shp_city")
    @JsonView(JackSonViewer.IOrder.class)
    private String city;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "shp_region")
    @JsonView(JackSonViewer.IOrder.class)
    private String region;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "shp_street")
    @JsonView(JackSonViewer.IOrder.class)
    private String street;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "shp_street_no")
    @JsonView(JackSonViewer.IOrder.class)
    private String streetNo;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "shp_code")
    @JsonView(JackSonViewer.IOrder.class)
    private String code;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "shp_surname")
    @JsonView(JackSonViewer.IOrder.class)
    private String surname;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "shp_name")
    @JsonView(JackSonViewer.IOrder.class)
    private String name;

    @JoinColumn(name = "shp_user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Users userObj;

    @JoinColumn(name = "shp_country_id", referencedColumnName = "ctr_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonView(JackSonViewer.IOrder.class)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShippingAddresses)) {
            return false;
        }
        ShippingAddresses other = (ShippingAddresses) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.users.ShippingAddresses[ shpId=" + id + " ]";
    }
    
}
