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
}