 package entities;
 import javax.persistence.*;


 @Entity
 @Table(name = "products_filter_values")
 public class ProductFilterValue {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name="pfv_id")
private int id;

 @Column(name="pfv_value")
private String value;

 } 
