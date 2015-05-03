package garaazh.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by kaarel on 02/05/15.
 */
@Entity
@Inheritance
@Table(uniqueConstraints = @UniqueConstraint(name = "UK_nimetus_on_unikaalne", columnNames = {"nimetus"}))
public abstract class Klassifikaator {
    @Id
    private int klassifikaatoriKood;

    @Column
    @NotEmpty
    private String nimetus;

    public Klassifikaator() {
    }

    public Klassifikaator(int klassifikaatoriKood, String nimetus) {

        this.klassifikaatoriKood = klassifikaatoriKood;
        this.nimetus = nimetus;
    }

    public int getKlassifikaatoriKood() {
        return klassifikaatoriKood;
    }

    public String getNimetus() {
        return nimetus;
    }

    public void setNimetus(String nimetus) {
        this.nimetus = nimetus;
    }
}
