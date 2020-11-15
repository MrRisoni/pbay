package models.items;

import lombok.Getter;
import lombok.Setter;
import models.sellers.Selling;

import java.io.Serializable;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.*;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "shipping_costs_exceptions")
public class ShippingCostsExceptions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "shcx_id")
    private Integer id;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "shcx_country_code")
    private String countryCode;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Column(name = "shcx_cost")
    private BigDecimal cost;

    @JoinColumn(name = "shcx_selling_id", referencedColumnName = "sll_id",updatable = false,insertable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Selling sellingObj;

    @Getter
    @Setter
    @Column(name = "shc_selling_id")
    private Integer sellingObjFKey;

    public ShippingCostsExceptions() {
    }

    public ShippingCostsExceptions(@NotNull BigDecimal cost) {
        this.cost = cost;
    }

    public ShippingCostsExceptions(Integer shcxId) {
        this.id = shcxId;
    }

    public ShippingCostsExceptions(Integer shcxId, String shcxCountryCode, BigDecimal shcxCost) {
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
