package models.items;

import lombok.Getter;
import lombok.Setter;
import models.sellers.Selling;

import java.io.Serializable;

import javax.persistence.*;
import java.math.BigDecimal;




@Entity
@Table(name = "shipping_costs")
public class ShippingCosts implements Serializable {

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
    private String continentCode;

    @Getter
    @Setter
    @Column
    private BigDecimal cost;

    @JoinColumn(name = "selling_id", referencedColumnName = "id",updatable = false,insertable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Selling sellingObj;

    @Column
    private Integer sellingObjFKey;

    public ShippingCosts() {
    }

    public ShippingCosts(BigDecimal cost) {
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
