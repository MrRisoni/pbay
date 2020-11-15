package models.sellers;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import models.orders.OrderItems;
import models.users.Users;
import models.general.Countries;

import java.io.Serializable;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import javax.xml.bind.annotation.XmlTransient;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "sellers")

public class Sellers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sel_id")
    private Integer id;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 125)
    @Column(name = "sel_title")
    private String title;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "sel_ssn")
    private String ssn;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Column(name = "sel_stars_avg")
    private BigDecimal avgStars;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sellerObj", fetch = FetchType.LAZY)
    private Collection<SellerReviews> sellerReviewsCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sellerObj", fetch = FetchType.LAZY)
    private Collection<OrderItems> orderItemsCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sellerObj", fetch = FetchType.LAZY)
    private Collection<Selling> sellingCollection;

    @JoinColumn(name = "seller_usr_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Users userObj;

    @JoinColumn(name = "sel_country_id", referencedColumnName = "ctr_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Countries countryObj;

    public Sellers() {
    }

    public Sellers(Integer selId) {
        this.id = selId;
    }

    public Sellers(Integer selId, String selTitle, String selSsn, BigDecimal selStarsAvg) {
        this.id = selId;
        this.title = selTitle;
        this.ssn = selSsn;
        this.avgStars = selStarsAvg;
    }

    @XmlTransient
    public Collection<SellerReviews> getSellerReviewsCollection() {
        return sellerReviewsCollection;
    }

    public void setSellerReviewsCollection(Collection<SellerReviews> sellerReviewsCollection) {
        this.sellerReviewsCollection = sellerReviewsCollection;
    }

    @XmlTransient
    public Collection<OrderItems> getOrderItemsCollection() {
        return orderItemsCollection;
    }

    public void setOrderItemsCollection(Collection<OrderItems> orderItemsCollection) {
        this.orderItemsCollection = orderItemsCollection;
    }

    @XmlTransient
    public Collection<Selling> getSellingCollection() {
        return sellingCollection;
    }

    public void setSellingCollection(Collection<Selling> sellingCollection) {
        this.sellingCollection = sellingCollection;
    }

    public Users getUserObj() {
        return userObj;
    }

    public void setUserObj(Users userObj) {
        this.userObj = userObj;
    }

    public Countries getCountryObj() {
        return countryObj;
    }

    public void setCountryObj(Countries countryObj) {
        this.countryObj = countryObj;
    }
}
