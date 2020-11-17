package models.items;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "listing_watching")
public class ListingWatching implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Getter
    @Setter
    @Column
    private long lwiUserUd;

    @Getter
    @Setter
    @Column
    private long lwiListingId;

    public ListingWatching() {
    }

    public ListingWatching(Integer lwiId) {
        this.id = lwiId;
    }

    public ListingWatching(Integer lwiId, long lwiUserUd, long lwiListingId) {
        this.id = lwiId;
        this.lwiUserUd = lwiUserUd;
        this.lwiListingId = lwiListingId;
    }
}
