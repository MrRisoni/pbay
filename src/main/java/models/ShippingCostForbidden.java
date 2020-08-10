package models;

import javax.persistence.*;

@Entity
@Table(name="shipping_country_forbidden")
public class ShippingCostForbidden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shf_id")
    private Long id;

    public ShippingCostForbidden() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
