
package models.orders;

import models.items.Listings;
import models.general.Currencies;
import models.users.Users;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "biddings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Biddings.findAll", query = "SELECT b FROM Biddings b")})
public class Biddings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bid_id")
    private Integer bidId;

    @Basic(optional = false)
    @NotNull
    @Column(name = "bid_price")
    private BigDecimal bidPrice;

    @Basic(optional = false)
    @NotNull
    @Column(name = "bid_price_eur")
    private BigDecimal bidPriceEur;

    @Basic(optional = false)
    @NotNull
    @Column(name = "bid_created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bidCreatedAt;

    @Basic(optional = false)
    @NotNull
    @Column(name = "bid_active")
    private short bidActive;

    @JoinColumn(name = "bid_currency_id", referencedColumnName = "cur_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Currencies bidCurrencyId;

    @JoinColumn(name = "bid_listing_id", referencedColumnName = "lis_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Listings bidListingId;

    @JoinColumn(name = "bid_user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Users bidUserId;

    public Biddings() {
    }

    public Biddings(Integer bidId) {
        this.bidId = bidId;
    }

    public Biddings(Integer bidId, BigDecimal bidPrice, BigDecimal bidPriceEur, Date bidCreatedAt, short bidActive) {
        this.bidId = bidId;
        this.bidPrice = bidPrice;
        this.bidPriceEur = bidPriceEur;
        this.bidCreatedAt = bidCreatedAt;
        this.bidActive = bidActive;
    }

    public Integer getBidId() {
        return bidId;
    }

    public void setBidId(Integer bidId) {
        this.bidId = bidId;
    }

    public BigDecimal getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(BigDecimal bidPrice) {
        this.bidPrice = bidPrice;
    }

    public BigDecimal getBidPriceEur() {
        return bidPriceEur;
    }

    public void setBidPriceEur(BigDecimal bidPriceEur) {
        this.bidPriceEur = bidPriceEur;
    }

    public Date getBidCreatedAt() {
        return bidCreatedAt;
    }

    public void setBidCreatedAt(Date bidCreatedAt) {
        this.bidCreatedAt = bidCreatedAt;
    }

    public short getBidActive() {
        return bidActive;
    }

    public void setBidActive(short bidActive) {
        this.bidActive = bidActive;
    }

    public Currencies getBidCurrencyId() {
        return bidCurrencyId;
    }

    public void setBidCurrencyId(Currencies bidCurrencyId) {
        this.bidCurrencyId = bidCurrencyId;
    }

    public Listings getBidListingId() {
        return bidListingId;
    }

    public void setBidListingId(Listings bidListingId) {
        this.bidListingId = bidListingId;
    }

    public Users getBidUserId() {
        return bidUserId;
    }

    public void setBidUserId(Users bidUserId) {
        this.bidUserId = bidUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bidId != null ? bidId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Biddings)) {
            return false;
        }
        Biddings other = (Biddings) object;
        if ((this.bidId == null && other.bidId != null) || (this.bidId != null && !this.bidId.equals(other.bidId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.orders.Biddings[ bidId=" + bidId + " ]";
    }
    
}
