package garaazh.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

/**
 * Created by kaarel on 12/04/15.
 */

@Entity
// me = "Kaubad", uniqueConstraints = {@UniqueConstraint(columnNames = {"kood"})})
public class Kaup {

    @Id @GeneratedValue private long kood;
    @Column private String nimetus;
    @Column private BigDecimal hind;
    @ManyToOne(cascade = CascadeType.ALL) private KaubaSeisund seisund;
    @ManyToOne(cascade = CascadeType.ALL) private Organisatsioon tootja;
    @ManyToOne(cascade = CascadeType.ALL) private Organisatsioon tarnija;

    public Kaup() {
    }

    public Kaup(String nimetus, BigDecimal hind, KaubaSeisund seisund, Organisatsioon tootja, Organisatsioon tarnija) {
        this.nimetus = nimetus;
        this.hind = hind;
        this.seisund = seisund;
        this.tootja = tootja;
        this.tarnija = tarnija;
    }

    public long getKood() {
        return kood;
    }

    public String getNimetus() {
        return nimetus;
    }

    public void setNimetus(String nimetus) {
        this.nimetus = nimetus;
    }

    public BigDecimal getHind() {
        return hind;
    }

    public void setHind(BigDecimal hind) {
        this.hind = hind;
    }

    public KaubaSeisund getSeisund() {
        return seisund;
    }

    public void setSeisund(KaubaSeisund seisund) {
        this.seisund = seisund;
    }

    public Organisatsioon getTootja() {
        return tootja;
    }

    public void setTootja(Organisatsioon tootja) {
        this.tootja = tootja;
    }

    public Organisatsioon getTarnija() {
        return tarnija;
    }

    public void setTarnija(Organisatsioon tarnija) {
        this.tarnija = tarnija;
    }
}