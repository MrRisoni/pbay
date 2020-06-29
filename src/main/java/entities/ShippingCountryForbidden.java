package entities;

import javax.persistence.*;

@Entity
@Table(name = "shipping_country_forbidden")
public class ShippingCountryForbidden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shf_id")
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="shf_country_id")
    private Country countryObj;

    public ShippingCountryForbidden() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Country getCountryObj() {
        return countryObj;
    }

    public void setCountryObj(Country countryObj) {
        this.countryObj = countryObj;
    }
}
