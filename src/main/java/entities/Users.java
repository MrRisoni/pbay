 package entities;
 import javax.persistence.*;


 @Entity
 @Table(name = "users")
 public class Users { 

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name="id")
private int id;

 @Column(name="name")
private String name;

 @Column(name="email")
private String email;

 @Column(name="password")
private String password;

 @Column(name="remember_token")
private String token;

 @Column(name="created_at")
private int at;

 @Column(name="updated_at")
private int at;

 } 
