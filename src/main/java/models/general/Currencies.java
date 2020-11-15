package models.general;

import lombok.Getter;
import lombok.Setter;
import models.orders.Biddings;
import models.items.Listings;
import models.orders.OrderItems;
import models.orders.Orders;

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
@Table(name = "currencies")
public class Currencies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cur_id")
    private Short id;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "cur_code")
    private String code;

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

    public Currencies(Short curId, String curCode) {
        this.id = curId;
        this.code = curCode;
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
}
