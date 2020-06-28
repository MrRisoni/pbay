 package entities;
 import javax.persistence.*;


 @Entity
 @Table(name = "listings")
 public class Listings { 

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name="lis_id")
private int id;

 @Column(name="lis_price")
private float price;

 @Column(name="lis_fee_eur")
private float feeEur;

 @Column(name="lis_from")
private int from;

 @Column(name="lis_to")
private int to;

 @Column(name="lis_watching")
private int watching;

 @Column(name="lis_is_auction")
private int isAuction;

 } 
