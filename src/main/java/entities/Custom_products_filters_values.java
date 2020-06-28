 package entities;
 import javax.persistence.*;


 @Entity
 @Table(name = "custom_products_filters_values")
 public class Custom_products_filters_values { 

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name="csp_id")
private int id;

 @Column(name="csp_value")
private String value;

 } 
