package entities;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "listings")
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lis_id")
    private int id;

    @Column(name = "lis_price")
    private float price;

    @Column(name = "lis_fee_eur")
    private float feeEur;

    @Column(name = "lis_from")
    @Temporal(TemporalType.TIMESTAMP)
    private Date from;

    @Column(name = "lis_to")
    @Temporal(TemporalType.TIMESTAMP)
    private Date to;

    @Column(name = "lis_watching")
    private int watching;

    @Column(name = "lis_is_auction")
    private boolean isAuction;

    public Listing(int id, float price, float feeEur, Date from, Date to, int watching, boolean isAuction) {
        this.id = id;
        this.price = price;
        this.feeEur = feeEur;
        this.from = from;
        this.to = to;
        this.watching = watching;
        this.isAuction = isAuction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getFeeEur() {
        return feeEur;
    }

    public void setFeeEur(float feeEur) {
        this.feeEur = feeEur;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public int getWatching() {
        return watching;
    }

    public void setWatching(int watching) {
        this.watching = watching;
    }

    public boolean isAuction() {
        return isAuction;
    }

    public void setAuction(boolean auction) {
        isAuction = auction;
    }
}
