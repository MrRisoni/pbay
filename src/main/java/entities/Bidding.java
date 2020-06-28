package entities;

import javax.persistence.*;


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
    private int active;

}
