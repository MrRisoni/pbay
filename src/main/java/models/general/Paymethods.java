
package models.general;

import com.fasterxml.jackson.annotation.JsonView;
import models.JackSonViewer;
import models.orders.Orders;

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
@Table(name = "paymethods")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paymethods.findAll", query = "SELECT p FROM Paymethods p")})
public class Paymethods implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pm_id")
    @JsonView(JackSonViewer.IOrder.class)
    private Short id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "pm_title")
    @JsonView(JackSonViewer.IOrder.class)
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paymethods)) {
            return false;
        }
        Paymethods other = (Paymethods) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.general.Paymethods[ pmId=" + id + " ]";
    }
    
}
