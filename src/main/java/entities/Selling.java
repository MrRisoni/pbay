package entities;

import javax.persistence.*;


@Entity
@Table(name = "selling")
public class Selling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sll_id")
    private int id;

    @Column(name = "sll_quantity")
    private int quantity;

    @Column(name = "sll_mailer_co")
    private String mailerCo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="sll_product_id")
    private Product productObj;

    public Selling() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMailerCo() {
        return mailerCo;
    }

    public void setMailerCo(String mailerCo) {
        this.mailerCo = mailerCo;
    }

    public Product getProductObj() {
        return productObj;
    }

    public void setProductObj(Product productObj) {
        this.productObj = productObj;
    }
}
