 package entities;
 import javax.persistence.*;


 @Entity
 @Table(name = "countries")
 public class Countries { 

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name="ctr_id")
private int id;

 } 
