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
}
