package models.items;

import lombok.Getter;
import lombok.Setter;
import models.sellers.Selling;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "shipping_country_forbidden")
public class ShippingCountryForbidden implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;


    @Getter
    @Setter
    @Column
    private String countryCode;

    @JoinColumn(name = "selling_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Selling sellingObj;

    public ShippingCountryForbidden() {
    }

    public ShippingCountryForbidden(Integer shfId) {
        this.id = shfId;
    }

    public ShippingCountryForbidden(Integer shfId, String shfCountryCode) {
        this.id = shfId;
        this.countryCode = shfCountryCode;
    }

    public Selling getSellingObj() {
        return sellingObj;
    }

    public void setSellingObj(Selling sellingObj) {
        this.sellingObj = sellingObj;
    }

}
