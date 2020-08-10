package models;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.*;


@Entity
@Table(name="listings")
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lis_id")
    private Long id;

    @Column(name="lis_price")
    private BigDecimal price;

    @Formula("(SELECT b.bid_price FROM biddings b WHERE b.bid_listing_id=lis_id AND b.bid_active=1 ORDER BY b.bid_price_eur  DESC LIMIT 1 )")
    private BigDecimal highestBid;

    @Formula("(SELECT MAX(b.bid_price_eur) FROM biddings b WHERE b.bid_listing_id=lis_id AND b.bid_active=1 )")
    private BigDecimal highestBidEuro;

    @Formula("(SELECT b.bid_created_at " +
            "FROM biddings b " +
            "WHERE b.bid_listing_id =lis_id  " +
            "AND b.bid_active =1 " +
            "ORDER BY b.bid_price_eur DESC LIMIT 1 )")
    private Date highestBidAt;

    @Formula("(SELECT COUNT(w.lwi_id) FROM listing_watching w WHERE w.lwi_listing_id=lis_id)")
    private int numWatchers;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lis_selling_id")
    private SellItem sellItmObj;


    public Listing() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getHighestBid() {
        return highestBid;
    }

    public BigDecimal getHighestBidEuro() {
        return highestBidEuro;
    }

    public Date getHighestBidAt() {
        return highestBidAt;
    }

    public SellItem getSellItmObj() {
        return sellItmObj;
    }

    public void setSellItmObj(SellItem sellItmObj) {
        this.sellItmObj = sellItmObj;
    }
}
