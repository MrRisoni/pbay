
package models.orders;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
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
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "itmh_created_at")
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderItemTrackHistory)) {
            return false;
        }
        OrderItemTrackHistory other = (OrderItemTrackHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.orders.OrderItemTrackHistory[ itmhId=" + id + " ]";
    }
    
}
