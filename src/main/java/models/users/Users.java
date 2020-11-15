
package models.users;

import lombok.Getter;
import lombok.Setter;
import models.orders.Biddings;
import models.orders.Orders;
import models.orders.Reviews;
import models.sellers.SellerReviews;
import models.sellers.Sellers;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import javax.xml.bind.annotation.XmlTransient;


@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "users")

@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;

    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;

    @Getter
    @Setter
    @Size(max = 100)
    @Column(name = "remember_token")
    private String rememberToken;

    @Getter
    @Setter
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Getter
    @Setter
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userObj", fetch = FetchType.LAZY)
    private Collection<SellerReviews> sellerReviewsCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userObj", fetch = FetchType.LAZY)
    private Collection<ShippingAddresses> shippingAddressesCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userObj", fetch = FetchType.LAZY)
    private Collection<Reviews> reviewsCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userObj", fetch = FetchType.LAZY)
    private Collection<Biddings> biddingsCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userObj", fetch = FetchType.LAZY)
    private Collection<BillingAddresses> billingAddressesCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userObj", fetch = FetchType.LAZY)
    private Collection<Orders> ordersCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userObj", fetch = FetchType.LAZY)
    private Collection<Sellers> sellersCollection;

    public Users() {
    }

    public Users(Long id) {
        this.id = id;
    }

    public Users(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }


    @XmlTransient
    public Collection<SellerReviews> getSellerReviewsCollection() {
        return sellerReviewsCollection;
    }

    public void setSellerReviewsCollection(Collection<SellerReviews> sellerReviewsCollection) {
        this.sellerReviewsCollection = sellerReviewsCollection;
    }

    @XmlTransient
    public Collection<ShippingAddresses> getShippingAddressesCollection() {
        return shippingAddressesCollection;
    }

    public void setShippingAddressesCollection(Collection<ShippingAddresses> shippingAddressesCollection) {
        this.shippingAddressesCollection = shippingAddressesCollection;
    }

    @XmlTransient
    public Collection<Reviews> getReviewsCollection() {
        return reviewsCollection;
    }

    public void setReviewsCollection(Collection<Reviews> reviewsCollection) {
        this.reviewsCollection = reviewsCollection;
    }

    @XmlTransient
    public Collection<Biddings> getBiddingsCollection() {
        return biddingsCollection;
    }

    public void setBiddingsCollection(Collection<Biddings> biddingsCollection) {
        this.biddingsCollection = biddingsCollection;
    }

    @XmlTransient
    public Collection<BillingAddresses> getBillingAddressesCollection() {
        return billingAddressesCollection;
    }

    public void setBillingAddressesCollection(Collection<BillingAddresses> billingAddressesCollection) {
        this.billingAddressesCollection = billingAddressesCollection;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    @XmlTransient
    public Collection<Sellers> getSellersCollection() {
        return sellersCollection;
    }

    public void setSellersCollection(Collection<Sellers> sellersCollection) {
        this.sellersCollection = sellersCollection;
    }

}
