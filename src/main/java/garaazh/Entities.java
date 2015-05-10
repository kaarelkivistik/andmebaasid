package garaazh;

import garaazh.models.*;

import java.math.BigDecimal;

/**
 * Created by kaarel on 03/05/15.
 */
public class Entities {

    public static final Tootaja TOOTAJA_LAGUNOV = new Tootaja("39212344321", "Laomees", "Lagunov", "laomees@hot.ee", "JkbHb7tVt");


    public static final Riik RIIK_EESTI = new Riik("EE", "Eesti");

    public static final Riik RIIK_LEEDU = new Riik("LT", "Leedu");


    public static final KaubaStaatus KAUBA_STAATUS_AKTIIVNE =
            new KaubaStaatus((short) 1, "aktiivne", "Kaup on aktiivne ning müügis");

    public static final KaubaStaatus KAUBA_STAATUS_MITTEAKTIIVNE =
            new KaubaStaatus((short) 2, "mitteaktiivne", "Kaup on mitteaktiivne ning ei ole müügis");

    public static final KaubaStaatus KAUBA_STAATUS_KUSTUTATUD =
            new KaubaStaatus((short) 3, "kustutatud", "Kaup on kustutatud");


    public static final KaubaKategooria KAUBA_KATEGOORIA_ARVUTIKOMPONENDID =
            new KaubaKategooria(1, "Arvutikomponendid", null, null);

    public static final KaubaKategooria KAUBA_KATEGOORIA_EMAPLAADID =
            new KaubaKategooria(2, "Emaplaadid", null, KAUBA_KATEGOORIA_ARVUTIKOMPONENDID);


    public static final Tootja TOOTJA_SAMYANG =
            new Tootja("4324322", "Samyang", "Siin on aadress", "info@samyang.ch", RIIK_EESTI, 3.3f);

    public static final Tootja TOOTJA_SAMSUNG =
            new Tootja("49832892", "Samsung", "Siin on aadress", "info@samsung.com", RIIK_EESTI, 4.5f);

    public static final Tarnija TARNIJA_GEDIMINAS =
            new Tarnija("893923", "Gediminas Transports UAB", "Siin on aadress", "gediminas@limpa.ru", RIIK_LEEDU, 60f);

    public static final Tarnija TARNIJA_RISKIKULLER =
            new Tarnija("3492889", "Riskikuller OÜ", "Siin on aadress", "riski@kuller.ee", RIIK_EESTI, 0.5f);


    public static final Kaup KAUP_ABIT_EXTREME_EMAPLAAT =
            new Kaup("2937492836591",
                    "ABIT Extreme Gaming MOBO",
                    new BigDecimal("699.9"),
                    KAUBA_STAATUS_AKTIIVNE,
                    KAUBA_KATEGOORIA_EMAPLAADID,
                    TOOTJA_SAMSUNG,
                    TARNIJA_RISKIKULLER,
                    TOOTAJA_LAGUNOV,
                    200,
                    150,
                    10,
                    null);
}
