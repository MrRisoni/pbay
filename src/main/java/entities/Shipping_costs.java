 package entities;
 import javax.persistence.*;


 @Entity
 @Table(name = "shipping_costs")
 public class Shipping_costs { 

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name="shc_id")
private int id;

 @Column(name="shc_cost")
private float cost;

 } 
