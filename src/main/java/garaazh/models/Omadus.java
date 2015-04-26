package garaazh.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by kaarel on 26/04/15.
 */
@Entity
public class Omadus {

    @Id
    @GeneratedValue
    private long kood;

    @Column
    private String nimetus;

    public Omadus() {

    }

    public Omadus(String nimetus) {

        this.nimetus = nimetus;
    }

    public long getKood() {
        return kood;
    }

    public String getNimetus() {
        return nimetus;
    }

    public void setNimetus(String nimetus) {
        this.nimetus = nimetus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Omadus omadus = (Omadus) o;

        if (kood != omadus.kood) return false;
        return nimetus.equals(omadus.nimetus);

    }

    @Override
    public int hashCode() {
        int result = (int) (kood ^ (kood >>> 32));
        result = 31 * result + nimetus.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Omadus{" +
                "kood=" + kood +
                ", nimetus='" + nimetus + '\'' +
                '}';
    }
}
