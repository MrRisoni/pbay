
package models.sellers;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.*;
import java.util.Collection;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import javax.xml.bind.annotation.XmlTransient;


@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "seller_review_categories")
public class SellerReviewCategories implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "swrc_id")
    private Short id;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "swrc_title")
    private String title;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryObj", fetch = FetchType.LAZY)
    private Collection<SellerReviewsCategoriesEval> sellerReviewsCategoriesEvalCollection;

    public SellerReviewCategories() {
    }

    public SellerReviewCategories(Short swrcId) {
        this.id = swrcId;
    }

    public SellerReviewCategories(Short swrcId, String swrcTitle) {
        this.id = swrcId;
        this.title = swrcTitle;
    }

    @XmlTransient
    public Collection<SellerReviewsCategoriesEval> getSellerReviewsCategoriesEvalCollection() {
        return sellerReviewsCategoriesEvalCollection;
    }

    public void setSellerReviewsCategoriesEvalCollection(Collection<SellerReviewsCategoriesEval> sellerReviewsCategoriesEvalCollection) {
        this.sellerReviewsCategoriesEvalCollection = sellerReviewsCategoriesEvalCollection;
    }

}
