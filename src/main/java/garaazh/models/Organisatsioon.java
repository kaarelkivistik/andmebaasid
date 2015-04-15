package garaazh.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by kaarel on 12/04/15.
 */
@Entity
public class Organisatsioon {

    @Id private long registriKood;
    @Column private String nimi;

    public Organisatsioon() {
    }

    public Organisatsioon(long registriKood, String nimi) {
        this.registriKood = registriKood;
        this.nimi = nimi;
    }

    public long getRegistriKood() {
        return registriKood;
    }

    public void setRegistriKood(long registriKood) {
        this.registriKood = registriKood;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
}
