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

    public ProductFilterValue(int id, String value) {
        this.id = id;
        this.value = value;
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
}
