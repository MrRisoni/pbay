package models.orders;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.*;
import java.util.Date;



@Entity
@Table(name = "order_item_track_history")
public class OrderItemTrackHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Getter
    @Setter
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @JoinColumn(name = "itmh_item_id", referencedColumnName = "itm_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private OrderItems itemObj;

    @JoinColumn(name = "itmh_status_id", referencedColumnName = "stat_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private OrderStatuses statusObj;

    public OrderItemTrackHistory() {
    }

    public OrderItemTrackHistory(Long itmhId) {
        this.id = itmhId;
    }

    public OrderItemTrackHistory(Long itmhId, Date itmhCreatedAt) {
        this.id = itmhId;
        this.createdAt = itmhCreatedAt;
    }

    public OrderItems getItemObj() {
        return itemObj;
    }

    public void setItemObj(OrderItems itemObj) {
        this.itemObj = itemObj;
    }

    public OrderStatuses getStatusObj() {
        return statusObj;
    }

    public void setStatusObj(OrderStatuses statusObj) {
        this.statusObj = statusObj;
    }
}
