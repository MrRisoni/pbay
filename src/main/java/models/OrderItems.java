
package models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
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
    private Long itmId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "itm_quantity")
    private short itmQuantity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 225)
    @Column(name = "itm_tracking_nums")
    private String itmTrackingNums;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "itm_total")
    private BigDecimal itmTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "itm_goods_total")
    private BigDecimal itmGoodsTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "itm_ship_total")
    private BigDecimal itmShipTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "itm_void")
    private short itmVoid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "revOrdItemId", fetch = FetchType.LAZY)
    private Collection<Reviews> reviewsCollection;
    @JoinColumn(name = "itm_currency_id", referencedColumnName = "cur_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Currencies itmCurrencyId;
    @JoinColumn(name = "itm_order_id", referencedColumnName = "ord_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Orders itmOrderId;
    @JoinColumn(name = "itm_product_id", referencedColumnName = "sll_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Selling itmProductId;
    @JoinColumn(name = "itm_seller_id", referencedColumnName = "sel_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sellers itmSellerId;
    @JoinColumn(name = "itm_status_id", referencedColumnName = "stat_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private OrderStatuses itmStatusId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itmhItemId", fetch = FetchType.LAZY)
    private Collection<OrderItemTrackHistory> orderItemTrackHistoryCollection;

    public OrderItems() {
    }

    public OrderItems(Long itmId) {
        this.itmId = itmId;
    }

    public OrderItems(Long itmId, short itmQuantity, String itmTrackingNums, BigDecimal itmTotal, BigDecimal itmGoodsTotal, BigDecimal itmShipTotal, short itmVoid) {
        this.itmId = itmId;
        this.itmQuantity = itmQuantity;
        this.itmTrackingNums = itmTrackingNums;
        this.itmTotal = itmTotal;
        this.itmGoodsTotal = itmGoodsTotal;
        this.itmShipTotal = itmShipTotal;
        this.itmVoid = itmVoid;
    }

    public Long getItmId() {
        return itmId;
    }

    public void setItmId(Long itmId) {
        this.itmId = itmId;
    }

    public short getItmQuantity() {
        return itmQuantity;
    }

    public void setItmQuantity(short itmQuantity) {
        this.itmQuantity = itmQuantity;
    }

    public String getItmTrackingNums() {
        return itmTrackingNums;
    }

    public void setItmTrackingNums(String itmTrackingNums) {
        this.itmTrackingNums = itmTrackingNums;
    }

    public BigDecimal getItmTotal() {
        return itmTotal;
    }

    public void setItmTotal(BigDecimal itmTotal) {
        this.itmTotal = itmTotal;
    }

    public BigDecimal getItmGoodsTotal() {
        return itmGoodsTotal;
    }

    public void setItmGoodsTotal(BigDecimal itmGoodsTotal) {
        this.itmGoodsTotal = itmGoodsTotal;
    }

    public BigDecimal getItmShipTotal() {
        return itmShipTotal;
    }

    public void setItmShipTotal(BigDecimal itmShipTotal) {
        this.itmShipTotal = itmShipTotal;
    }

    public short getItmVoid() {
        return itmVoid;
    }

    public void setItmVoid(short itmVoid) {
        this.itmVoid = itmVoid;
    }

    @XmlTransient
    public Collection<Reviews> getReviewsCollection() {
        return reviewsCollection;
    }

    public void setReviewsCollection(Collection<Reviews> reviewsCollection) {
        this.reviewsCollection = reviewsCollection;
    }

    public Currencies getItmCurrencyId() {
        return itmCurrencyId;
    }

    public void setItmCurrencyId(Currencies itmCurrencyId) {
        this.itmCurrencyId = itmCurrencyId;
    }

    public Orders getItmOrderId() {
        return itmOrderId;
    }

    public void setItmOrderId(Orders itmOrderId) {
        this.itmOrderId = itmOrderId;
    }

    public Selling getItmProductId() {
        return itmProductId;
    }

    public void setItmProductId(Selling itmProductId) {
        this.itmProductId = itmProductId;
    }

    public Sellers getItmSellerId() {
        return itmSellerId;
    }

    public void setItmSellerId(Sellers itmSellerId) {
        this.itmSellerId = itmSellerId;
    }

    public OrderStatuses getItmStatusId() {
        return itmStatusId;
    }

    public void setItmStatusId(OrderStatuses itmStatusId) {
        this.itmStatusId = itmStatusId;
    }

    @XmlTransient
    public Collection<OrderItemTrackHistory> getOrderItemTrackHistoryCollection() {
        return orderItemTrackHistoryCollection;
    }

    public void setOrderItemTrackHistoryCollection(Collection<OrderItemTrackHistory> orderItemTrackHistoryCollection) {
        this.orderItemTrackHistoryCollection = orderItemTrackHistoryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itmId != null ? itmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderItems)) {
            return false;
        }
        OrderItems other = (OrderItems) object;
        if ((this.itmId == null && other.itmId != null) || (this.itmId != null && !this.itmId.equals(other.itmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.OrderItems[ itmId=" + itmId + " ]";
    }
    
}
