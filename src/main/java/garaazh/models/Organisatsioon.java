package garaazh.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by kaarel on 12/04/15.
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "UK_org_on_riigiti_unikaalne", columnNames = {"registriKood", "riik"}))
@Inheritance
public class Organisatsioon {

    @Id
    @GeneratedValue
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
    @Email
    @NotEmpty
    private String eMail;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_organisatsiooni_riik"))
    @NotNull
    private Riik riik;

    public Organisatsioon() {
    }

    public Organisatsioon(String registriKood, String nimi, String aadress, String eMail, Riik riik) {
        this.registriKood = registriKood;
        this.nimi = nimi;
        this.aadress = aadress;
        this.eMail = eMail;
        this.riik = riik;
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

    public String getAadress() {
        return aadress;
    }

    public void setAadress(String aadress) {
        this.aadress = aadress;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}
