
package models.items;

import models.sellers.Selling;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "shipping_costs_exceptions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShippingCostsExceptions.findAll", query = "SELECT s FROM ShippingCostsExceptions s")})
public class ShippingCostsExceptions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "shcx_id")
    private Integer shcxId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "shcx_country_code")
    private String shcxCountryCode;

    @Basic(optional = false)
    @NotNull
    @Column(name = "shcx_cost")
    private BigDecimal shcxCost;

    @JoinColumn(name = "shcx_selling_id", referencedColumnName = "sll_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Selling shcxSellingId;

    public ShippingCostsExceptions() {
    }

    public ShippingCostsExceptions(Integer shcxId) {
        this.shcxId = shcxId;
    }

    public ShippingCostsExceptions(Integer shcxId, String shcxCountryCode, BigDecimal shcxCost) {
        this.shcxId = shcxId;
        this.shcxCountryCode = shcxCountryCode;
        this.shcxCost = shcxCost;
    }

    public Integer getShcxId() {
        return shcxId;
    }

    public void setShcxId(Integer shcxId) {
        this.shcxId = shcxId;
    }

    public String getShcxCountryCode() {
        return shcxCountryCode;
    }

    public void setShcxCountryCode(String shcxCountryCode) {
        this.shcxCountryCode = shcxCountryCode;
    }

    public BigDecimal getShcxCost() {
        return shcxCost;
    }

    public void setShcxCost(BigDecimal shcxCost) {
        this.shcxCost = shcxCost;
    }

    public Selling getShcxSellingId() {
        return shcxSellingId;
    }

    public void setShcxSellingId(Selling shcxSellingId) {
        this.shcxSellingId = shcxSellingId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shcxId != null ? shcxId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShippingCostsExceptions)) {
            return false;
        }
        ShippingCostsExceptions other = (ShippingCostsExceptions) object;
        if ((this.shcxId == null && other.shcxId != null) || (this.shcxId != null && !this.shcxId.equals(other.shcxId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.items.ShippingCostsExceptions[ shcxId=" + shcxId + " ]";
    }
    
}
