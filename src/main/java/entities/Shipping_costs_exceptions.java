 package entities;
 import javax.persistence.*;


 @Entity
 @Table(name = "shipping_costs_exceptions")
 public class Shipping_costs_exceptions { 

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name="shcx_id")
private int id;

 @Column(name="shcx_cost")
private float cost;

 } 
