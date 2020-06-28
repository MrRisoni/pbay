package entities;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "order_item_track_history")
public class OrderItemTrackHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itmh_id")
    private int id;

    @Column(name = "itmh_created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date createdAt;

    public OrderItemTrackHistory(int id, Date createdAt) {
        this.id = id;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
