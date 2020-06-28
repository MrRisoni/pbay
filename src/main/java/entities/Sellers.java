 package entities;
 import javax.persistence.*;


 @Entity
 @Table(name = "sellers")
 public class Sellers { 

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name="sel_id")
private int id;

 @Column(name="sel_title")
private String title;

 @Column(name="sel_ssn")
private String ssn;

 @Column(name="sel_stars_avg")
private float starsAvg;

 } 
