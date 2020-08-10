package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = " prod_id")
    private Long id;

    @Column(name = "prod_title")
    private String title;

    @OneToMany(targetEntity=ProductFilterValue.class,cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "pfv_product_id", referencedColumnName = "prod_id")
    private List<ProductFilter> attributes = new ArrayList<>();


    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ProductFilter> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<ProductFilter> attributes) {
        this.attributes = attributes;
    }
}
