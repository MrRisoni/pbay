
package models.orders;

import com.fasterxml.jackson.annotation.JsonView;
import models.JackSonViewer;
import models.general.Currencies;
import models.general.Paymethods;
import models.sellers.SellerReviews;
import models.users.BillingAddresses;
import models.users.ShippingAddresses;
import models.users.Users;

import java.io.Serializable;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
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
    @JsonView(JackSonViewer.IOrder.class)
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ord_bank_transaction_id")
    @JsonView(JackSonViewer.IOrder.class)
    private String bankTransactionId;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ord_total")
    @JsonView(JackSonViewer.IOrder.class)
    private BigDecimal total;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ord_goods_total")
    @JsonView(JackSonViewer.IOrder.class)
    private BigDecimal goodsTotal;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ord_ship_total")
    @JsonView(JackSonViewer.IOrder.class)
    private BigDecimal shipTotal;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ord_fee")
    @JsonView(JackSonViewer.IOrder.class)
    private BigDecimal fee;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ord_rate")
    @JsonView(JackSonViewer.IOrder.class)
    private BigDecimal rate;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ord_created")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonView(JackSonViewer.IOrder.class)
    private Date createdAt;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ord_success")
    @JsonView(JackSonViewer.IOrder.class)
    private short isSuccess;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ord_void")
    @JsonView(JackSonViewer.IOrder.class)
    private short isVoid;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderObj", fetch = FetchType.LAZY)
    private Collection<SellerReviews> sellerReviewsCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderObj", fetch = FetchType.LAZY)
    @JsonView(JackSonViewer.IOrder.class)
    private Collection<OrderItems> orderItemsCollection;

    @JoinColumn(name = "ord_currency_id", referencedColumnName = "cur_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonView(JackSonViewer.IOrder.class)
    private Currencies currencyObj;

    @JoinColumn(name = "ord_user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Users userObj;

    @JoinColumn(name = "ord_shipaddress_id", referencedColumnName = "shp_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonView(JackSonViewer.IOrder.class)
    private ShippingAddresses shipAddressObj;

    @JoinColumn(name = "ord_billaddress_id", referencedColumnName = "bla_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonView(JackSonViewer.IOrder.class)
    private BillingAddresses billAddressObj;

    @JoinColumn(name = "ord_paymethod_id", referencedColumnName = "pm_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonView(JackSonViewer.IOrder.class)
    private Paymethods payMethodObj;

    public Orders() {
    }

    public Orders(Long ordId) {
        this.id = ordId;
    }

    public Orders(Long ordId, String ordBankTransactionId, BigDecimal ordTotal, BigDecimal ordGoodsTotal, BigDecimal ordShipTotal, BigDecimal ordFee, BigDecimal ordRate, Date ordCreated, short ordSuccess, short ordVoid) {
        this.id = ordId;
        this.bankTransactionId = ordBankTransactionId;
        this.total = ordTotal;
        this.goodsTotal = ordGoodsTotal;
        this.shipTotal = ordShipTotal;
        this.fee = ordFee;
        this.rate = ordRate;
        this.createdAt = ordCreated;
        this.isSuccess = ordSuccess;
        this.isVoid = ordVoid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBankTransactionId() {
        return bankTransactionId;
    }

    public void setBankTransactionId(String bankTransactionId) {
        this.bankTransactionId = bankTransactionId;
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

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public short getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(short isSuccess) {
        this.isSuccess = isSuccess;
    }

    public short getIsVoid() {
        return isVoid;
    }

    public void setIsVoid(short isVoid) {
        this.isVoid = isVoid;
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

    public Currencies getCurrencyObj() {
        return currencyObj;
    }

    public void setCurrencyObj(Currencies currencyObj) {
        this.currencyObj = currencyObj;
    }

    public Users getUserObj() {
        return userObj;
    }

    public void setUserObj(Users userObj) {
        this.userObj = userObj;
    }

    public ShippingAddresses getShipAddressObj() {
        return shipAddressObj;
    }

    public void setShipAddressObj(ShippingAddresses shipAddressObj) {
        this.shipAddressObj = shipAddressObj;
    }

    public BillingAddresses getBillAddressObj() {
        return billAddressObj;
    }

    public void setBillAddressObj(BillingAddresses billAddressObj) {
        this.billAddressObj = billAddressObj;
    }

    public Paymethods getPayMethodObj() {
        return payMethodObj;
    }

    public void setPayMethodObj(Paymethods payMethodObj) {
        this.payMethodObj = payMethodObj;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.orders.Orders[ ordId=" + id + " ]";
    }
    
}
