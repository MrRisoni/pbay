
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
@Table(name = "shipping_costs")
public class ShippingCosts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "shc_id")
    private Integer id;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "shc_continent_code")
    private String continentCode;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Column(name = "shc_cost")
    private BigDecimal cost;

    @JoinColumn(name = "shc_selling_id", referencedColumnName = "sll_id",updatable = false,insertable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Selling sellingObj;

    @Column(name = "shc_selling_id")
    private Integer sellingObjFKey;

    public ShippingCosts() {
    }

    public ShippingCosts(@NotNull BigDecimal cost) {
        this.cost = cost;
    }

    public ShippingCosts(Integer shcId) {
        this.id = shcId;
    }

    public ShippingCosts(Integer shcId, String shcContinentCode, BigDecimal shcCost) {
        this.id = shcId;
        this.continentCode = shcContinentCode;
        this.cost = shcCost;
    }


    public Selling getSellingObj() {
        return sellingObj;
    }

    public void setSellingObj(Selling sellingObj) {
        this.sellingObj = sellingObj;
    }

    public Integer getSellingObjFKey() {
        return sellingObjFKey;
    }

    public void setSellingObjFKey(Integer sellingObjFKey) {
        this.sellingObjFKey = sellingObjFKey;
    }
}
