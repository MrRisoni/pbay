
package models.users;

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
@Table(name = "billing_addresses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BillingAddresses.findAll", query = "SELECT b FROM BillingAddresses b")})
public class BillingAddresses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bla_id")
    private Long blaId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "bla_city")
    private String blaCity;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "bla_region")
    private String blaRegion;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "bla_street")
    private String streetNam;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "bla_street_no")
    private String streetNo;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "bla_code")
    private String code;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "bla_surname")
    private String surname;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordBilladdressId", fetch = FetchType.LAZY)
    private Collection<Orders> ordersCollection;

    public BillingAddresses() {
    }

    public BillingAddresses(Long blaId) {
        this.blaId = blaId;
    }

    public BillingAddresses(Long blaId, String blaCity, String blaRegion, String blaStreet, String blaStreetNo, String blaCode, String blaSurname, String blaName) {
        this.blaId = blaId;
        this.blaCity = blaCity;
        this.blaRegion = blaRegion;
        this.streetNam = blaStreet;
        this.streetNo = blaStreetNo;
        this.code = blaCode;
        this.surname = blaSurname;
        this.name = blaName;
    }

    public Long getBlaId() {
        return blaId;
    }

    public void setBlaId(Long blaId) {
        this.blaId = blaId;
    }

    public String getBlaCity() {
        return blaCity;
    }

    public void setBlaCity(String blaCity) {
        this.blaCity = blaCity;
    }

    public String getBlaRegion() {
        return blaRegion;
    }

    public void setBlaRegion(String blaRegion) {
        this.blaRegion = blaRegion;
    }

    public String getStreetNam() {
        return streetNam;
    }

    public void setStreetNam(String streetNam) {
        this.streetNam = streetNam;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (blaId != null ? blaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BillingAddresses)) {
            return false;
        }
        BillingAddresses other = (BillingAddresses) object;
        if ((this.blaId == null && other.blaId != null) || (this.blaId != null && !this.blaId.equals(other.blaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.users.BillingAddresses[ blaId=" + blaId + " ]";
    }
    
}
