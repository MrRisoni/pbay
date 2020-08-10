package models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="shipping_costs_exceptions")
public class ShippingCostException {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shcx_id")
    private Long id;

    @Column(name="shcx_country_code")
    private String countryCode;

    @Column(name = "shcx_cost")
    private BigDecimal cost;

    public ShippingCostException() {
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

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
