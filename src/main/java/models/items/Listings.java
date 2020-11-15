
package models.items;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import models.JackSonViewer;
import models.general.Currencies;
import models.orders.Biddings;
import models.sellers.Selling;

import java.io.Serializable;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "listings")

public class Listings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lis_id")
    @JsonView(JackSonViewer.IListing.class)
    private Long id;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Column(name = "lis_price")
    @JsonView(JackSonViewer.IListing.class)
    private BigDecimal price;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Column(name = "lis_fee_eur")
    @JsonView(JackSonViewer.IListing.class)
    private BigDecimal feeEuro;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Column(name = "lis_from")
    @Temporal(TemporalType.DATE)
    @JsonView(JackSonViewer.IListing.class)
    private Date activeFrom;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Column(name = "lis_to")
    @Temporal(TemporalType.DATE)
    @JsonView(JackSonViewer.IListing.class)
    private Date activeUntil;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Column(name = "lis_watching")
    @JsonView(JackSonViewer.IListing.class)
    private short numWatchers;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Column(name = "lis_is_auction")
    @JsonView(JackSonViewer.IListing.class)
    private short isAuction;

    @JoinColumn(name = "lis_currency_id", referencedColumnName = "cur_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonView(JackSonViewer.IListing.class)
    private Currencies currencyObj;

    @JoinColumn(name = "lis_selling_id", referencedColumnName = "sll_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonView(JackSonViewer.IListing.class)
    private Selling sellingObj;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "listingObj", fetch = FetchType.LAZY)
    private Collection<Biddings> biddingsCollection;

    public Listings() {
    }

    public Listings(Long lisId) {
        this.id = lisId;
    }

    public Listings(Long lisId, BigDecimal lisPrice, BigDecimal lisFeeEur, Date lisFrom, Date lisTo, short lisWatching, short lisIsAuction) {
        this.id = lisId;
        this.price = lisPrice;
        this.feeEuro = lisFeeEur;
        this.activeFrom = lisFrom;
        this.activeUntil = lisTo;
        this.numWatchers = lisWatching;
        this.isAuction = lisIsAuction;
    }

    public Currencies getCurrencyObj() {
        return currencyObj;
    }

    public void setCurrencyObj(Currencies currencyObj) {
        this.currencyObj = currencyObj;
    }

    public Selling getSellingObj() {
        return sellingObj;
    }

    public void setSellingObj(Selling sellingObj) {
        this.sellingObj = sellingObj;
    }

    @XmlTransient
    public Collection<Biddings> getBiddingsCollection() {
        return biddingsCollection;
    }

    public void setBiddingsCollection(Collection<Biddings> biddingsCollection) {
        this.biddingsCollection = biddingsCollection;
    }

}
