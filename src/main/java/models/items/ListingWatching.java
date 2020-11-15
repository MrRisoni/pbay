
package models.items;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.*;

import javax.validation.constraints.NotNull;



@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "listing_watching")
public class ListingWatching implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lwi_id")
    private Integer id;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Column(name = "lwi_user_ud")
    private long lwiUserUd;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Column(name = "lwi_listing_id")
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
