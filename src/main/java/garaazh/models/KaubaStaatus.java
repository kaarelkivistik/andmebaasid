package garaazh.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by kaarel on 12/04/15.
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "UK_nimetus_on_unikaalne", columnNames = "nimetus"))
public class KaubaStaatus {

    @Id
    private short kaubaStaatuseKood;

    @Column
    @NotEmpty
    private String nimetus;

    @Column
    private String kirjeldus;

    public KaubaStaatus() {
    }

    public KaubaStaatus(short kaubaStaatuseKood, String nimetus, String kirjeldus) {
        this.kaubaStaatuseKood = kaubaStaatuseKood;
        this.nimetus = nimetus;
        this.kirjeldus = kirjeldus;
    }

    public short getKaubaStaatuseKood() {
        return kaubaStaatuseKood;
    }

    public String getNimetus() {
        return nimetus;
    }

    public void setNimetus(String nimetus) {
        this.nimetus = nimetus;
    }

    public String getKirjeldus() {
        return kirjeldus;
    }

    public void setKirjeldus(String kirjeldus) {
        this.kirjeldus = kirjeldus;
    }
}
