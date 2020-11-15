package models.sellers;

import lombok.Getter;
import lombok.Setter;
import models.orders.Orders;
import models.users.Users;

import java.io.Serializable;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import javax.xml.bind.annotation.XmlTransient;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "seller_reviews")
public class SellerReviews implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "srw_id")
    private Integer id;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Column(name = "srw_opinion")
    private short opinion;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "srw_comment")
    private String comment;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Column(name = "srw_created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @JoinColumn(name = "srw_user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Users userObj;

    @JoinColumn(name = "srw_seller_id", referencedColumnName = "sel_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sellers sellerObj;

    @JoinColumn(name = "srw_order_id", referencedColumnName = "ord_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Orders orderObj;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reviewObj", fetch = FetchType.LAZY)
    private Collection<SellerReviewsCategoriesEval> sellerReviewsCategoriesEvalCollection;

    public SellerReviews() {
    }

    public SellerReviews(Integer srwId) {
        this.id = srwId;
    }

    public SellerReviews(Integer srwId, short srwOpinion, String srwComment, Date srwCreatedAt) {
        this.id = srwId;
        this.opinion = srwOpinion;
        this.comment = srwComment;
        this.createdAt = srwCreatedAt;
    }

    public Users getUserObj() {
        return userObj;
    }

    public void setUserObj(Users userObj) {
        this.userObj = userObj;
    }

    public Sellers getSellerObj() {
        return sellerObj;
    }

    public void setSellerObj(Sellers sellerObj) {
        this.sellerObj = sellerObj;
    }

    public Orders getOrderObj() {
        return orderObj;
    }

    public void setOrderObj(Orders orderObj) {
        this.orderObj = orderObj;
    }

    @XmlTransient
    public Collection<SellerReviewsCategoriesEval> getSellerReviewsCategoriesEvalCollection() {
        return sellerReviewsCategoriesEvalCollection;
    }

    public void setSellerReviewsCategoriesEvalCollection(Collection<SellerReviewsCategoriesEval> sellerReviewsCategoriesEvalCollection) {
        this.sellerReviewsCategoriesEvalCollection = sellerReviewsCategoriesEvalCollection;
    }
}
