
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
    private String blaStreet;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "bla_street_no")
    private String blaStreetNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "bla_code")
    private String blaCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "bla_surname")
    private String blaSurname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "bla_name")
    private String blaName;
    @JoinColumn(name = "bla_country_id", referencedColumnName = "ctr_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Countries blaCountryId;
    @JoinColumn(name = "bla_user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Users blaUserId;
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
        this.blaStreet = blaStreet;
        this.blaStreetNo = blaStreetNo;
        this.blaCode = blaCode;
        this.blaSurname = blaSurname;
        this.blaName = blaName;
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

    public String getBlaStreet() {
        return blaStreet;
    }

    public void setBlaStreet(String blaStreet) {
        this.blaStreet = blaStreet;
    }

    public String getBlaStreetNo() {
        return blaStreetNo;
    }

    public void setBlaStreetNo(String blaStreetNo) {
        this.blaStreetNo = blaStreetNo;
    }

    public String getBlaCode() {
        return blaCode;
    }

    public void setBlaCode(String blaCode) {
        this.blaCode = blaCode;
    }

    public String getBlaSurname() {
        return blaSurname;
    }

    public void setBlaSurname(String blaSurname) {
        this.blaSurname = blaSurname;
    }

    public String getBlaName() {
        return blaName;
    }

    public void setBlaName(String blaName) {
        this.blaName = blaName;
    }

    public Countries getBlaCountryId() {
        return blaCountryId;
    }

    public void setBlaCountryId(Countries blaCountryId) {
        this.blaCountryId = blaCountryId;
    }

    public Users getBlaUserId() {
        return blaUserId;
    }

    public void setBlaUserId(Users blaUserId) {
        this.blaUserId = blaUserId;
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
        return "models.BillingAddresses[ blaId=" + blaId + " ]";
    }
    
}
