 package entities;
 import javax.persistence.*;
 import java.util.Date;


 @Entity
 @Table(name = "users")
 public class User {

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
 @Temporal(TemporalType.TIMESTAMP)
private Date createdAt;

 @Column(name="updated_at")
 @Temporal(TemporalType.TIMESTAMP)
private Date updatedAt;

 } 
