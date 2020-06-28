package entities;

import javax.persistence.*;


@Entity
@Table(name = "paymethods")
public class PayMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pm_id")
    private int id;

    @Column(name = "pm_title")
    private String title;

    public PayMethod(){}

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
