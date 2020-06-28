 package entities;
 import javax.persistence.*;


 @Entity
 @Table(name = "selling")
 public class Selling { 

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name="sll_id")
private int id;

 @Column(name="sll_quantity")
private int quantity;

 @Column(name="sll_mailer_co")
private String mailerCo;

 } 
