package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "selling")
public class Selling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sll_id")
    private int id;

    @Column(name = "sll_quantity")
    private int quantity;

    @Column(name = "sll_mailer_co")
    private String mailerCo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="sll_product_id")
    private Product productObj;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="sll_seller_id")
    private Seller sellerObj;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    @JoinColumn(name = "shc_selling_id")
    private Set<ShippingCost> shipCosts = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    @JoinColumn(name = "shcx_selling_id")
    private Set<ShippingCostsException> shipExcepts = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    @JoinColumn(name = "shf_selling_id")
    private Set<ShippingCountryForbidden> shipVerboten = new HashSet<>();

    public Selling() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMailerCo() {
        return mailerCo;
    }

    public void setMailerCo(String mailerCo) {
        this.mailerCo = mailerCo;
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

    public Set<ShippingCost> getShipCosts() {
        return shipCosts;
    }

    public void setShipCosts(Set<ShippingCost> shipCosts) {
        this.shipCosts = shipCosts;
    }

     public Set<ShippingCostsException> getShipExcepts() {
        return shipExcepts;
    }

    public void setShipExcepts(Set<ShippingCostsException> shipExcepts) {
        this.shipExcepts = shipExcepts;
    }

    public Set<ShippingCountryForbidden> getShipVerboten() {
        return shipVerboten;
    }

    public void setShipVerboten(Set<ShippingCountryForbidden> shipVerboten) {
        this.shipVerboten = shipVerboten;
    }
}
