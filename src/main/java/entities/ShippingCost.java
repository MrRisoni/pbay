package entities;

import javax.persistence.*;


@Entity
@Table(name = "shipping_costs")
public class ShippingCost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shc_id")
    private int id;

    @Column(name = "shc_cost")
    private float cost;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="shc_continent_id")
    private Continent contiObj;

    public ShippingCost() {
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

    public Continent getContiObj() {
        return contiObj;
    }

    public void setContiObj(Continent contiObj) {
        this.contiObj = contiObj;
    }
}
