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
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "orders")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ord_id")

    private Long id;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ord_bank_transaction_id")
    private String bankTransactionId;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Column(name = "ord_total")
    private BigDecimal total;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Column(name = "ord_goods_total")
    private BigDecimal goodsTotal;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Column(name = "ord_ship_total")
    private BigDecimal shipTotal;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Column(name = "ord_fee")
    private BigDecimal fee;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @CreationTimestamp
    @Column(name = "ord_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Column(name = "ord_success")
    private short isSuccess;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Column(name = "ord_void")
    private short isVoid;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderObj", fetch = FetchType.LAZY)
    private Collection<SellerReviews> sellerReviewsCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderObj", fetch = FetchType.LAZY)
    private Collection<OrderItems> orderItemsCollection;

    @Getter
    @Setter
    @JoinColumn(name = "ord_currency_id", referencedColumnName = "cur_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Currencies currencyObj;

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
