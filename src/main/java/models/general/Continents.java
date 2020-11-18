package models.general;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Collection;
import javax.xml.bind.annotation.*;

@Entity
@Table(name = "continents")
public class Continents implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @Column
    private Long id;

    @Getter
    @Setter
    @Column
    private String code;

    @Getter
    @Setter
    @Column
    private String title;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ctrContinentId", fetch = FetchType.LAZY)
    private Collection<Countries> countriesCollection;

    public Continents() {
    }

    public Continents(Long conId) {
        this.id = conId;
    }

    public Continents(Long conId, String conCode, String conTitle) {
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
