package entities;

import javax.persistence.*;


@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itm_id")
    private int id;

    @Column(name = "itm_quantity")
    private int quantity;

    @Column(name = "itm_tracking_nums")
    private String trackingNums;

    @Column(name = "itm_total")
    private float total;

    @Column(name = "itm_goods_total")
    private float goodsTotal;

    @Column(name = "itm_ship_total")
    private float shipTotal;

    @Column(name = "itm_void")
    private boolean isVoid;

    public OrderItem(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTrackingNums() {
        return trackingNums;
    }

    public void setTrackingNums(String trackingNums) {
        this.trackingNums = trackingNums;
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

    public boolean isVoid() {
        return isVoid;
    }

    public void setVoid(boolean aVoid) {
        isVoid = aVoid;
    }
}
