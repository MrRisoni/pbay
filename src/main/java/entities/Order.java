package entities;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ord_id")
    private int id;

    @Column(name = "ord_bank_transaction_id")
    private String bankTransactionId;

    @Column(name = "ord_total")
    private float total;

    @Column(name = "ord_goods_total")
    private float goodsTotal;

    @Column(name = "ord_ship_total")
    private float shipTotal;

    @Column(name = "ord_fee")
    private float fee;

    @Column(name = "ord_rate")
    private float rate;

    @Column(name = "ord_created")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date created;

    @Column(name = "ord_success")
    private boolean success;

    @Column(name = "ord_void")
    private boolean isVoid;


    public Order(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBankTransactionId() {
        return bankTransactionId;
    }

    public void setBankTransactionId(String bankTransactionId) {
        this.bankTransactionId = bankTransactionId;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getGoodsTotal() {
        return goodsTotal;
    }

    public void setGoodsTotal(float goodsTotal) {
        this.goodsTotal = goodsTotal;
    }

    public float getShipTotal() {
        return shipTotal;
    }

    public void setShipTotal(float shipTotal) {
        this.shipTotal = shipTotal;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isVoid() {
        return isVoid;
    }

    public void setVoid(boolean aVoid) {
        isVoid = aVoid;
    }
}
