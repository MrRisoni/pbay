package models.orders;

import lombok.Getter;
import lombok.Setter;
import models.general.Currencies;
import models.general.Paymethods;
import models.sellers.SellerReviews;
import models.users.BillingAddresses;
import models.users.ShippingAddresses;
import models.users.Users;

import java.io.Serializable;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;


import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "orders")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Getter
    @Setter
    @Column
    private String bankTransactionId;

    @Getter
    @Setter
    @Column
    private BigDecimal total;

    @Getter
    @Setter
    @Column
    private BigDecimal goodsTotal;

    @Getter
    @Setter
    @Column
    private BigDecimal shipTotal;

    @Getter
    @Setter
    @Column
    private BigDecimal fee;

    @Getter
    @Setter
    @CreationTimestamp
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Getter
    @Setter

    @Column
    private short isSuccess;

    @Getter
    @Setter
    @Column
    private short isVoid;

    @Getter
    @Setter
    @Column
    private String currency_code;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderObj", fetch = FetchType.LAZY)
    private Collection<SellerReviews> sellerReviewsCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderObj", fetch = FetchType.LAZY)
    private Collection<OrderItems> orderItemsCollection;

    @Getter
    @Setter
    @JoinColumn(name = "ord_user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Users userObj;

    @Getter
    @Setter
    @JoinColumn(name = "ord_shipaddress_id", referencedColumnName = "shp_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ShippingAddresses shipAddressObj;

    @Getter
    @Setter
    @JoinColumn(name = "ord_billaddress_id", referencedColumnName = "bla_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BillingAddresses billAddressObj;

    @Getter
    @Setter
    @JoinColumn(name = "ord_paymethod_id", referencedColumnName = "pm_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Paymethods payMethodObj;

    public Orders() {
    }

    public Orders(Long ordId) {
        this.id = ordId;
    }

    public Orders(Long ordId, String ordBankTransactionId, BigDecimal ordTotal, BigDecimal ordGoodsTotal, BigDecimal ordShipTotal, BigDecimal ordFee,  Date ordCreated, short ordSuccess, short ordVoid) {
        this.id = ordId;
        this.bankTransactionId = ordBankTransactionId;
        this.total = ordTotal;
        this.goodsTotal = ordGoodsTotal;
        this.shipTotal = ordShipTotal;
        this.fee = ordFee;
        this.createdAt = ordCreated;
        this.isSuccess = ordSuccess;
        this.isVoid = ordVoid;
    }

    @XmlTransient
    public Collection<SellerReviews> getSellerReviewsCollection() {
        return sellerReviewsCollection;
    }

    public void setSellerReviewsCollection(Collection<SellerReviews> sellerReviewsCollection) {
        this.sellerReviewsCollection = sellerReviewsCollection;
    }

    @XmlTransient
    public Collection<OrderItems> getOrderItemsCollection() {
        return orderItemsCollection;
    }

    public void setOrderItemsCollection(Collection<OrderItems> orderItemsCollection) {
        this.orderItemsCollection = orderItemsCollection;
    }
}
