
package models.orders;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.*;
import java.util.Collection;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import javax.xml.bind.annotation.XmlTransient;


@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "order_statuses")
public class OrderStatuses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stat_id")
    private Short id;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 34)
    @Column(name = "stat_title")
    private String title;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusObj", fetch = FetchType.LAZY)
    private Collection<OrderItems> orderItemsCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusObj", fetch = FetchType.LAZY)
    private Collection<OrderItemTrackHistory> orderItemTrackHistoryCollection;

    public OrderStatuses() {
    }

    public OrderStatuses(Short statId) {
        this.id = statId;
    }

    public OrderStatuses(Short statId, String statTitle) {
        this.id = statId;
        this.title = statTitle;
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

}
