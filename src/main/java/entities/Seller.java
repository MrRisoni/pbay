package entities;

import javax.persistence.*;


@Entity
@Table(name = "sellers")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sel_id")
    private int id;

    @Column(name = "sel_title")
    private String title;

    @Column(name = "sel_ssn")
    private String ssn;

    @Column(name = "sel_stars_avg")
    private float starsAvg;

    public Seller(int id, String title, String ssn, float starsAvg) {
        this.id = id;
        this.title = title;
        this.ssn = ssn;
        this.starsAvg = starsAvg;
    }

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

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public float getStarsAvg() {
        return starsAvg;
    }

    public void setStarsAvg(float starsAvg) {
        this.starsAvg = starsAvg;
    }
}
