package models.orders;

import lombok.Getter;
import lombok.Setter;
import models.sellers.Sellers;
import models.sellers.Selling;
import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "order_items")
public class OrderItems implements Serializable {

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
    private short quantity;

    @Getter
    @Setter
    @Column
    private String trackingNums;

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
    private BigDecimal rate;

    @Getter
    @Setter
    @Column
    private short isVoid;

    @Getter
    @Setter
    @Column
    private String currency_code;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderItemObj", fetch = FetchType.LAZY)
    private Collection<Reviews> reviewsCollection;

    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Orders orderObj;

    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Selling itemObj;

    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sellers sellerObj;

    @JoinColumn(name = "status_id", referencedColumnName = "id")
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
