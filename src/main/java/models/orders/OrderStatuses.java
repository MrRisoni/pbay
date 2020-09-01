
package models.orders;

import com.fasterxml.jackson.annotation.JsonView;
import models.JackSonViewer;

import java.io.Serializable;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.*;
import java.util.Collection;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "order_statuses")

@NamedQueries({
    @NamedQuery(name = "OrderStatuses.findAll", query = "SELECT o FROM OrderStatuses o")})
public class OrderStatuses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stat_id")
    @JsonView(JackSonViewer.IOrder.class)
    private Short id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 34)
    @Column(name = "stat_title")
    @JsonView(JackSonViewer.IOrder.class)
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

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
