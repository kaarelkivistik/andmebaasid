package garaazh.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by kaarel on 12/04/15.
 */

@Entity
// me = "Kaubad", uniqueConstraints = {@UniqueConstraint(columnNames = {"kood"})})
public class Kaup {

    @Id
    private long kood;

    @Column
    private String nimetus;

    @Column
    private BigDecimal hind;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kaup")
    private List<KaubaOmadus> omadused;

    @ManyToOne(cascade = CascadeType.ALL)
    private Seisund seisund;

    @ManyToOne(cascade = CascadeType.ALL)
    private Kategooria kategooria;

    @ManyToOne(cascade = CascadeType.ALL)
    private Tootja tootja;

    @ManyToOne(cascade = CascadeType.ALL)
    private Tarnija tarnija;

    @ManyToOne(cascade = CascadeType.ALL)
    private Tootaja tootaja;

    public Kaup() {
    }

    public long getKood() {
        return kood;
    }

    public void setKood(long kood) {
        this.kood = kood;
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

    public List<KaubaOmadus> getOmadused() {
        return omadused;
    }

    public void setOmadused(List<KaubaOmadus> omadused) {
        this.omadused = omadused;
    }

    public Seisund getSeisund() {
        return seisund;
    }

    public void setSeisund(Seisund seisund) {
        this.seisund = seisund;
    }

    public Kategooria getKategooria() {
        return kategooria;
    }

    public void setKategooria(Kategooria kategooria) {
        this.kategooria = kategooria;
    }

    public Tootja getTootja() {
        return tootja;
    }

    public void setTootja(Tootja tootja) {
        this.tootja = tootja;
    }

    public Tarnija getTarnija() {
        return tarnija;
    }

    public void setTarnija(Tarnija tarnija) {
        this.tarnija = tarnija;
    }

    public Tootaja getTootaja() {
        return tootaja;
    }

    public void setTootaja(Tootaja tootaja) {
        this.tootaja = tootaja;
    }
}