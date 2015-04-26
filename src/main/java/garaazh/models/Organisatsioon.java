package garaazh.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;

/**
 * Created by kaarel on 12/04/15.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Organisatsioon)) return false;

        Organisatsioon that = (Organisatsioon) o;

        if (registriKood != that.registriKood) return false;
        return nimi.equals(that.nimi);

    }

    @Override
    public int hashCode() {
        int result = (int) (registriKood ^ (registriKood >>> 32));
        result = 31 * result + nimi.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Organisatsioon{" +
                "registriKood=" + registriKood +
                ", nimi='" + nimi + '\'' +
                '}';
    }
}
