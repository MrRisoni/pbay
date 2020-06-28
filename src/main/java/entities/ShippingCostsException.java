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

    public ShippingCostsException(int id, float cost) {
        this.id = id;
        this.cost = cost;
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
}
