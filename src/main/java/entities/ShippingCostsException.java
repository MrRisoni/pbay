package entities;

import javax.persistence.*;


@Entity
@Table(name = "shipping_costs_exceptions")
public class ShippingCostsException {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shcx_id")
    private int id;

    @Column(name = "shcx_cost")
    private float cost;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="shcx_country_id")
    private Country countryObj;

    public ShippingCostsException() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Country getCountryObj() {
        return countryObj;
    }

    public void setCountryObj(Country countryObj) {
        this.countryObj = countryObj;
    }
}
