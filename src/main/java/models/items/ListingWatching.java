
package models.items;

import java.io.Serializable;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.*;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "listing_watching")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListingWatching.findAll", query = "SELECT l FROM ListingWatching l")})
public class ListingWatching implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lwi_id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "lwi_user_ud")
    private long lwiUserUd;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getLwiUserUd() {
        return lwiUserUd;
    }

    public void setLwiUserUd(long lwiUserUd) {
        this.lwiUserUd = lwiUserUd;
    }

    public long getLwiListingId() {
        return lwiListingId;
    }

    public void setLwiListingId(long lwiListingId) {
        this.lwiListingId = lwiListingId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListingWatching)) {
            return false;
        }
        ListingWatching other = (ListingWatching) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.items.ListingWatching[ lwiId=" + id + " ]";
    }
    
}
