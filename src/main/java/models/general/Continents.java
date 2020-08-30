
package models.general;

import java.io.Serializable;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.*;
import java.util.Collection;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.*;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "continents")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Continents.findAll", query = "SELECT c FROM Continents c")})
public class Continents implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "con_id")
    private Short id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "con_code")
    private String code;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "con_title")
    private String title;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ctrContinentId", fetch = FetchType.LAZY)
    private Collection<Countries> countriesCollection;

    public Continents() {
    }

    public Continents(Short conId) {
        this.id = conId;
    }

    public Continents(Short conId, String conCode, String conTitle) {
        this.id = conId;
        this.code = conCode;
        this.title = conTitle;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlTransient
    public Collection<Countries> getCountriesCollection() {
        return countriesCollection;
    }

    public void setCountriesCollection(Collection<Countries> countriesCollection) {
        this.countriesCollection = countriesCollection;
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
        if (!(object instanceof Continents)) {
            return false;
        }
        Continents other = (Continents) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.general.Continents[ conId=" + id + " ]";
    }
    
}
