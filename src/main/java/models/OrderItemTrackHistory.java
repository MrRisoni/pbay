
package models;

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
    private Long itmhId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "itmh_created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date itmhCreatedAt;
    @JoinColumn(name = "itmh_item_id", referencedColumnName = "itm_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private OrderItems itmhItemId;
    @JoinColumn(name = "itmh_status_id", referencedColumnName = "stat_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private OrderStatuses itmhStatusId;

    public OrderItemTrackHistory() {
    }

    public OrderItemTrackHistory(Long itmhId) {
        this.itmhId = itmhId;
    }

    public OrderItemTrackHistory(Long itmhId, Date itmhCreatedAt) {
        this.itmhId = itmhId;
        this.itmhCreatedAt = itmhCreatedAt;
    }

    public Long getItmhId() {
        return itmhId;
    }

    public void setItmhId(Long itmhId) {
        this.itmhId = itmhId;
    }

    public Date getItmhCreatedAt() {
        return itmhCreatedAt;
    }

    public void setItmhCreatedAt(Date itmhCreatedAt) {
        this.itmhCreatedAt = itmhCreatedAt;
    }

    public OrderItems getItmhItemId() {
        return itmhItemId;
    }

    public void setItmhItemId(OrderItems itmhItemId) {
        this.itmhItemId = itmhItemId;
    }

    public OrderStatuses getItmhStatusId() {
        return itmhStatusId;
    }

    public void setItmhStatusId(OrderStatuses itmhStatusId) {
        this.itmhStatusId = itmhStatusId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itmhId != null ? itmhId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderItemTrackHistory)) {
            return false;
        }
        OrderItemTrackHistory other = (OrderItemTrackHistory) object;
        if ((this.itmhId == null && other.itmhId != null) || (this.itmhId != null && !this.itmhId.equals(other.itmhId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.OrderItemTrackHistory[ itmhId=" + itmhId + " ]";
    }
    
}
