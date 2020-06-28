package entities;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rev_id")
    private int id;

    @Column(name = "rev_comment")
    private String comment;

    @Column(name = "rev_star")
    private float star;

    @Column(name = "rev_created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date createdAt;

    public Review(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public float getStar() {
        return star;
    }

    public void setStar(float star) {
        this.star = star;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
