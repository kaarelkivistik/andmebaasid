package garaazh.models;

import javax.persistence.*;

/**
 * Created by kaarel on 26/04/15.
 */
@Entity
public class KaubaKategooria extends Klassifikaator {
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_kategooria_ylemkategooria"))
    private KaubaKategooria ylemKategooria;

    public KaubaKategooria() {
    }

    public KaubaKategooria(int kood, String nimetus) {
        super(kood, nimetus);
    }

    public KaubaKategooria(int kood, String nimetus, KaubaKategooria ylemKategooria) {
        super(kood, nimetus);
        this.ylemKategooria = ylemKategooria;
    }

    public KaubaKategooria getYlemKategooria() {
        return ylemKategooria;
    }

    public void setYlemKategooria(KaubaKategooria kategooria) {
        this.ylemKategooria = kategooria;
    }
}
