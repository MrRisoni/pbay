 package entities;
 import javax.persistence.*;


 @Entity
 @Table(name = "products_filters")
 public class ProductFilter {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name="fil_id")
private int id;

 } 
