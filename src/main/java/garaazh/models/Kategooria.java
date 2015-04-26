package garaazh.models;

import javax.persistence.*;

/**
 * Created by kaarel on 26/04/15.
 */
@Entity
public class Kategooria {
    @Id
    @GeneratedValue
    private long kood;

    @OneToOne
    private Kategooria kategooria;

    @Column
    private String nimetus;

    public Kategooria() {

    }

    public Kategooria(Kategooria kategooria, String nimetus) {
        this.kategooria = kategooria;
        this.nimetus = nimetus;
    }

    public long getKood() {
        return kood;
    }

    public Kategooria getKategooria() {
        return kategooria;
    }

    public void setKategooria(Kategooria kategooria) {
        this.kategooria = kategooria;
    }

    public String getNimetus() {
        return nimetus;
    }

    public void setNimetus(String nimetus) {
        this.nimetus = nimetus;
    }
}
