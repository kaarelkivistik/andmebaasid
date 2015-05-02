package garaazh.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Created by kaarel on 20/04/15.
 */

@Entity
public class Tarnija extends Organisatsioon {

    @Column
    private BigDecimal tarneaeg;

    public Tarnija() {
    }

    public Tarnija(int organisatsiooniKood, String registriKood, String nimi, Riik riik, BigDecimal tarneaeg) {
        super(organisatsiooniKood, registriKood, nimi, riik);
        this.tarneaeg = tarneaeg;
    }
}
