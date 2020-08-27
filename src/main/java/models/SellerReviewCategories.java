
package models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "seller_review_categories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SellerReviewCategories.findAll", query = "SELECT s FROM SellerReviewCategories s")})
public class SellerReviewCategories implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "swrc_id")
    private Short swrcId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "swrc_title")
    private String swrcTitle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "srceCategoryId", fetch = FetchType.LAZY)
    private Collection<SellerReviewsCategoriesEval> sellerReviewsCategoriesEvalCollection;

    public SellerReviewCategories() {
    }

    public SellerReviewCategories(Short swrcId) {
        this.swrcId = swrcId;
    }

    public SellerReviewCategories(Short swrcId, String swrcTitle) {
        this.swrcId = swrcId;
        this.swrcTitle = swrcTitle;
    }

    public Short getSwrcId() {
        return swrcId;
    }

    public void setSwrcId(Short swrcId) {
        this.swrcId = swrcId;
    }

    public String getSwrcTitle() {
        return swrcTitle;
    }

    public void setSwrcTitle(String swrcTitle) {
        this.swrcTitle = swrcTitle;
    }

    @XmlTransient
    public Collection<SellerReviewsCategoriesEval> getSellerReviewsCategoriesEvalCollection() {
        return sellerReviewsCategoriesEvalCollection;
    }

    public void setSellerReviewsCategoriesEvalCollection(Collection<SellerReviewsCategoriesEval> sellerReviewsCategoriesEvalCollection) {
        this.sellerReviewsCategoriesEvalCollection = sellerReviewsCategoriesEvalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (swrcId != null ? swrcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SellerReviewCategories)) {
            return false;
        }
        SellerReviewCategories other = (SellerReviewCategories) object;
        if ((this.swrcId == null && other.swrcId != null) || (this.swrcId != null && !this.swrcId.equals(other.swrcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.SellerReviewCategories[ swrcId=" + swrcId + " ]";
    }
    
}
