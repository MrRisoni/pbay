package models.orders;

import lombok.Getter;
import lombok.Setter;
import models.general.Currencies;
import models.sellers.Sellers;
import models.sellers.Selling;

import java.io.Serializable;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import javax.xml.bind.annotation.XmlTransient;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "order_items")
public class OrderItems implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "itm_id")
    private Long id;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Column(name = "itm_quantity")
    private short quantity;

    @Getter
    @Setter
    @Basic(optional = false)
    @Size(min = 1, max = 225)
    @Column(name = "itm_tracking_nums")
    private String trackingNums;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Column(name = "itm_total")
    private BigDecimal total;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Column(name = "itm_goods_total")
    private BigDecimal goodsTotal;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Column(name = "itm_ship_total")
    private BigDecimal shipTotal;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Column(name = "itm_rate")
    private BigDecimal rate;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Column(name = "itm_void")
    private short isVoid;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderItemObj", fetch = FetchType.LAZY)
    private Collection<Reviews> reviewsCollection;

    @JoinColumn(name = "itm_currency_id", referencedColumnName = "cur_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Currencies currencyObj;

    @JoinColumn(name = "itm_order_id", referencedColumnName = "ord_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Orders orderObj;

    @JoinColumn(name = "itm_product_id", referencedColumnName = "sll_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Selling itemObj;

    @JoinColumn(name = "itm_seller_id", referencedColumnName = "sel_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sellers sellerObj;

    @JoinColumn(name = "itm_status_id", referencedColumnName = "stat_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private OrderStatuses statusObj;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemObj", fetch = FetchType.LAZY)

    private Collection<OrderItemTrackHistory> orderItemTrackHistoryCollection;

    public OrderItems() {
    }

    public OrderItems(Long itmId) {
        this.id = itmId;
    }

    public OrderItems(Long itmId, short itmQuantity, String itmTrackingNums, BigDecimal itmTotal, BigDecimal itmGoodsTotal, BigDecimal itmShipTotal, short itmVoid) {
        this.id = itmId;
        this.quantity = itmQuantity;
        this.trackingNums = itmTrackingNums;
        this.total = itmTotal;
        this.goodsTotal = itmGoodsTotal;
        this.shipTotal = itmShipTotal;
        this.isVoid = itmVoid;
    }

    @XmlTransient
    public Collection<Reviews> getReviewsCollection() {
        return reviewsCollection;
    }

    public void setReviewsCollection(Collection<Reviews> reviewsCollection) {
        this.reviewsCollection = reviewsCollection;
    }

    public Currencies getCurrencyObj() {
        return currencyObj;
    }

    public void setCurrencyObj(Currencies currencyObj) {
        this.currencyObj = currencyObj;
    }

    public Orders getOrderObj() {
        return orderObj;
    }

    public void setOrderObj(Orders orderObj) {
        this.orderObj = orderObj;
    }

    public Selling getItemObj() {
        return itemObj;
    }

    public void setItemObj(Selling itemObj) {
        this.itemObj = itemObj;
    }

    public Sellers getSellerObj() {
        return sellerObj;
    }

    public void setSellerObj(Sellers sellerObj) {
        this.sellerObj = sellerObj;
    }

    public OrderStatuses getStatusObj() {
        return statusObj;
    }

    public void setStatusObj(OrderStatuses statusObj) {
        this.statusObj = statusObj;
    }

    @XmlTransient
    public Collection<OrderItemTrackHistory> getOrderItemTrackHistoryCollection() {
        return orderItemTrackHistoryCollection;
    }

    public void setOrderItemTrackHistoryCollection(Collection<OrderItemTrackHistory> orderItemTrackHistoryCollection) {
        this.orderItemTrackHistoryCollection = orderItemTrackHistoryCollection;
    }
}
