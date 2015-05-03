package garaazh.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;

/**
 * Created by kaarel on 26/04/15.
 */
@Entity
public class Tootaja {

    @Id
    private int tootajaKood;

    @Column
    @NotEmpty
    private String isikukood;

    @Column
    private String eesnimi;

    @Column
    private String perenimi;

    @Column(unique = true)
    private String eMail;

    @Column
    private String parool;

    public Tootaja() {
    }

    public Tootaja(int tootajaKood, String isikukood, String eesnimi, String perenimi, String eMail, String parool) {
        this.tootajaKood = tootajaKood;
        this.isikukood = isikukood;
        this.eesnimi = eesnimi;
        this.perenimi = perenimi;
        this.eMail = eMail;
        this.parool = parool;
    }

    public int getTootajaKood() {
        return tootajaKood;
    }

    public String getIsikukood() {
        return isikukood;
    }

    public void setIsikukood(String isikukood) {
        this.isikukood = isikukood;
    }

    public String getEesnimi() {
        return eesnimi;
    }

    public void setEesnimi(String eesnimi) {
        this.eesnimi = eesnimi;
    }

    public String getPerenimi() {
        return perenimi;
    }

    public void setPerenimi(String perenimi) {
        this.perenimi = perenimi;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getParool() {
        return parool;
    }

    public void setParool(String parool) {
        this.parool = parool;
    }
}
