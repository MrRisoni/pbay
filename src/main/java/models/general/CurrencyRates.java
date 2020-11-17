package models.general;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "currency_rates")
public class CurrencyRates implements Serializable {
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
    private String fromCode;

    @Getter
    @Setter
    @Column
    private String toCode;

    @Getter
    @Setter
    @Column
    private BigDecimal rate;

    public CurrencyRates() {
    }

    public CurrencyRates(Short id) {
        this.id = id;
    }
}
