package models.items;

import lombok.Getter;
import lombok.Setter;
import models.general.Currencies;
import models.orders.Biddings;
import models.sellers.Selling;

import java.io.Serializable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "listings")
public class Listings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lis_id")
    private Long id;

    @Getter
    @Setter
    @Column(name = "lis_price")
    private BigDecimal price;

    @Getter
    @Setter
    @Column(name = "lis_fee_eur")
    private BigDecimal feeEuro;

    @Getter
    @Setter
    @Column(name = "lis_from")
    @Temporal(TemporalType.DATE)
    private Date activeFrom;

    @Getter
    @Setter
    @Column(name = "lis_to")
    @Temporal(TemporalType.DATE)
    private Date activeUntil;

    @Getter
    @Setter
    @Column(name = "lis_watching")
    private short numWatchers;

    @Getter
    @Setter
    @Column(name = "lis_is_auction")
    private short isAuction;

    @JoinColumn(name = "lis_currency_id", referencedColumnName = "cur_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Currencies currencyObj;

    @JoinColumn(name = "lis_selling_id", referencedColumnName = "sll_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
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
