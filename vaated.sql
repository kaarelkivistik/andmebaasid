DROP VIEW IF EXISTS kauba_kuvatav_info;
CREATE VIEW kauba_kuvatav_info WITH (security_barrier) AS
  SELECT
    kaup.kauba_kood,
    kaup.nimetus                                                       AS kauba_nimi,
    kaup.hind,
    kaup.korgus,
    kaup.laius,
    kaup.pikkus,
    kategooria.nimetus                                                 AS kategooria_nimi,
    tootja.nimi || ', ' || tootja.registri_kood || ', ' || tootja.riik AS tootja,
    tootja.hinne                                                       AS tootja_reiting,
    tarnija.nimi                                                       AS tarnija,
    tarnija.tarneaeg                                                   AS tarnija_tarneaeg
  FROM kaup AS kaup
    INNER JOIN organisatsioon AS tootja ON kaup.tootja = tootja.organisatsiooni_kood
    INNER JOIN kauba_kategooria AS kategooria ON kaup.kauba_kategooria = kategooria.kauba_kategooria_kood
    INNER JOIN organisatsioon AS tarnija ON kaup.tarnija = tarnija.organisatsiooni_kood
  WHERE kaup.kauba_staatus = 1;

COMMENT ON VIEW kauba_kuvatav_info IS 'Vaade implementeerib lugemisoperatsiooni, mille käigus tagastatakse kõikide aktiivsete kaupade info, mida näidatakse rakenduses kaupade loetelu vormis.';

DROP VIEW IF EXISTS ylemkategooria;
CREATE VIEW ylemkategooria WITH (security_barrier) AS
  SELECT
    kategooria.kauba_kategooria_kood AS kategooria_kood,
    kategooria.nimetus,
    kategooria.kirjeldus
  FROM kauba_kategooria AS kategooria
  WHERE kategooria.ylem_kategooria IS NULL;

COMMENT ON VIEW ylemkategooria IS 'Vaade implementeerib lugemisoperatsiooni, mille käigus tagastatakse kõik ülemkategooriad ehk kategooriad, millel puudub esivanem.';

DROP VIEW IF EXISTS aktiivne_tootaja;
CREATE VIEW aktiivne_tootaja WITH (security_barrier) AS
  SELECT tootaja.tootaja_kood AS tootaja_kood,
         tootaja.isikukood AS isikukood,
         tootaja.tootaja_rolli_kood AS tootaja_rolli_kood,
         tootaja.tootaja_staatuse_kood AS tootaja_staatuse_kood,
         tootaja.e_mail AS e_mail,
         tootaja.eesnimi AS eesnimi,
         tootaja.perenimi AS perenimi
  FROM tootaja AS tootaja
  WHERE tootaja_staatuse_kood = 1;

COMMENT ON VIEW aktiivne_tootaja IS 'Vaade implementeerib lugemisoperatsiooni, mille käigus tagastatakse kõik aktiivsed töötajad.';

DROP VIEW IF EXISTS kaupade_haldur;
CREATE VIEW kaupade_haldur WITH (security_barrier) AS
  SELECT tootaja.tootaja_kood AS tootaja_kood,
         tootaja.isikukood AS isikukood,
         tootaja.tootaja_rolli_kood AS tootaja_rolli_kood,
         tootaja.tootaja_staatuse_kood AS tootaja_staatuse_kood,
         tootaja.e_mail AS e_mail,
         tootaja.eesnimi AS eesnimi,
         tootaja.perenimi AS perenimi
  FROM tootaja AS tootaja
  WHERE tootaja_rolli_kood = 1;

COMMENT ON VIEW kaupade_haldur IS 'Vaade implementeerib lugemisoperatsiooni, mille käigus tagastatakse kõik töötajad, kelle rolliks on kaupade haldur.';

DROP VIEW IF EXISTS tarnija;
CREATE VIEW tarnija WITH (security_barrier) AS
  SELECT *
  FROM organisatsioon
  WHERE organisatsiooni_tyybi_kood = 1;

COMMENT ON VIEW tarnija IS 'Vaade implementeerib lugemisoperatsiooni, mille käigus tagastatakse kõik tarnija-tüüpi organisatsioonid.';

DROP VIEW IF EXISTS tootja;
CREATE VIEW tootja WITH (security_barrier) AS
  SELECT *
  FROM organisatsioon
  WHERE organisatsiooni_tyybi_kood = 2;

COMMENT ON VIEW tootja IS 'Vaade implementeerib lugemisoperatsiooni, mille käigus tagastatakse kõik tootja-tüüpi organisatsioonid.';
