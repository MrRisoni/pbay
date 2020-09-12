
package models.items;

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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "shcx_id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "shcx_country_code")
    private String countryCode;

    @Basic(optional = false)
    @NotNull
    @Column(name = "shcx_cost")
    private BigDecimal cost;

    @JoinColumn(name = "shcx_selling_id", referencedColumnName = "sll_id",updatable = false,insertable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Selling sellingObj;

    @Column(name = "shc_selling_id")
    private Integer sellingObkFKey;

    public ShippingCostsExceptions() {
    }

    public ShippingCostsExceptions(Integer shcxId) {
        this.id = shcxId;
    }

    public ShippingCostsExceptions(Integer shcxId, String shcxCountryCode, BigDecimal shcxCost) {
        this.id = shcxId;
        this.countryCode = shcxCountryCode;
        this.cost = shcxCost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Selling getSellingObj() {
        return sellingObj;
    }

    public void setSellingObj(Selling sellingObj) {
        this.sellingObj = sellingObj;
    }


    public Integer getSellingObkFKey() {
        return sellingObkFKey;
    }

    public void setSellingObkFKey(Integer sellingObkFKey) {
        this.sellingObkFKey = sellingObkFKey;
    }
}
