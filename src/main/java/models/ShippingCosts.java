
package models;

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
@Table(name = "shipping_costs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShippingCosts.findAll", query = "SELECT s FROM ShippingCosts s")})
public class ShippingCosts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "shc_id")
    private Integer shcId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "shc_continent_code")
    private String shcContinentCode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "shc_cost")
    private BigDecimal shcCost;
    @JoinColumn(name = "shc_selling_id", referencedColumnName = "sll_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Selling shcSellingId;

    public ShippingCosts() {
    }

    public ShippingCosts(Integer shcId) {
        this.shcId = shcId;
    }

    public ShippingCosts(Integer shcId, String shcContinentCode, BigDecimal shcCost) {
        this.shcId = shcId;
        this.shcContinentCode = shcContinentCode;
        this.shcCost = shcCost;
    }

    public Integer getShcId() {
        return shcId;
    }

    public void setShcId(Integer shcId) {
        this.shcId = shcId;
    }

    public String getShcContinentCode() {
        return shcContinentCode;
    }

    public void setShcContinentCode(String shcContinentCode) {
        this.shcContinentCode = shcContinentCode;
    }

    public BigDecimal getShcCost() {
        return shcCost;
    }

    public void setShcCost(BigDecimal shcCost) {
        this.shcCost = shcCost;
    }

    public Selling getShcSellingId() {
        return shcSellingId;
    }

    public void setShcSellingId(Selling shcSellingId) {
        this.shcSellingId = shcSellingId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shcId != null ? shcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShippingCosts)) {
            return false;
        }
        ShippingCosts other = (ShippingCosts) object;
        if ((this.shcId == null && other.shcId != null) || (this.shcId != null && !this.shcId.equals(other.shcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.ShippingCosts[ shcId=" + shcId + " ]";
    }
    
}
