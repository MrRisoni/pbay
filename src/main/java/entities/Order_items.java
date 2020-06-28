 package entities;
 import javax.persistence.*;


 @Entity
 @Table(name = "order_items")
 public class Order_items { 

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name="itm_id")
private int id;

 @Column(name="itm_quantity")
private int quantity;

 @Column(name="itm_tracking_nums")
private String trackingNums;

 @Column(name="itm_total")
private float total;

 @Column(name="itm_goods_total")
private float goodsTotal;

 @Column(name="itm_ship_total")
private float shipTotal;

 @Column(name="itm_void")
private int void;

 } 
