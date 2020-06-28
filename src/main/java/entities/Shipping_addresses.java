 package entities;
 import javax.persistence.*;


 @Entity
 @Table(name = "shipping_addresses")
 public class Shipping_addresses { 

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name="shp_id")
private int id;

 @Column(name="shp_city")
private String city;

 @Column(name="shp_region")
private String region;

 @Column(name="shp_street")
private String street;

 @Column(name="shp_street_no")
private String streetNo;

 @Column(name="shp_code")
private String code;

 @Column(name="shp_surname")
private String surname;

 @Column(name="shp_name")
private String name;

 } 
