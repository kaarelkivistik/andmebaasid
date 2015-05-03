package garaazh.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

/**
 * Created by kaarel on 20/04/15.
 */

@Entity
public class Tarnija extends Organisatsioon {

    @Column
    @DecimalMin("0.0")
    @NotNull
    private float tarneaeg;

    public Tarnija() {
    }

    public Tarnija(String registriKood, String nimi, String aadress, String eMail, Riik riik, float tarneaeg) {
        super(registriKood, nimi, aadress, eMail, riik);
        this.tarneaeg = tarneaeg;
    }

    public float getTarneaeg() {
        return tarneaeg;
    }

    public void setTarneaeg(float tarneaeg) {
        this.tarneaeg = tarneaeg;
    }
}
