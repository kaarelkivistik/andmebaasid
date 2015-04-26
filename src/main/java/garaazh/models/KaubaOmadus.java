package garaazh.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by kaarel on 26/04/15.
 */
@Entity
public class KaubaOmadus {
    @Id
    @GeneratedValue
    private long kood;

    @OneToOne
    @JsonIgnore
    private Kaup kaup;

    @OneToOne
    private Omadus omadus;

    @Column
    private String vaartus;

    public KaubaOmadus() {
    }

    public KaubaOmadus(Kaup kaup, Omadus omadus, String vaartus) {
        this.kaup = kaup;
        this.omadus = omadus;
        this.vaartus = vaartus;
    }

    public long getKood() {
        return kood;
    }

    public Kaup getKaup() {
        return kaup;
    }

    public void setKaup(Kaup kaup) {
        this.kaup = kaup;
    }

    public Omadus getOmadus() {
        return omadus;
    }

    public void setOmadus(Omadus omadus) {
        this.omadus = omadus;
    }

    public String getVaartus() {
        return vaartus;
    }

    public void setVaartus(String vaartus) {
        this.vaartus = vaartus;
    }

    @Override
    public String toString() {
        return "KaubaOmadus{" +
                "kood=" + kood +
                ", omadus=" + omadus +
                ", vaartus='" + vaartus + '\'' +
                '}';
    }
}
