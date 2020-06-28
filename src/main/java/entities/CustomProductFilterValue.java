package entities;

import javax.persistence.*;


@Entity
@Table(name = "custom_products_filters_values")
public class CustomProductFilterValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "csp_id")
    private int id;

    @Column(name = "csp_value")
    private String value;

    public CustomProductFilterValue(int id, String value) {
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
