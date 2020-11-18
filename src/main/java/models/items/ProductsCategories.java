package models.items;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Collection;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "products_categories")
public class ProductsCategories implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Getter
    @Setter
    @Column
    private String title;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryObj", fetch = FetchType.LAZY)
    private Collection<ProductsFilters> productsFiltersCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryObj", fetch = FetchType.LAZY)
    private Collection<Products> productsCollection;

    public ProductsCategories() {
    }

    public ProductsCategories(Long catId) {
        this.id = catId;
    }

    public ProductsCategories(Long catId, String catTitle) {
        this.id = catId;
        this.title = catTitle;
    }

    @XmlTransient
    public Collection<ProductsFilters> getProductsFiltersCollection() {
        return productsFiltersCollection;
    }

    public void setProductsFiltersCollection(Collection<ProductsFilters> productsFiltersCollection) {
        this.productsFiltersCollection = productsFiltersCollection;
    }

    @XmlTransient
    public Collection<Products> getProductsCollection() {
        return productsCollection;
    }

    public void setProductsCollection(Collection<Products> productsCollection) {
        this.productsCollection = productsCollection;
    }
}
