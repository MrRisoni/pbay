
package models.items;

import com.fasterxml.jackson.annotation.JsonView;
import models.JackSonViewer;

import java.io.Serializable;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Collection;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import javax.xml.bind.annotation.XmlTransient;


@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "products_categories")
public class ProductsCategories implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cat_id")
    @JsonView({JackSonViewer.IOrder.class, JackSonViewer.IOrder.class})
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cat_title")
    @JsonView({JackSonViewer.IOrder.class, JackSonViewer.IOrder.class})
    private String title;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryObj", fetch = FetchType.LAZY)
    private Collection<ProductsFilters> productsFiltersCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryObj", fetch = FetchType.LAZY)
    private Collection<Products> productsCollection;

    public ProductsCategories() {
    }

    public ProductsCategories(Integer catId) {
        this.id = catId;
    }

    public ProductsCategories(Integer catId, String catTitle) {
        this.id = catId;
        this.title = catTitle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
