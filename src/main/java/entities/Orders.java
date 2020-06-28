 package entities;
 import javax.persistence.*;


 @Entity
 @Table(name = "orders")
 public class Orders { 

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name="ord_id")
private int id;

 @Column(name="ord_bank_transaction_id")
private String bankTransaction;

 @Column(name="ord_total")
private float total;

 @Column(name="ord_goods_total")
private float goodsTotal;

 @Column(name="ord_ship_total")
private float shipTotal;

 @Column(name="ord_fee")
private float fee;

 @Column(name="ord_rate")
private float rate;

 @Column(name="ord_created")
@Temporal(TemporalType.TIMESTAMP)
private java.util.Date created;

 @Column(name="ord_success")
private int success;

 @Column(name="ord_void")
private int void;

 } 
