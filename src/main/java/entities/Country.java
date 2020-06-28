 package entities;
 import javax.persistence.*;


 @Entity
 @Table(name = "countries")
 public class Country {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name="ctr_id")
private int id;

 } 
