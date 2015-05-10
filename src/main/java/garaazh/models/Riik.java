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
        columnNames = {"nimi"}))
public class Riik {

    @Id
    @Column(length = 2)
    @Pattern(regexp = "^[A-Z]{2}$")
    @NotEmpty
    private String riigiKood;

    @Column
    @NotEmpty
    private String nimi;

    public Riik() {
    }

    public Riik(String riigiKood, String nimi) {
        this.riigiKood = riigiKood;
        this.nimi = nimi;
    }

    public String getRiigiKood() {
        return riigiKood;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
}
