package garaazh.models;

import garaazh.Entities;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by kaarel on 12/04/15.
 */

@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "UK_nimetus_on_unikaalne", columnNames = "nimetus"))
public class Kaup {

    @Id
    @Column(length = 20)
    private String kaubaKood;

    @Column
    @NotEmpty
    private String nimetus;

    @Column
    @DecimalMin("0.0")
    @NotNull
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
    @Min(0)
    private int pikkus;

    @Column
    @Min(0)
    private int laius;

    @Column
    @Min(0)
    private int korgus;

    @Column
    private String pildiAadress;

    public Kaup() {
        this.kaubaStaatus = Entities.KAUBA_STAATUS_AKTIIVNE;
    }

    public Kaup(String kaubaKood,
                String nimetus,
                BigDecimal hind,
                KaubaStaatus kaubaStaatus,
                KaubaKategooria kaubaKategooria,
                Tootja tootja,
                Tarnija tarnija,
                Tootaja tootaja,
                int pikkus,
                int laius,
                int korgus,
                String pildiAadress) {
        this.kaubaKood = kaubaKood;
        this.nimetus = nimetus;
        this.hind = hind;
        this.kaubaStaatus = kaubaStaatus;
        this.kaubaKategooria = kaubaKategooria;
        this.tootja = tootja;
        this.tarnija = tarnija;
        this.tootaja = tootaja;
        this.pikkus = pikkus;
        this.laius = laius;
        this.korgus = korgus;
        this.pildiAadress = pildiAadress;
    }

    public String getKaubaKood() {
        return kaubaKood;
    }

    public void setKaubaKood(String kaubaKood) {
        this.kaubaKood = kaubaKood;
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