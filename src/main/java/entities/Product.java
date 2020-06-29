package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id")
    private int id;

    @Column(name = "prod_title")
    private String title;

    @Column(name = "prod_other_title")
    private String otherTitle;

    @Column(name = "prod_descr")
    private String descr;

    @Column(name = "prod_preowned")
    private boolean preowned;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prod_category_id")
    private ProductCategory prodCatObj;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    @JoinColumn(name = "pfv_product_id")
    private Set<ProductFilterValue> filterVals = new HashSet<>();


    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOtherTitle() {
        return otherTitle;
    }

    public void setOtherTitle(String otherTitle) {
        this.otherTitle = otherTitle;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public boolean isPreowned() {
        return preowned;
    }

    public void setPreowned(boolean preowned) {
        this.preowned = preowned;
    }

    public ProductCategory getProdCatObj() {
        return prodCatObj;
    }

    public void setProdCatObj(ProductCategory prodCatObj) {
        this.prodCatObj = prodCatObj;
    }

    public Set<ProductFilterValue> getFilterVals() {
        return filterVals;
    }

    public void setFilterVals(Set<ProductFilterValue> filterVals) {
        this.filterVals = filterVals;
    }
}
