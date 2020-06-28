 package entities;
 import javax.persistence.*;


 @Entity
 @Table(name = "currencies")
 public class Currency {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name="cur_id")
private int id;

 @Column(name="cur_rate")
private float rate;

 } 
