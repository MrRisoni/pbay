
package models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o")})
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ord_id")
    private Long ordId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ord_bank_transaction_id")
    private String ordBankTransactionId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "ord_total")
    private BigDecimal ordTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ord_goods_total")
    private BigDecimal ordGoodsTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ord_ship_total")
    private BigDecimal ordShipTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ord_fee")
    private BigDecimal ordFee;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ord_rate")
    private BigDecimal ordRate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ord_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ordCreated;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ord_success")
    private short ordSuccess;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ord_void")
    private short ordVoid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "srwOrderId", fetch = FetchType.LAZY)
    private Collection<SellerReviews> sellerReviewsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itmOrderId", fetch = FetchType.LAZY)
    private Collection<OrderItems> orderItemsCollection;
    @JoinColumn(name = "ord_currency_id", referencedColumnName = "cur_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Currencies ordCurrencyId;
    @JoinColumn(name = "ord_user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Users ordUserId;
    @JoinColumn(name = "ord_shipaddress_id", referencedColumnName = "shp_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ShippingAddresses ordShipaddressId;
    @JoinColumn(name = "ord_billaddress_id", referencedColumnName = "bla_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BillingAddresses ordBilladdressId;
    @JoinColumn(name = "ord_paymethod_id", referencedColumnName = "pm_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Paymethods ordPaymethodId;

    public Orders() {
    }

    public Orders(Long ordId) {
        this.ordId = ordId;
    }

    public Orders(Long ordId, String ordBankTransactionId, BigDecimal ordTotal, BigDecimal ordGoodsTotal, BigDecimal ordShipTotal, BigDecimal ordFee, BigDecimal ordRate, Date ordCreated, short ordSuccess, short ordVoid) {
        this.ordId = ordId;
        this.ordBankTransactionId = ordBankTransactionId;
        this.ordTotal = ordTotal;
        this.ordGoodsTotal = ordGoodsTotal;
        this.ordShipTotal = ordShipTotal;
        this.ordFee = ordFee;
        this.ordRate = ordRate;
        this.ordCreated = ordCreated;
        this.ordSuccess = ordSuccess;
        this.ordVoid = ordVoid;
    }

    public Long getOrdId() {
        return ordId;
    }

    public void setOrdId(Long ordId) {
        this.ordId = ordId;
    }

    public String getOrdBankTransactionId() {
        return ordBankTransactionId;
    }

    public void setOrdBankTransactionId(String ordBankTransactionId) {
        this.ordBankTransactionId = ordBankTransactionId;
    }

    public BigDecimal getOrdTotal() {
        return ordTotal;
    }

    public void setOrdTotal(BigDecimal ordTotal) {
        this.ordTotal = ordTotal;
    }

    public BigDecimal getOrdGoodsTotal() {
        return ordGoodsTotal;
    }

    public void setOrdGoodsTotal(BigDecimal ordGoodsTotal) {
        this.ordGoodsTotal = ordGoodsTotal;
    }

    public BigDecimal getOrdShipTotal() {
        return ordShipTotal;
    }

    public void setOrdShipTotal(BigDecimal ordShipTotal) {
        this.ordShipTotal = ordShipTotal;
    }

    public BigDecimal getOrdFee() {
        return ordFee;
    }

    public void setOrdFee(BigDecimal ordFee) {
        this.ordFee = ordFee;
    }

    public BigDecimal getOrdRate() {
        return ordRate;
    }

    public void setOrdRate(BigDecimal ordRate) {
        this.ordRate = ordRate;
    }

    public Date getOrdCreated() {
        return ordCreated;
    }

    public void setOrdCreated(Date ordCreated) {
        this.ordCreated = ordCreated;
    }

    public short getOrdSuccess() {
        return ordSuccess;
    }

    public void setOrdSuccess(short ordSuccess) {
        this.ordSuccess = ordSuccess;
    }

    public short getOrdVoid() {
        return ordVoid;
    }

    public void setOrdVoid(short ordVoid) {
        this.ordVoid = ordVoid;
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

    public Currencies getOrdCurrencyId() {
        return ordCurrencyId;
    }

    public void setOrdCurrencyId(Currencies ordCurrencyId) {
        this.ordCurrencyId = ordCurrencyId;
    }

    public Users getOrdUserId() {
        return ordUserId;
    }

    public void setOrdUserId(Users ordUserId) {
        this.ordUserId = ordUserId;
    }

    public ShippingAddresses getOrdShipaddressId() {
        return ordShipaddressId;
    }

    public void setOrdShipaddressId(ShippingAddresses ordShipaddressId) {
        this.ordShipaddressId = ordShipaddressId;
    }

    public BillingAddresses getOrdBilladdressId() {
        return ordBilladdressId;
    }

    public void setOrdBilladdressId(BillingAddresses ordBilladdressId) {
        this.ordBilladdressId = ordBilladdressId;
    }

    public Paymethods getOrdPaymethodId() {
        return ordPaymethodId;
    }

    public void setOrdPaymethodId(Paymethods ordPaymethodId) {
        this.ordPaymethodId = ordPaymethodId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordId != null ? ordId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.ordId == null && other.ordId != null) || (this.ordId != null && !this.ordId.equals(other.ordId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Orders[ ordId=" + ordId + " ]";
    }
    
}
