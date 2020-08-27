
package models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
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
    private Integer lwiId;
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
        this.lwiId = lwiId;
    }

    public ListingWatching(Integer lwiId, long lwiUserUd, long lwiListingId) {
        this.lwiId = lwiId;
        this.lwiUserUd = lwiUserUd;
        this.lwiListingId = lwiListingId;
    }

    public Integer getLwiId() {
        return lwiId;
    }

    public void setLwiId(Integer lwiId) {
        this.lwiId = lwiId;
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
        hash += (lwiId != null ? lwiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListingWatching)) {
            return false;
        }
        ListingWatching other = (ListingWatching) object;
        if ((this.lwiId == null && other.lwiId != null) || (this.lwiId != null && !this.lwiId.equals(other.lwiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.ListingWatching[ lwiId=" + lwiId + " ]";
    }
    
}
