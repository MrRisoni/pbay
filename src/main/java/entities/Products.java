 package entities;
 import javax.persistence.*;


 @Entity
 @Table(name = "products")
 public class Products { 

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name="prod_id")
private int id;

 @Column(name="prod_title")
private String title;

 @Column(name="prod_other_title")
private String otherTitle;

 @Column(name="prod_descr")
private String descr;

 @Column(name="prod_preowned")
private int preowned;

 } 
