package models.items;

import lombok.Getter;
import lombok.Setter;
import models.sellers.Selling;
import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "shipping_costs_exceptions")
public class ShippingCostsExceptions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Getter
    @Setter
    @Column
    private String countryCode;

    @Getter
    @Setter
    @Column
    private BigDecimal cost;

    @JoinColumn(name = "selling_id", referencedColumnName = "id",updatable = false,insertable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Selling sellingObj;

    @Getter
    @Setter
    @Column
    private Integer sellingObjFKey;

    public ShippingCostsExceptions() {
    }

    public ShippingCostsExceptions( BigDecimal cost) {
        this.cost = cost;
    }

    public ShippingCostsExceptions(Long shcxId) {
        this.id = shcxId;
    }

    public ShippingCostsExceptions(Long shcxId, String shcxCountryCode, BigDecimal shcxCost) {
        this.id = shcxId;
        this.countryCode = shcxCountryCode;
        this.cost = shcxCost;
    }

    public Selling getSellingObj() {
        return sellingObj;
    }

    public void setSellingObj(Selling sellingObj) {
        this.sellingObj = sellingObj;
    }
}
