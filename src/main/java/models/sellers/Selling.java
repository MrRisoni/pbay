
package models.sellers;

import com.fasterxml.jackson.annotation.JsonView;
import models.JackSonViewer;
import models.items.*;
import models.orders.OrderItems;

import java.io.Serializable;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.*;
import java.util.Collection;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "selling")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Selling.findAll", query = "SELECT s FROM Selling s")})
public class Selling implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sll_id")
    @JsonView(JackSonViewer.IListing.class)
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "sll_quantity")
    @JsonView(JackSonViewer.IListing.class)
    private int quantity;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productObj", fetch = FetchType.LAZY)
    private Collection<OrderItems> orderItemsCollection;

    @JoinColumn(name = "sll_product_id", referencedColumnName = "prod_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonView({JackSonViewer.IListing.class, JackSonViewer.IOrder.class})
    private Products productObj;

    @JoinColumn(name = "sll_seller_id", referencedColumnName = "sel_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonView({JackSonViewer.IListing.class, JackSonViewer.IOrder.class})
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSllMailerCo() {
        return sllMailerCo;
    }

    public void setSllMailerCo(String sllMailerCo) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Selling)) {
            return false;
        }
        Selling other = (Selling) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.sellers.Selling[ sllId=" + id + " ]";
    }
    
}
