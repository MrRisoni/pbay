package models.sellers;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Collection;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "seller_review_categories")
public class SellerReviewCategories implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Getter
    @Setter
    @Column
    private String title;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryObj", fetch = FetchType.LAZY)
    private Collection<SellerReviewsCategoriesEval> sellerReviewsCategoriesEvalCollection;

    public SellerReviewCategories() {
    }

    public SellerReviewCategories(Long swrcId) {
        this.id = swrcId;
    }

    public SellerReviewCategories(Long swrcId, String swrcTitle) {
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
