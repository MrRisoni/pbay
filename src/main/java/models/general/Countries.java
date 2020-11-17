package models.general;

import lombok.Getter;
import lombok.Setter;
import models.users.BillingAddresses;
import models.sellers.Sellers;
import models.users.ShippingAddresses;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Collection;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "countries")
public class Countries implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Short id;

    @Getter
    @Setter
    @Column
    private String title;

    @Getter
    @Setter
    @Column
    private String code;

    @JoinColumn(name = "continent_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Continents ctrContinentId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countryObj", fetch = FetchType.LAZY)
    private Collection<Sellers> sellersCollection;

    public Countries() {
    }

    public Countries(Short id) {
        this.id = id;
    }

    public Countries(Short id, String ctrTitle, String ctrCode) {
        this.id = id;
        this.title = ctrTitle;
        this.code = ctrCode;
    }

    public Continents getCtrContinentId() {
        return ctrContinentId;
    }

    public void setCtrContinentId(Continents ctrContinentId) {
        this.ctrContinentId = ctrContinentId;
    }

    @XmlTransient
    public Collection<Sellers> getSellersCollection() {
        return sellersCollection;
    }

    public void setSellersCollection(Collection<Sellers> sellersCollection) {
        this.sellersCollection = sellersCollection;
    }
}
