
package models.orders;

import com.fasterxml.jackson.annotation.JsonView;
import models.JackSonViewer;

import java.io.Serializable;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.*;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "order_item_track_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderItemTrackHistory.findAll", query = "SELECT o FROM OrderItemTrackHistory o")})
public class OrderItemTrackHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "itmh_id")
    @JsonView(JackSonViewer.IOrder.class)
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "itmh_created_at")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonView(JackSonViewer.IOrder.class)
    private Date createdAt;

    @JoinColumn(name = "itmh_item_id", referencedColumnName = "itm_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private OrderItems itemObj;

    @JoinColumn(name = "itmh_status_id", referencedColumnName = "stat_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonView(JackSonViewer.IOrder.class)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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
