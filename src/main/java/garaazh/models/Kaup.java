package garaazh.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by kaarel on 12/04/15.
 */

@Entity
// me = "Kaubad", uniqueConstraints = {@UniqueConstraint(columnNames = {"kood"})})
public class Kaup {

    @Id
    private int kaubaKood;

    @Column
    @NotEmpty
    private String nimetus;

    @Column
    @NotNull
    @DecimalMin("0.0")
    private BigDecimal hind;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_kauba_staatus"))
    @NotNull
    private KaubaStaatus kaubaStaatus;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_kauba_kategooria"))
    @NotNull
    private KaubaKategooria kaubaKategooria;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_kauba_tootja"))
    @NotNull
    private Tootja tootja;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_kauba_tarnija"))
    @NotNull
    private Tarnija tarnija;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_kauba_tootaja"))
    @NotNull
    private Tootaja tootaja;

    @Column
    private int pikkus;

    @Column
    private int laius;

    @Column
    private int korgus;

    @Column
    private String pildiAadress;

    public Kaup() {
    }

    public long getKaubaKood() {
        return kaubaKood;
    }

    public void setKaubaKood(int kood) {
        this.kaubaKood = kood;
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

    public KaubaStaatus getKaubaStaatus() {
        return kaubaStaatus;
    }

    public void setKaubaStaatus(KaubaStaatus kaubaStaatus) {
        this.kaubaStaatus = kaubaStaatus;
    }

    public KaubaKategooria getKaubaKategooria() {
        return kaubaKategooria;
    }

    public void setKaubaKategooria(KaubaKategooria kaubaKategooria) {
        this.kaubaKategooria = kaubaKategooria;
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

    public int getPikkus() {
        return pikkus;
    }

    public void setPikkus(int pikkus) {
        this.pikkus = pikkus;
    }

    public int getLaius() {
        return laius;
    }

    public void setLaius(int laius) {
        this.laius = laius;
    }

    public int getKorgus() {
        return korgus;
    }

    public void setKorgus(int korgus) {
        this.korgus = korgus;
    }

    public String getPildiAadress() {
        return pildiAadress;
    }

    public void setPildiAadress(String pildiAadress) {
        this.pildiAadress = pildiAadress;
    }
}