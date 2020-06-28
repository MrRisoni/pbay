 package entities;
 import javax.persistence.*;


 @Entity
 @Table(name = "products_categories")
 public class Products_categories { 

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name="cat_id")
private int id;

 @Column(name="cat_title")
private String title;

 } 
