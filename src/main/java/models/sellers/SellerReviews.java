
package models.sellers;

import models.orders.Orders;
import models.users.Users;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "seller_reviews")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SellerReviews.findAll", query = "SELECT s FROM SellerReviews s")})
public class SellerReviews implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "srw_id")
    private Integer srwId;

    @Basic(optional = false)
    @NotNull
    @Column(name = "srw_opinion")
    private short srwOpinion;

    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "srw_comment")
    private String srwComment;

    @Basic(optional = false)
    @NotNull
    @Column(name = "srw_created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date srwCreatedAt;

    @JoinColumn(name = "srw_user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Users srwUserId;

    @JoinColumn(name = "srw_seller_id", referencedColumnName = "sel_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sellers srwSellerId;

    @JoinColumn(name = "srw_order_id", referencedColumnName = "ord_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Orders srwOrderId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "srceReviewId", fetch = FetchType.LAZY)
    private Collection<SellerReviewsCategoriesEval> sellerReviewsCategoriesEvalCollection;

    public SellerReviews() {
    }

    public SellerReviews(Integer srwId) {
        this.srwId = srwId;
    }

    public SellerReviews(Integer srwId, short srwOpinion, String srwComment, Date srwCreatedAt) {
        this.srwId = srwId;
        this.srwOpinion = srwOpinion;
        this.srwComment = srwComment;
        this.srwCreatedAt = srwCreatedAt;
    }

    public Integer getSrwId() {
        return srwId;
    }

    public void setSrwId(Integer srwId) {
        this.srwId = srwId;
    }

    public short getSrwOpinion() {
        return srwOpinion;
    }

    public void setSrwOpinion(short srwOpinion) {
        this.srwOpinion = srwOpinion;
    }

    public String getSrwComment() {
        return srwComment;
    }

    public void setSrwComment(String srwComment) {
        this.srwComment = srwComment;
    }

    public Date getSrwCreatedAt() {
        return srwCreatedAt;
    }

    public void setSrwCreatedAt(Date srwCreatedAt) {
        this.srwCreatedAt = srwCreatedAt;
    }

    public Users getSrwUserId() {
        return srwUserId;
    }

    public void setSrwUserId(Users srwUserId) {
        this.srwUserId = srwUserId;
    }

    public Sellers getSrwSellerId() {
        return srwSellerId;
    }

    public void setSrwSellerId(Sellers srwSellerId) {
        this.srwSellerId = srwSellerId;
    }

    public Orders getSrwOrderId() {
        return srwOrderId;
    }

    public void setSrwOrderId(Orders srwOrderId) {
        this.srwOrderId = srwOrderId;
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
        hash += (srwId != null ? srwId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SellerReviews)) {
            return false;
        }
        SellerReviews other = (SellerReviews) object;
        if ((this.srwId == null && other.srwId != null) || (this.srwId != null && !this.srwId.equals(other.srwId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.sellers.SellerReviews[ srwId=" + srwId + " ]";
    }
    
}
