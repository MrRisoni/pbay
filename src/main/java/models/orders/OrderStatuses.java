package models.orders;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Collection;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "order_statuses")
public class OrderStatuses implements Serializable {

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
    private String title;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusObj", fetch = FetchType.LAZY)
    private Collection<OrderItems> orderItemsCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusObj", fetch = FetchType.LAZY)
    private Collection<OrderItemTrackHistory> orderItemTrackHistoryCollection;

    public OrderStatuses() {
    }

    public OrderStatuses(Long statId) {
        this.id = statId;
    }

    public OrderStatuses(Long statId, String statTitle) {
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
