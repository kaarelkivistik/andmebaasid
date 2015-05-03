package garaazh.models;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

/**
 * Created by kaarel on 02/05/15.
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "UK_riik_on_unikaalne",
        columnNames = {"nimi", "identifikaator2Tahte", "identifikaator3Tahte"}))
public class Riik {

    @Id
    private short riigiKood;

    @Column
    @NotEmpty
    private String nimi;

    @Column(length = 2)
    @Pattern(regexp = "^[A-Z]{2}$")
    @NotEmpty
    private String identifikaator2Tahte;

    @Column(length = 3)
    @Pattern(regexp = "^[A-Z]{3}$")
    @NotEmpty
    private String identifikaator3Tahte;

    public Riik() {
    }

    public Riik(short riigiKood, String nimi, String identifikaator2Tahte, String identifikaator3Tahte) {
        this.riigiKood = riigiKood;
        this.nimi = nimi;
        this.identifikaator2Tahte = identifikaator2Tahte;
        this.identifikaator3Tahte = identifikaator3Tahte;
    }

    public short getRiigiKood() {
        return riigiKood;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getIdentifikaator2Tahte() {
        return identifikaator2Tahte;
    }

    public void setIdentifikaator2Tahte(String identifikaator2Tahte) {
        this.identifikaator2Tahte = identifikaator2Tahte;
    }

    public String getIdentifikaator3Tahte() {
        return identifikaator3Tahte;
    }

    public void setIdentifikaator3Tahte(String identifikaator3Tahte) {
        this.identifikaator3Tahte = identifikaator3Tahte;
    }
}
