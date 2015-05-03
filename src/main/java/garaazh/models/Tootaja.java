package garaazh.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

/**
 * Created by kaarel on 26/04/15.
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "UK_e_mail_on_unikaalne", columnNames = {"eMail"}))
public class Tootaja {

    @Id
    @GeneratedValue
    private int tootajaKood;

    @Column
    @NotEmpty
    private String isikukood;

    @Column
    @NotEmpty
    private String eesnimi;

    @Column
    @NotEmpty
    private String perenimi;

    @Column
    @Email
    @NotEmpty
    private String eMail;

    @Column
    @NotEmpty
    private String parool;

    public Tootaja() {
    }

    public Tootaja(String isikukood, String eesnimi, String perenimi, String eMail, String parool) {
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
