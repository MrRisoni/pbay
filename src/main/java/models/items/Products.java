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
    @Column(name = "prod_id")
    private Integer id;

    @Getter
    @Setter
    @Column(name = "prod_title")
    private String title;

    @Getter
    @Setter
    @Column(name = "prod_other_title")
    private String otherTitle;

    @Getter
    @Setter
    @Column(name = "prod_descr")
    private String description;

    @Getter
    @Setter
    @Column(name = "prod_preowned")
    private short isPreOwned;

    @JoinColumn(name = "prod_category_id", referencedColumnName = "cat_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProductsCategories categoryObj;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "filterObj", fetch = FetchType.LAZY)
    private Collection<ProductsFilterValues> productsFilterValuesCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productObj", fetch = FetchType.LAZY)
    private Collection<Selling> sellingCollection;

    public Products() {
    }

    public Products(Integer prodId) {
        this.id = prodId;
    }

    public Products(Integer prodId, String prodTitle, String prodOtherTitle, String prodDescr, short prodPreowned) {
        this.id = prodId;
        this.title = prodTitle;
        this.otherTitle = prodOtherTitle;
        this.description = prodDescr;
        this.isPreOwned = prodPreowned;
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
