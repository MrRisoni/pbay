
package models.sellers;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.*;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;



@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "seller_reviews_categories_eval")

public class SellerReviewsCategoriesEval implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "srce_id")
    private Integer id;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
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
