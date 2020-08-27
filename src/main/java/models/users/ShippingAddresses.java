
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
    private Long shpId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "shp_city")
    private String shpCity;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "shp_region")
    private String shpRegion;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "shp_street")
    private String shpStreet;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "shp_street_no")
    private String shpStreetNo;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "shp_code")
    private String shpCode;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "shp_surname")
    private String shpSurname;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "shp_name")
    private String shpName;

    @JoinColumn(name = "shp_user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Users shpUserId;

    @JoinColumn(name = "shp_country_id", referencedColumnName = "ctr_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Countries shpCountryId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordShipaddressId", fetch = FetchType.LAZY)
    private Collection<Orders> ordersCollection;

    public ShippingAddresses() {
    }

    public ShippingAddresses(Long shpId) {
        this.shpId = shpId;
    }

    public ShippingAddresses(Long shpId, String shpCity, String shpRegion, String shpStreet, String shpStreetNo, String shpCode, String shpSurname, String shpName) {
        this.shpId = shpId;
        this.shpCity = shpCity;
        this.shpRegion = shpRegion;
        this.shpStreet = shpStreet;
        this.shpStreetNo = shpStreetNo;
        this.shpCode = shpCode;
        this.shpSurname = shpSurname;
        this.shpName = shpName;
    }

    public Long getShpId() {
        return shpId;
    }

    public void setShpId(Long shpId) {
        this.shpId = shpId;
    }

    public String getShpCity() {
        return shpCity;
    }

    public void setShpCity(String shpCity) {
        this.shpCity = shpCity;
    }

    public String getShpRegion() {
        return shpRegion;
    }

    public void setShpRegion(String shpRegion) {
        this.shpRegion = shpRegion;
    }

    public String getShpStreet() {
        return shpStreet;
    }

    public void setShpStreet(String shpStreet) {
        this.shpStreet = shpStreet;
    }

    public String getShpStreetNo() {
        return shpStreetNo;
    }

    public void setShpStreetNo(String shpStreetNo) {
        this.shpStreetNo = shpStreetNo;
    }

    public String getShpCode() {
        return shpCode;
    }

    public void setShpCode(String shpCode) {
        this.shpCode = shpCode;
    }

    public String getShpSurname() {
        return shpSurname;
    }

    public void setShpSurname(String shpSurname) {
        this.shpSurname = shpSurname;
    }

    public String getShpName() {
        return shpName;
    }

    public void setShpName(String shpName) {
        this.shpName = shpName;
    }

    public Users getShpUserId() {
        return shpUserId;
    }

    public void setShpUserId(Users shpUserId) {
        this.shpUserId = shpUserId;
    }

    public Countries getShpCountryId() {
        return shpCountryId;
    }

    public void setShpCountryId(Countries shpCountryId) {
        this.shpCountryId = shpCountryId;
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
        hash += (shpId != null ? shpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShippingAddresses)) {
            return false;
        }
        ShippingAddresses other = (ShippingAddresses) object;
        if ((this.shpId == null && other.shpId != null) || (this.shpId != null && !this.shpId.equals(other.shpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.users.ShippingAddresses[ shpId=" + shpId + " ]";
    }
    
}
