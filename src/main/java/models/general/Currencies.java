package models.general;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "currencies")
public class Currencies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Short id;

    @Getter
    @Setter
    @Column
    private String code;

    public Currencies() {
    }

    public Currencies(Short curId) {
        this.id = curId;
    }

    public Currencies(Short curId, String curCode) {
        this.id = curId;
        this.code = curCode;
    }
}