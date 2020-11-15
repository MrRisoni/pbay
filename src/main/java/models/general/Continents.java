
package models.general;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.*;
import java.util.Collection;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.*;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "continents")
public class Continents implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "con_id")
    private Short id;

    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "con_code")
    private String code;

    @Getter
    @Setter
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

    @XmlTransient
    public Collection<Countries> getCountriesCollection() {
        return countriesCollection;
    }

    public void setCountriesCollection(Collection<Countries> countriesCollection) {
        this.countriesCollection = countriesCollection;
    }
}
