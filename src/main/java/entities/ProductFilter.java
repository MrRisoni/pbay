package entities;

import javax.persistence.*;


@Entity
@Table(name = "products_filters")
public class ProductFilter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fil_id")
    private int id;


    @Column(name = "fil_title")
    private String title;

    public ProductFilter(){}

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
}
