
package models.orders;

import com.fasterxml.jackson.annotation.JsonView;
import models.JackSonViewer;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "order_items")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderItems.findAll", query = "SELECT o FROM OrderItems o")})
public class OrderItems implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "itm_id")
    @JsonView(JackSonViewer.IOrder.class)
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "itm_quantity")
    @JsonView(JackSonViewer.IOrder.class)
    private short quantity;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 225)
    @Column(name = "itm_tracking_nums")
    @JsonView(JackSonViewer.IOrder.class)
    private String trackingNums;

    @Basic(optional = false)
    @NotNull
    @Column(name = "itm_total")
    @JsonView(JackSonViewer.IOrder.class)
    private BigDecimal total;

    @Basic(optional = false)
    @NotNull
    @Column(name = "itm_goods_total")
    @JsonView(JackSonViewer.IOrder.class)
    private BigDecimal goodsTotal;

    @Basic(optional = false)
    @NotNull
    @Column(name = "itm_ship_total")
    @JsonView(JackSonViewer.IOrder.class)
    private BigDecimal shipTotal;

    @Basic(optional = false)
    @NotNull
    @Column(name = "itm_void")
    @JsonView(JackSonViewer.IOrder.class)
    private short isVoid;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderItemObj", fetch = FetchType.LAZY)
    private Collection<Reviews> reviewsCollection;

    @JoinColumn(name = "itm_currency_id", referencedColumnName = "cur_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonView(JackSonViewer.IOrder.class)
    private Currencies currencyObj;

    @JoinColumn(name = "itm_order_id", referencedColumnName = "ord_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Orders orderObj;

    @JoinColumn(name = "itm_product_id", referencedColumnName = "sll_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonView(JackSonViewer.IOrder.class)
    private Selling itemObj;

    @JoinColumn(name = "itm_seller_id", referencedColumnName = "sel_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonView(JackSonViewer.IOrder.class)
    private Sellers sellerObj;

    @JoinColumn(name = "itm_status_id", referencedColumnName = "stat_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonView(JackSonViewer.IOrder.class)
    private OrderStatuses statusObj;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemObj", fetch = FetchType.LAZY)
    @JsonView(JackSonViewer.IOrder.class)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    public String getTrackingNums() {
        return trackingNums;
    }

    public void setTrackingNums(String trackingNums) {
        this.trackingNums = trackingNums;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getGoodsTotal() {
        return goodsTotal;
    }

    public void setGoodsTotal(BigDecimal goodsTotal) {
        this.goodsTotal = goodsTotal;
    }

    public BigDecimal getShipTotal() {
        return shipTotal;
    }

    public void setShipTotal(BigDecimal shipTotal) {
        this.shipTotal = shipTotal;
    }

    public short getIsVoid() {
        return isVoid;
    }

    public void setIsVoid(short isVoid) {
        this.isVoid = isVoid;
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
