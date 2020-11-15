package models.items;

import lombok.Getter;
import lombok.Setter;
import models.sellers.Selling;

import java.io.Serializable;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "shipping_country_forbidden")
public class ShippingCountryForbidden implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "shf_id")
    private Integer id;

    @Basic(optional = false)
    @Getter
    @Setter
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "shf_country_code")
    private String countryCode;

    @JoinColumn(name = "shf_selling_id", referencedColumnName = "sll_id")
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
