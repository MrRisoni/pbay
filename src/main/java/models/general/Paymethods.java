
package models.general;

import com.fasterxml.jackson.annotation.JsonView;
import models.JackSonViewer;
import models.orders.Orders;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Collection;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import javax.xml.bind.annotation.XmlTransient;


@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "paymethods")
public class Paymethods implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pm_id")

    private Short id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "pm_title")

    private String title;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "payMethodObj", fetch = FetchType.LAZY)
    private Collection<Orders> ordersCollection;

    public Paymethods() {
    }

    public Paymethods(Short pmId) {
        this.id = pmId;
    }

    public Paymethods(Short pmId, String pmTitle) {
        this.id = pmId;
        this.title = pmTitle;
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
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }


}
