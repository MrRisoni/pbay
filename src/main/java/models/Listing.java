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

    @Formula("(SELECT b.bid_price FROM biddings b WHERE b.bid_listing_id=lis_id AND b.bid_active=1 ORDER BY b.bid_created_at DESC LIMIT 1 )")
    private BigDecimal highestBid;

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
}
