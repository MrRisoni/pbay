package models.sellers;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import models.orders.OrderItems;
import models.users.Users;
import models.general.Countries;
import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "sellers")
public class Sellers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Getter
    @Setter
    @Column
    private String title;

    @Getter
    @Setter
    @Column
    private String ssn;

    @Getter
    @Setter
    @Column
    private BigDecimal avgStars;

    @Getter
    @Setter
    @Column
    private String country_code;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sellerObj", fetch = FetchType.LAZY)
    private Collection<SellerReviews> sellerReviewsCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sellerObj", fetch = FetchType.LAZY)
    private Collection<OrderItems> orderItemsCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sellerObj", fetch = FetchType.LAZY)
    private Collection<Selling> sellingCollection;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Users userObj;

    public Sellers() {
    }

    public Sellers(Integer selId) {
        this.id = selId;
    }

    public Sellers(Integer selId, String selTitle, String selSsn, BigDecimal selStarsAvg, String country_code) {
        this.id = selId;
        this.title = selTitle;
        this.ssn = selSsn;
        this.avgStars = selStarsAvg;
        this.country_code = country_code;
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
}