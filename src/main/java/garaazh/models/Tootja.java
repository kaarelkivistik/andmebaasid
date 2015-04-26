package garaazh.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by kaarel on 20/04/15.
 */

@Entity
// @DiscriminatorValue("TO")
public class Tootja extends Organisatsioon {

    @Column
    private Float hinne;

    public Tootja() {
    }

    public Tootja(long registriKood, String nimi, Float hinne) {
        super(registriKood, nimi);
        this.hinne = hinne;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (hinne != null ? hinne.hashCode() : 0);
        return result;
    }
}
