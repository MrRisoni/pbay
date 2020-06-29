package entities;

import javax.persistence.*;


@Entity
@Table(name = "products_filter_values")
public class ProductFilterValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pfv_id")
    private int id;

    @Column(name = "pfv_value")
    private String value;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pfv_filter_id")
    private ProductFilter filtrObj;

    public ProductFilterValue() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ProductFilter getFiltrObj() {
        return filtrObj;
    }

    public void setFiltrObj(ProductFilter filtrObj) {
        this.filtrObj = filtrObj;
    }
}
