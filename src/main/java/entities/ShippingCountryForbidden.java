package entities;

import javax.persistence.*;


@Entity
@Table(name = "shipping_country_forbidden")
public class ShippingCountryForbidden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shf_id")
    private int id;

}
