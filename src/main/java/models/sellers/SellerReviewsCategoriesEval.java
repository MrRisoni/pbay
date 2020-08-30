
package models.sellers;

import java.io.Serializable;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.*;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "seller_reviews_categories_eval")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SellerReviewsCategoriesEval.findAll", query = "SELECT s FROM SellerReviewsCategoriesEval s")})
public class SellerReviewsCategoriesEval implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "srce_id")
    private Integer id;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SellerReviewsCategoriesEval)) {
            return false;
        }
        SellerReviewsCategoriesEval other = (SellerReviewsCategoriesEval) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.sellers.SellerReviewsCategoriesEval[ srceId=" + id + " ]";
    }
    
}
