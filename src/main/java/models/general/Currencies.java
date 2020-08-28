
package models.general;

import com.fasterxml.jackson.annotation.JsonView;
import models.JackSonViewer;
import models.orders.Biddings;
import models.items.Listings;
import models.orders.OrderItems;
import models.orders.Orders;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "currencies")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Currencies.findAll", query = "SELECT c FROM Currencies c")})
public class Currencies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cur_id")
    @JsonView(JackSonViewer.IOrder.class)
    private Short id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "cur_code")
    @JsonView(JackSonViewer.IOrder.class)
    private String code;

    @Basic(optional = false)
    @NotNull
    @Column(name = "cur_rate")
    private BigDecimal rate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "currencyObj", fetch = FetchType.LAZY)
    private Collection<Listings> listingsCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "currencyObj", fetch = FetchType.LAZY)
    private Collection<OrderItems> orderItemsCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "currencyObj", fetch = FetchType.LAZY)
    private Collection<Biddings> biddingsCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "currencyObj", fetch = FetchType.LAZY)
    private Collection<Orders> ordersCollection;

    public Currencies() {
    }

    public Currencies(Short curId) {
        this.id = curId;
    }

    public Currencies(Short curId, String curCode, BigDecimal curRate) {
        this.id = curId;
        this.code = curCode;
        this.rate = curRate;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @XmlTransient
    public Collection<Listings> getListingsCollection() {
        return listingsCollection;
    }

    public void setListingsCollection(Collection<Listings> listingsCollection) {
        this.listingsCollection = listingsCollection;
    }

    @XmlTransient
    public Collection<OrderItems> getOrderItemsCollection() {
        return orderItemsCollection;
    }

    public void setOrderItemsCollection(Collection<OrderItems> orderItemsCollection) {
        this.orderItemsCollection = orderItemsCollection;
    }

    @XmlTransient
    public Collection<Biddings> getBiddingsCollection() {
        return biddingsCollection;
    }

    public void setBiddingsCollection(Collection<Biddings> biddingsCollection) {
        this.biddingsCollection = biddingsCollection;
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
        if (!(object instanceof Currencies)) {
            return false;
        }
        Currencies other = (Currencies) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.general.Currencies[ curId=" + id + " ]";
    }
    
}
