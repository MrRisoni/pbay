package models;

import javax.persistence.*;

@Entity
@Table(name="products_filter_values")
public class ProductFilterValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pfv_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pfv_filter_id")
    private ProductFilter filterObj;


    @Column(name="pfv_value")
    private String value;

    public ProductFilterValue() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductFilter getFilterObj() {
        return filterObj;
    }

    public void setFilterObj(ProductFilter filterObj) {
        this.filterObj = filterObj;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
