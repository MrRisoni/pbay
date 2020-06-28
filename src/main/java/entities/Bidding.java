package entities;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "biddings")
public class Bidding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bid_id")
    private int id;

    @Column(name = "bid_price")
    private float price;

    @Column(name = "bid_price_eur")
    private float priceEur;

    @Column(name = "bid_created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date createdAt;

    @Column(name = "bid_active")
    private boolean active;

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

    public float getPriceEur() {
        return priceEur;
    }

    public void setPriceEur(float priceEur) {
        this.priceEur = priceEur;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Bidding(int id, float price, float priceEur, Date createdAt, boolean active) {

        this.id = id;
        this.price = price;
        this.priceEur = priceEur;
        this.createdAt = createdAt;
        this.active = active;
    }
}
