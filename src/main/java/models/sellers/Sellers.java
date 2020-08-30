
package models.sellers;

import com.fasterxml.jackson.annotation.JsonView;
import models.JackSonViewer;
import models.orders.OrderItems;
import models.users.Users;
import models.general.Countries;

import java.io.Serializable;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
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
    @JsonView({JackSonViewer.IOrder.class, JackSonViewer.IListing.class})
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 125)
    @Column(name = "sel_title")
    @JsonView({JackSonViewer.IOrder.class, JackSonViewer.IListing.class})
    private String title;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "sel_ssn")
    private String ssn;

    @Basic(optional = false)
    @NotNull
    @Column(name = "sel_stars_avg")
    @JsonView(JackSonViewer.IListing.class)
    private BigDecimal avgStars;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sellerObj", fetch = FetchType.LAZY)
    private Collection<SellerReviews> sellerReviewsCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sellberObj", fetch = FetchType.LAZY)
    private Collection<OrderItems> orderItemsCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sellerObj", fetch = FetchType.LAZY)
    private Collection<Selling> sellingCollection;

    @JoinColumn(name = "seller_usr_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonView(JackSonViewer.IListing.class)
    private Users userObj;

    @JoinColumn(name = "sel_country_id", referencedColumnName = "ctr_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonView({JackSonViewer.IOrder.class, JackSonViewer.IListing.class})
    private Countries countryObj;

    public Sellers() {
    }

    public Sellers(Integer selId) {
        this.id = selId;
    }

    public Sellers(Integer selId, String selTitle, String selSsn, BigDecimal selStarsAvg) {
        this.id = selId;
        this.title = selTitle;
        this.ssn = selSsn;
        this.avgStars = selStarsAvg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public BigDecimal getAvgStars() {
        return avgStars;
    }

    public void setAvgStars(BigDecimal avgStars) {
        this.avgStars = avgStars;
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

    public Users getUserObj() {
        return userObj;
    }

    public void setUserObj(Users userObj) {
        this.userObj = userObj;
    }

    public Countries getCountryObj() {
        return countryObj;
    }

    public void setCountryObj(Countries countryObj) {
        this.countryObj = countryObj;
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
        if (!(object instanceof Sellers)) {
            return false;
        }
        Sellers other = (Sellers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.sellers.Sellers[ selId=" + id + " ]";
    }
    
}
