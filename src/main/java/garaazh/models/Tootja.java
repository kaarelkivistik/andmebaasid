package garaazh.models;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

/**
 * Created by kaarel on 20/04/15.
 */

@Entity
// @DiscriminatorValue("TO")
public class Tootja extends Organisatsioon {

    @Column
    @DecimalMin("0.0")
    @DecimalMax("5.0")
    @NotNull
    private Float hinne;

    public Tootja() {
    }

    public Tootja(String registriKood, String nimi, String aadress, String eMail, Riik riik, Float hinne) {
        super(registriKood, nimi, aadress, eMail, riik);
        this.hinne = hinne;
    }

    public Float getHinne() {
        return hinne;
    }

    public void setHinne(Float hinne) {
        this.hinne = hinne;
    }
}
