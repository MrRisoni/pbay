package models.items;

import lombok.Getter;
import lombok.Setter;
import models.sellers.Selling;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Collection;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "products")
public class Products implements Serializable {

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

    @Getter
    @Setter
    @Column
    private String otherTitle;

    @Getter
    @Setter
    @Column
    private String description;

    @Getter
    @Setter
    @Column
    private short preowned;

    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProductsCategories categoryObj;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "filterObj", fetch = FetchType.LAZY)
    private Collection<ProductsFilterValues> productsFilterValuesCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productObj", fetch = FetchType.LAZY)
    private Collection<Selling> sellingCollection;

    public Products() {
    }

    public Products(Long prodId) {
        this.id = prodId;
    }

    public Products(Long prodId, String prodTitle, String prodOtherTitle, String prodDescr, short prodPreowned) {
        this.id = prodId;
        this.title = prodTitle;
        this.otherTitle = prodOtherTitle;
        this.description = prodDescr;
        this.preowned = prodPreowned;
    }

    public ProductsCategories getCategoryObj() {
        return categoryObj;
    }

    public void setCategoryObj(ProductsCategories categoryObj) {
        this.categoryObj = categoryObj;
    }

    @XmlTransient
    public Collection<ProductsFilterValues> getProductsFilterValuesCollection() {
        return productsFilterValuesCollection;
    }

    public void setProductsFilterValuesCollection(Collection<ProductsFilterValues> productsFilterValuesCollection) {
        this.productsFilterValuesCollection = productsFilterValuesCollection;
    }

    @XmlTransient
    public Collection<Selling> getSellingCollection() {
        return sellingCollection;
    }

    public void setSellingCollection(Collection<Selling> sellingCollection) {
        this.sellingCollection = sellingCollection;
    }
}
