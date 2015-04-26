package garaazh.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by kaarel on 12/04/15.
 */
@Entity
public class Seisund {

    @Id
    @GeneratedValue
    private long kood;

    @Column(unique = true)
    private String nimetus;

    public Seisund() {
    }

    public Seisund(String nimetus) {
        this.nimetus = nimetus;
    }

    public long getKood() {
        return kood;
    }

    public String getNimetus() {
        return nimetus;
    }
}
