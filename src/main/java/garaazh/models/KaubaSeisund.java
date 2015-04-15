package garaazh.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by kaarel on 12/04/15.
 */
@Entity
public class KaubaSeisund {

    @Id @GeneratedValue private long kood;
    @Column private String nimetus;

    public KaubaSeisund() {
    }

    public KaubaSeisund(String nimetus) {
        this.nimetus = nimetus;
    }

    public long getKood() {
        return kood;
    }

    public String getNimetus() {
        return nimetus;
    }
}
