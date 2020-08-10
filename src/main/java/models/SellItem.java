package models;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.*;


@Entity
@Table(name="selling")
public class SellItem
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sll_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = " sll_product_id")
    private Product productObj;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = " sll_seller_id")
    private Seller sellerObj;


    @OneToMany(targetEntity=ShippingCost.class,cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "shc_selling_id", referencedColumnName = "sll_id")
    private List<ShippingCost> shipCosts = new ArrayList<>();

    @OneToMany(targetEntity=ShippingCostException.class,cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "shcx_selling_id", referencedColumnName = "sll_id")
    private List<ShippingCostException> shipCostsExceptions = new ArrayList<>();

    @OneToMany(targetEntity=ShippingCostForbidden.class,cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "shf_selling_id", referencedColumnName = "sll_id")
    private List<ShippingCostForbidden> shipForbidden = new ArrayList<>();


    public SellItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProductObj() {
        return productObj;
    }

    public void setProductObj(Product productObj) {
        this.productObj = productObj;
    }

    public Seller getSellerObj() {
        return sellerObj;
    }

    public void setSellerObj(Seller sellerObj) {
        this.sellerObj = sellerObj;
    }

    public List<ShippingCost> getShipCosts() {
        return shipCosts;
    }

    public void setShipCosts(List<ShippingCost> shipCosts) {
        this.shipCosts = shipCosts;
    }

    public List<ShippingCostException> getShipCostsExceptions() {
        return shipCostsExceptions;
    }

    public void setShipCostsExceptions(List<ShippingCostException> shipCostsExceptions) {
        this.shipCostsExceptions = shipCostsExceptions;
    }

    public List<ShippingCostForbidden> getShipForbidden() {
        return shipForbidden;
    }

    public void setShipForbidden(List<ShippingCostForbidden> shipForbidden) {
        this.shipForbidden = shipForbidden;
    }
}