package entities;

import javax.persistence.*;


@Entity
@Table(name = "listing_watching")
public class ListingWatcher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lwi_id")
    private int id;

}
