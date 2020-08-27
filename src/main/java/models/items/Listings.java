
package models.items;

import models.general.Currencies;
import models.orders.Biddings;
import models.sellers.Selling;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "listings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Listings.findAll", query = "SELECT l FROM Listings l")})
public class Listings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lis_id")
    private Long lisId;


    @Basic(optional = false)
    @NotNull
    @Column(name = "lis_price")
    private BigDecimal lisPrice;

    @Basic(optional = false)
    @NotNull
    @Column(name = "lis_fee_eur")

    private BigDecimal lisFeeEur;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lis_from")
    @Temporal(TemporalType.DATE)
    private Date lisFrom;

    @Basic(optional = false)
    @NotNull
    @Column(name = "lis_to")
    @Temporal(TemporalType.DATE)
    private Date lisTo;

    @Basic(optional = false)
    @NotNull
    @Column(name = "lis_watching")
    private short lisWatching;

    @Basic(optional = false)
    @NotNull
    @Column(name = "lis_is_auction")
    private short lisIsAuction;

    @JoinColumn(name = "lis_currency_id", referencedColumnName = "cur_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Currencies lisCurrencyId;

    @JoinColumn(name = "lis_selling_id", referencedColumnName = "sll_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Selling lisSellingId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bidListingId", fetch = FetchType.LAZY)
    private Collection<Biddings> biddingsCollection;

    public Listings() {
    }

    public Listings(Long lisId) {
        this.lisId = lisId;
    }

    public Listings(Long lisId, BigDecimal lisPrice, BigDecimal lisFeeEur, Date lisFrom, Date lisTo, short lisWatching, short lisIsAuction) {
        this.lisId = lisId;
        this.lisPrice = lisPrice;
        this.lisFeeEur = lisFeeEur;
        this.lisFrom = lisFrom;
        this.lisTo = lisTo;
        this.lisWatching = lisWatching;
        this.lisIsAuction = lisIsAuction;
    }

    public Long getLisId() {
        return lisId;
    }

    public void setLisId(Long lisId) {
        this.lisId = lisId;
    }

    public BigDecimal getLisPrice() {
        return lisPrice;
    }

    public void setLisPrice(BigDecimal lisPrice) {
        this.lisPrice = lisPrice;
    }

    public BigDecimal getLisFeeEur() {
        return lisFeeEur;
    }

    public void setLisFeeEur(BigDecimal lisFeeEur) {
        this.lisFeeEur = lisFeeEur;
    }

    public Date getLisFrom() {
        return lisFrom;
    }

    public void setLisFrom(Date lisFrom) {
        this.lisFrom = lisFrom;
    }

    public Date getLisTo() {
        return lisTo;
    }

    public void setLisTo(Date lisTo) {
        this.lisTo = lisTo;
    }

    public short getLisWatching() {
        return lisWatching;
    }

    public void setLisWatching(short lisWatching) {
        this.lisWatching = lisWatching;
    }

    public short getLisIsAuction() {
        return lisIsAuction;
    }

    public void setLisIsAuction(short lisIsAuction) {
        this.lisIsAuction = lisIsAuction;
    }

    public Currencies getLisCurrencyId() {
        return lisCurrencyId;
    }

    public void setLisCurrencyId(Currencies lisCurrencyId) {
        this.lisCurrencyId = lisCurrencyId;
    }

    public Selling getLisSellingId() {
        return lisSellingId;
    }

    public void setLisSellingId(Selling lisSellingId) {
        this.lisSellingId = lisSellingId;
    }

    @XmlTransient
    public Collection<Biddings> getBiddingsCollection() {
        return biddingsCollection;
    }

    public void setBiddingsCollection(Collection<Biddings> biddingsCollection) {
        this.biddingsCollection = biddingsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lisId != null ? lisId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Listings)) {
            return false;
        }
        Listings other = (Listings) object;
        if ((this.lisId == null && other.lisId != null) || (this.lisId != null && !this.lisId.equals(other.lisId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.items.Listings[ lisId=" + lisId + " ]";
    }
    
}
