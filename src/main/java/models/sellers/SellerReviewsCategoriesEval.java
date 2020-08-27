
package models.sellers;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
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
    private Integer srceId;

    @Basic(optional = false)
    @NotNull
    @Column(name = "srce_rating")
    private BigDecimal srceRating;

    @JoinColumn(name = "srce_category_id", referencedColumnName = "swrc_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SellerReviewCategories srceCategoryId;

    @JoinColumn(name = "srce_review_id", referencedColumnName = "srw_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SellerReviews srceReviewId;

    public SellerReviewsCategoriesEval() {
    }

    public SellerReviewsCategoriesEval(Integer srceId) {
        this.srceId = srceId;
    }

    public SellerReviewsCategoriesEval(Integer srceId, BigDecimal srceRating) {
        this.srceId = srceId;
        this.srceRating = srceRating;
    }

    public Integer getSrceId() {
        return srceId;
    }

    public void setSrceId(Integer srceId) {
        this.srceId = srceId;
    }

    public BigDecimal getSrceRating() {
        return srceRating;
    }

    public void setSrceRating(BigDecimal srceRating) {
        this.srceRating = srceRating;
    }

    public SellerReviewCategories getSrceCategoryId() {
        return srceCategoryId;
    }

    public void setSrceCategoryId(SellerReviewCategories srceCategoryId) {
        this.srceCategoryId = srceCategoryId;
    }

    public SellerReviews getSrceReviewId() {
        return srceReviewId;
    }

    public void setSrceReviewId(SellerReviews srceReviewId) {
        this.srceReviewId = srceReviewId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (srceId != null ? srceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SellerReviewsCategoriesEval)) {
            return false;
        }
        SellerReviewsCategoriesEval other = (SellerReviewsCategoriesEval) object;
        if ((this.srceId == null && other.srceId != null) || (this.srceId != null && !this.srceId.equals(other.srceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.sellers.SellerReviewsCategoriesEval[ srceId=" + srceId + " ]";
    }
    
}
