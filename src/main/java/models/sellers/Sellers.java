
package models.sellers;

import models.orders.OrderItems;
import models.users.Users;
import models.general.Countries;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "sellers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sellers.findAll", query = "SELECT s FROM Sellers s")})
public class Sellers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sel_id")
    private Integer selId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 125)
    @Column(name = "sel_title")
    private String selTitle;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "sel_ssn")
    private String selSsn;

    @Basic(optional = false)
    @NotNull
    @Column(name = "sel_stars_avg")
    private BigDecimal selStarsAvg;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "srwSellerId", fetch = FetchType.LAZY)
    private Collection<SellerReviews> sellerReviewsCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itmSellerId", fetch = FetchType.LAZY)
    private Collection<OrderItems> orderItemsCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sllSellerId", fetch = FetchType.LAZY)
    private Collection<Selling> sellingCollection;

    @JoinColumn(name = "seller_usr_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Users sellerUsrId;

    @JoinColumn(name = "sel_country_id", referencedColumnName = "ctr_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Countries selCountryId;

    public Sellers() {
    }

    public Sellers(Integer selId) {
        this.selId = selId;
    }

    public Sellers(Integer selId, String selTitle, String selSsn, BigDecimal selStarsAvg) {
        this.selId = selId;
        this.selTitle = selTitle;
        this.selSsn = selSsn;
        this.selStarsAvg = selStarsAvg;
    }

    public Integer getSelId() {
        return selId;
    }

    public void setSelId(Integer selId) {
        this.selId = selId;
    }

    public String getSelTitle() {
        return selTitle;
    }

    public void setSelTitle(String selTitle) {
        this.selTitle = selTitle;
    }

    public String getSelSsn() {
        return selSsn;
    }

    public void setSelSsn(String selSsn) {
        this.selSsn = selSsn;
    }

    public BigDecimal getSelStarsAvg() {
        return selStarsAvg;
    }

    public void setSelStarsAvg(BigDecimal selStarsAvg) {
        this.selStarsAvg = selStarsAvg;
    }

    @XmlTransient
    public Collection<SellerReviews> getSellerReviewsCollection() {
        return sellerReviewsCollection;
    }

    public void setSellerReviewsCollection(Collection<SellerReviews> sellerReviewsCollection) {
        this.sellerReviewsCollection = sellerReviewsCollection;
    }

    @XmlTransient
    public Collection<OrderItems> getOrderItemsCollection() {
        return orderItemsCollection;
    }

    public void setOrderItemsCollection(Collection<OrderItems> orderItemsCollection) {
        this.orderItemsCollection = orderItemsCollection;
    }

    @XmlTransient
    public Collection<Selling> getSellingCollection() {
        return sellingCollection;
    }

    public void setSellingCollection(Collection<Selling> sellingCollection) {
        this.sellingCollection = sellingCollection;
    }

    public Users getSellerUsrId() {
        return sellerUsrId;
    }

    public void setSellerUsrId(Users sellerUsrId) {
        this.sellerUsrId = sellerUsrId;
    }

    public Countries getSelCountryId() {
        return selCountryId;
    }

    public void setSelCountryId(Countries selCountryId) {
        this.selCountryId = selCountryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (selId != null ? selId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sellers)) {
            return false;
        }
        Sellers other = (Sellers) object;
        if ((this.selId == null && other.selId != null) || (this.selId != null && !this.selId.equals(other.selId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.sellers.Sellers[ selId=" + selId + " ]";
    }
    
}
