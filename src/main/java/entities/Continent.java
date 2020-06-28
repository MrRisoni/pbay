 package entities;
 import javax.persistence.*;


 @Entity
 @Table(name = "continents")
 public class Continent {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name="con_id")
private int id;

 @Column(name="con_title")
private String title;

 } 
