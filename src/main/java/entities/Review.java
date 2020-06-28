 package entities;
 import javax.persistence.*;


 @Entity
 @Table(name = "reviews")
 public class Review {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name="rev_id")
private int id;

 @Column(name="rev_comment")
private String comment;

 @Column(name="rev_star")
private float star;

 @Column(name="rev_created_at")
@Temporal(TemporalType.TIMESTAMP)
private java.util.Date createdAt;

 } 
