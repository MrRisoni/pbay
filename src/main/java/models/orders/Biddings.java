package models.orders;

import lombok.Getter;
import lombok.Setter;
import models.items.Listings;
import models.general.Currencies;
import models.users.Users;

import java.io.Serializable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;



@Entity
@Table(name = "biddings")
public class Biddings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Getter
    @Setter
    @Column
    private BigDecimal bidPrice;

    @Getter
    @Setter
    @Column
    private BigDecimal bidPriceEur;

    @Getter
    @Setter
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Getter
    @Setter
    @Column
    private short isActive;

    @JoinColumn(name = "bid_currency_id", referencedColumnName = "cur_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Currencies currencyObj;

    @JoinColumn(name = "bid_listing_id", referencedColumnName = "lis_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Listings listingObj;

    @JoinColumn(name = "bid_user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Users userObj;

    public Biddings() {
    }

    public Biddings(Integer bidId) {
        this.id = bidId;
    }

    public Biddings(Integer bidId, BigDecimal bidPrice, BigDecimal bidPriceEur, Date bidCreatedAt, short bidActive) {
        this.id = bidId;
        this.bidPrice = bidPrice;
        this.bidPriceEur = bidPriceEur;
        this.createdAt = bidCreatedAt;
        this.isActive = bidActive;
    }

    public Currencies getCurrencyObj() {
        return currencyObj;
    }

    public void setCurrencyObj(Currencies currencyObj) {
        this.currencyObj = currencyObj;
    }

    public Listings getListingObj() {
        return listingObj;
    }

    public void setListingObj(Listings listingObj) {
        this.listingObj = listingObj;
    }

    public Users getUserObj() {
        return userObj;
    }

    public void setUserObj(Users userObj) {
        this.userObj = userObj;
    }
}
