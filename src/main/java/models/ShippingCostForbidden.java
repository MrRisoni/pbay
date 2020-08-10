package models;

import javax.persistence.*;

@Entity
@Table(name="shipping_country_forbidden")
public class ShippingCostForbidden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shf_id")
    private Long id;

    @Column(name="shf_country_code")
    private String countryCode;


    public ShippingCostForbidden() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
