package models.sellers;

import lombok.Getter;
import lombok.Setter;
import models.items.*;
import models.orders.OrderItems;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Collection;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "selling")
public class Selling implements Serializable {

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
    private int quantity;

    @Getter
    @Setter
    @Column
    private String mailer_company;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sellingObj", fetch = FetchType.LAZY)
    private Collection<ShippingCostsExceptions> shippingCostsExceptionsCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sellingObj", fetch = FetchType.LAZY)
    private Collection<Listings> listingsCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sellingObj", fetch = FetchType.LAZY)
    private Collection<ShippingCosts> shippingCostsCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemObj", fetch = FetchType.LAZY)
    private Collection<OrderItems> orderItemsCollection;

    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Products productObj;

    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sellers sellerObj;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sellingObj", fetch = FetchType.LAZY)
    private Collection<ShippingCountryForbidden> shippingCountryForbiddenCollection;

    public Selling() {
    }

    public Selling(Long sllId) {
        this.id = sllId;
    }

    public Selling(Long sllId, int sllQuantity, String sllMailerCo) {
        this.id = sllId;
        this.quantity = sllQuantity;
        this.mailer_company = sllMailerCo;
    }

    @XmlTransient
    public Collection<ShippingCostsExceptions> getShippingCostsExceptionsCollection() {
        return shippingCostsExceptionsCollection;
    }

    public void setShippingCostsExceptionsCollection(Collection<ShippingCostsExceptions> shippingCostsExceptionsCollection) {
        this.shippingCostsExceptionsCollection = shippingCostsExceptionsCollection;
    }

    @XmlTransient
    public Collection<Listings> getListingsCollection() {
        return listingsCollection;
    }

    public void setListingsCollection(Collection<Listings> listingsCollection) {
        this.listingsCollection = listingsCollection;
    }

    @XmlTransient
    public Collection<ShippingCosts> getShippingCostsCollection() {
        return shippingCostsCollection;
    }

    public void setShippingCostsCollection(Collection<ShippingCosts> shippingCostsCollection) {
        this.shippingCostsCollection = shippingCostsCollection;
    }

    @XmlTransient
    public Collection<OrderItems> getOrderItemsCollection() {
        return orderItemsCollection;
    }

    public void setOrderItemsCollection(Collection<OrderItems> orderItemsCollection) {
        this.orderItemsCollection = orderItemsCollection;
    }

    public Products getProductObj() {
        return productObj;
    }

    public void setProductObj(Products productObj) {
        this.productObj = productObj;
    }

    public Sellers getSellerObj() {
        return sellerObj;
    }

    public void setSellerObj(Sellers sellerObj) {
        this.sellerObj = sellerObj;
    }

    @XmlTransient
    public Collection<ShippingCountryForbidden> getShippingCountryForbiddenCollection() {
        return shippingCountryForbiddenCollection;
    }

    public void setShippingCountryForbiddenCollection(Collection<ShippingCountryForbidden> shippingCountryForbiddenCollection) {
        this.shippingCountryForbiddenCollection = shippingCountryForbiddenCollection;
    }
}
