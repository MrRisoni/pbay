
package models.sellers;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import models.JackSonViewer;
import models.items.*;
import models.orders.OrderItems;

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
@Table(name = "selling")
public class Selling implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sll_id")
    @JsonView(JackSonViewer.IListing.class)
    private Integer id;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Column(name = "sll_quantity")
    @JsonView(JackSonViewer.IListing.class)
    private int quantity;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "sll_mailer_co")
    @JsonView(JackSonViewer.IListing.class)
    private String sllMailerCo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sellingObj", fetch = FetchType.LAZY)
    private Collection<ShippingCostsExceptions> shippingCostsExceptionsCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sellingObj", fetch = FetchType.LAZY)
    private Collection<Listings> listingsCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sellingObj", fetch = FetchType.LAZY)
    private Collection<ShippingCosts> shippingCostsCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemObj", fetch = FetchType.LAZY)
    private Collection<OrderItems> orderItemsCollection;

    @JoinColumn(name = "sll_product_id", referencedColumnName = "prod_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonView({JackSonViewer.IListing.class})
    private Products productObj;

    @JoinColumn(name = "sll_seller_id", referencedColumnName = "sel_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonView({JackSonViewer.IListing.class})
    private Sellers sellerObj;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sellingObj", fetch = FetchType.LAZY)
    private Collection<ShippingCountryForbidden> shippingCountryForbiddenCollection;

    public Selling() {
    }

    public Selling(Integer sllId) {
        this.id = sllId;
    }

    public Selling(Integer sllId, int sllQuantity, String sllMailerCo) {
        this.id = sllId;
        this.quantity = sllQuantity;
        this.sllMailerCo = sllMailerCo;
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
