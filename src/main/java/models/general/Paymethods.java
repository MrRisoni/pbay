package models.general;

import lombok.Getter;
import lombok.Setter;
import models.orders.Orders;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Collection;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "paymethods")
public class Paymethods implements Serializable {

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "payMethodObj", fetch = FetchType.LAZY)
    private Collection<Orders> ordersCollection;

    public Paymethods() {
    }

    public Paymethods(Long pmId) {
        this.id = pmId;
    }

    public Paymethods(Long pmId, String pmTitle) {
        this.id = pmId;
        this.title = pmTitle;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }
}
