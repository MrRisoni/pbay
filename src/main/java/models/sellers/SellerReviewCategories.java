
package models.sellers;

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
    private Short id;

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

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SellerReviewCategories)) {
            return false;
        }
        SellerReviewCategories other = (SellerReviewCategories) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.sellers.SellerReviewCategories[ swrcId=" + id + " ]";
    }
    
}
