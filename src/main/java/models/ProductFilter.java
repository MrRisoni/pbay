package models;

import javax.persistence.*;

@Entity
@Table(name="products_filters")
public class ProductFilter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = " fil_id")
    private Long id;

    @Column(name = "fil_title")
    private String title;


    public ProductFilter() {
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
}
