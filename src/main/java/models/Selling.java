
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
    private Integer sllId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sll_quantity")
    private int sllQuantity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "sll_mailer_co")
    private String sllMailerCo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shcxSellingId", fetch = FetchType.LAZY)
    private Collection<ShippingCostsExceptions> shippingCostsExceptionsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lisSellingId", fetch = FetchType.LAZY)
    private Collection<Listings> listingsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shcSellingId", fetch = FetchType.LAZY)
    private Collection<ShippingCosts> shippingCostsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itmProductId", fetch = FetchType.LAZY)
    private Collection<OrderItems> orderItemsCollection;
    @JoinColumn(name = "sll_product_id", referencedColumnName = "prod_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Products sllProductId;
    @JoinColumn(name = "sll_seller_id", referencedColumnName = "sel_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sellers sllSellerId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shfSellingId", fetch = FetchType.LAZY)
    private Collection<ShippingCountryForbidden> shippingCountryForbiddenCollection;

    public Selling() {
    }

    public Selling(Integer sllId) {
        this.sllId = sllId;
    }

    public Selling(Integer sllId, int sllQuantity, String sllMailerCo) {
        this.sllId = sllId;
        this.sllQuantity = sllQuantity;
        this.sllMailerCo = sllMailerCo;
    }

    public Integer getSllId() {
        return sllId;
    }

    public void setSllId(Integer sllId) {
        this.sllId = sllId;
    }

    public int getSllQuantity() {
        return sllQuantity;
    }

    public void setSllQuantity(int sllQuantity) {
        this.sllQuantity = sllQuantity;
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

    public Products getSllProductId() {
        return sllProductId;
    }

    public void setSllProductId(Products sllProductId) {
        this.sllProductId = sllProductId;
    }

    public Sellers getSllSellerId() {
        return sllSellerId;
    }

    public void setSllSellerId(Sellers sllSellerId) {
        this.sllSellerId = sllSellerId;
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
        hash += (sllId != null ? sllId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Selling)) {
            return false;
        }
        Selling other = (Selling) object;
        if ((this.sllId == null && other.sllId != null) || (this.sllId != null && !this.sllId.equals(other.sllId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Selling[ sllId=" + sllId + " ]";
    }
    
}
