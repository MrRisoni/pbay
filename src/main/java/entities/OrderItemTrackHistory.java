 package entities;
 import javax.persistence.*;


 @Entity
 @Table(name = "order_item_track_history")
 public class OrderItemTrackHistory {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name="itmh_id")
private int id;

 @Column(name="itmh_created_at")
@Temporal(TemporalType.TIMESTAMP)
private java.util.Date createdAt;

 } 
