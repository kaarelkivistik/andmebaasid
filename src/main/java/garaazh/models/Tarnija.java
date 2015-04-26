package garaazh.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Created by kaarel on 20/04/15.
 */

@Entity
// @DiscriminatorValue("TA")
public class Tarnija extends Organisatsioon {

    @Column
    private BigDecimal tarneaeg;

    public Tarnija() {
    }

    public Tarnija(long registriKood, String nimi, BigDecimal tarneaeg) {
        super(registriKood, nimi);
        this.tarneaeg = tarneaeg;
    }
}
