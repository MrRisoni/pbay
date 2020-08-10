package models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="shipping_costs")
public class ShippingCost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = " shc_id")
    private Long id;

    @Column(name="shc_continent_code")
    private String continentCode;

    @Column(name = "shc_cost")
    private BigDecimal cost;

    public ShippingCost() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getContinentCode() {
        return continentCode;
    }

    public void setContinentCode(String continentCode) {
        this.continentCode = continentCode;
    }
}
