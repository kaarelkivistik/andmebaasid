package garaazh.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by kaarel on 12/04/15.
 */
@Entity
@Inheritance
public class Organisatsioon {

    @Id
    private int organisatsiooniKood;

    @Column
    @NotEmpty
    private String registriKood;

    @Column
    @NotEmpty
    private String nimi;

    @Column
    @NotEmpty
    private String aadress;

    @Column
    @NotEmpty
    private String eMail;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_organisatsiooni_riik"))
    @NotNull
    private Riik riik;

    public Organisatsioon() {
    }

    public int getOrganisatsiooniKood() {
        return organisatsiooniKood;
    }

    public String getRegistriKood() {
        return registriKood;
    }

    public void setRegistriKood(String registriKood) {
        this.registriKood = registriKood;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public Riik getRiik() {
        return riik;
    }

    public void setRiik(Riik riik) {
        this.riik = riik;
    }

    public Organisatsioon(int organisatsiooniKood, String registriKood, String nimi, Riik riik) {

        this.organisatsiooniKood = organisatsiooniKood;
        this.registriKood = registriKood;
        this.nimi = nimi;
        this.riik = riik;
    }
}
