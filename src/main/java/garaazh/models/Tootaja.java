package garaazh.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by kaarel on 26/04/15.
 */
@Entity
public class Tootaja {
    @Id
    private String isikukood;

    @Column
    private String nimi;

    @Column
    private String eMail;

    @Column
    private String parool;

    public Tootaja() {
    }

    public Tootaja(String isikukood, String nimi, String eMail, String parool) {
        this.isikukood = isikukood;
        this.nimi = nimi;
        this.eMail = eMail;
        this.parool = parool;
    }

    public String getIsikukood() {
        return isikukood;
    }

    public void setIsikukood(String isikukood) {
        this.isikukood = isikukood;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
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
