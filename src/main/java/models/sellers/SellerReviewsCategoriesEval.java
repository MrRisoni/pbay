package models.sellers;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "seller_reviews_categories_eval")
public class SellerReviewsCategoriesEval implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "srce_id")
    private Integer id;

    @Getter
    @Setter
    @Column(name = "srce_rating")
    private BigDecimal rating;

    @JoinColumn(name = "srce_category_id", referencedColumnName = "swrc_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SellerReviewCategories categoryObj;

    @JoinColumn(name = "srce_review_id", referencedColumnName = "srw_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SellerReviews reviewObj;

    public SellerReviewsCategoriesEval() {
    }

    public SellerReviewsCategoriesEval(Integer srceId) {
        this.id = srceId;
    }

    public SellerReviewsCategoriesEval(Integer srceId, BigDecimal srceRating) {
        this.id = srceId;
        this.rating = srceRating;
    }

    public SellerReviewCategories getCategoryObj() {
        return categoryObj;
    }

    public void setCategoryObj(SellerReviewCategories categoryObj) {
        this.categoryObj = categoryObj;
    }

    public SellerReviews getReviewObj() {
        return reviewObj;
    }

    public void setReviewObj(SellerReviews reviewObj) {
        this.reviewObj = reviewObj;
    }
}
