package models.sellers;

import lombok.Getter;
import lombok.Setter;
import models.orders.Orders;
import models.users.Users;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "seller_reviews")
public class SellerReviews implements Serializable {

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
    private short opinion;

    @Getter
    @Setter
    @Column
    private String comment;

    @Getter
    @Setter
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Users userObj;

    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sellers sellerObj;

    @JoinColumn(name = "order_id", referencedColumnName = "id")
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
