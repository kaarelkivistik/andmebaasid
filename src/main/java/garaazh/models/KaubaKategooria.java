package garaazh.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by kaarel on 26/04/15.
 */
@Entity
public class KaubaKategooria {

    @Id
    private int kaubaKategooriaKood;

    @Column
    @NotEmpty
    private String nimetus;

    @Column
    private String kirjeldus;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_kauba_ylemkategooria"))
    private KaubaKategooria ylemKategooria;

    public KaubaKategooria() {
    }

    public KaubaKategooria(int kaubaKategooriaKood, String nimetus, String kirjeldus, KaubaKategooria ylemKategooria) {
        this.kaubaKategooriaKood = kaubaKategooriaKood;
        this.nimetus = nimetus;
        this.kirjeldus = kirjeldus;
        this.ylemKategooria = ylemKategooria;
    }

    public int getKaubaKategooriaKood() {
        return kaubaKategooriaKood;
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

    public KaubaKategooria getYlemKategooria() {
        return ylemKategooria;
    }

    public void setYlemKategooria(KaubaKategooria ylemKategooria) {
        this.ylemKategooria = ylemKategooria;
    }
}
