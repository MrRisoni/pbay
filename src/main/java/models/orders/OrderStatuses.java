
package models.orders;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "order_statuses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderStatuses.findAll", query = "SELECT o FROM OrderStatuses o")})
public class OrderStatuses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stat_id")
    private Short statId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 34)
    @Column(name = "stat_title")
    private String statTitle;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itmStatusId", fetch = FetchType.LAZY)
    private Collection<OrderItems> orderItemsCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itmhStatusId", fetch = FetchType.LAZY)
    private Collection<OrderItemTrackHistory> orderItemTrackHistoryCollection;

    public OrderStatuses() {
    }

    public OrderStatuses(Short statId) {
        this.statId = statId;
    }

    public OrderStatuses(Short statId, String statTitle) {
        this.statId = statId;
        this.statTitle = statTitle;
    }

    public Short getStatId() {
        return statId;
    }

    public void setStatId(Short statId) {
        this.statId = statId;
    }

    public String getStatTitle() {
        return statTitle;
    }

    public void setStatTitle(String statTitle) {
        this.statTitle = statTitle;
    }

    @XmlTransient
    public Collection<OrderItems> getOrderItemsCollection() {
        return orderItemsCollection;
    }

    public void setOrderItemsCollection(Collection<OrderItems> orderItemsCollection) {
        this.orderItemsCollection = orderItemsCollection;
    }

    @XmlTransient
    public Collection<OrderItemTrackHistory> getOrderItemTrackHistoryCollection() {
        return orderItemTrackHistoryCollection;
    }

    public void setOrderItemTrackHistoryCollection(Collection<OrderItemTrackHistory> orderItemTrackHistoryCollection) {
        this.orderItemTrackHistoryCollection = orderItemTrackHistoryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statId != null ? statId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderStatuses)) {
            return false;
        }
        OrderStatuses other = (OrderStatuses) object;
        if ((this.statId == null && other.statId != null) || (this.statId != null && !this.statId.equals(other.statId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.orders.OrderStatuses[ statId=" + statId + " ]";
    }
    
}
