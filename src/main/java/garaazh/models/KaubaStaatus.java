package garaazh.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by kaarel on 12/04/15.
 */
@Entity
public class KaubaStaatus extends Klassifikaator {
    public KaubaStaatus() {
    }

    public KaubaStaatus(int kood, String nimetus) {
        super(kood, nimetus);
    }
}
