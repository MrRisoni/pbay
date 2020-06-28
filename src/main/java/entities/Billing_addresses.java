 package entities;
 import javax.persistence.*;


 @Entity
 @Table(name = "billing_addresses")
 public class Billing_addresses { 

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name="bla_id")
private int id;

 @Column(name="bla_city")
private String city;

 @Column(name="bla_region")
private String region;

 @Column(name="bla_street")
private String street;

 @Column(name="bla_street_no")
private String streetNo;

 @Column(name="bla_code")
private String code;

 @Column(name="bla_surname")
private String surname;

 @Column(name="bla_name")
private String name;

 } 
