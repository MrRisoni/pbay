 package entities;
 import javax.persistence.*;


 @Entity
 @Table(name = "order_statuses")
 public class Order_statuses { 

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name="stat_id")
private int id;

 } 
