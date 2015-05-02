package garaazh.models;

import javax.persistence.Entity;

/**
 * Created by kaarel on 02/05/15.
 */
@Entity
public class Riik extends Klassifikaator {

    public Riik() {
    }

    public Riik(int klassifikaatoriKood, String nimetus) {
        super(klassifikaatoriKood, nimetus);
    }
}
