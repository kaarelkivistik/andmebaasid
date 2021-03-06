INSERT INTO kauba_kategooria(kauba_kategooria_kood, ylem_kategooria, nimetus, kirjeldus) VALUES (1, NULL, 'Arvutikomponendid', 'Erinevad komponendid arvutitele.');
INSERT INTO kauba_kategooria(kauba_kategooria_kood, ylem_kategooria, nimetus, kirjeldus) VALUES (2, 1, 'Kõvakettad', 'SSD ning HDD kõvakettad.');
INSERT INTO kauba_kategooria(kauba_kategooria_kood, ylem_kategooria, nimetus, kirjeldus) VALUES (3, 1, 'Mälud', 'Operatiivmälud.');
INSERT INTO kauba_kategooria(kauba_kategooria_kood, ylem_kategooria, nimetus, kirjeldus) VALUES (4, NULL, 'Telefonid', 'Erinevad nuti- ning mobiiltelefonid.');
INSERT INTO kauba_kategooria(kauba_kategooria_kood, ylem_kategooria, nimetus, kirjeldus) VALUES (5, 4, 'Samsung Galaxy 6', 'Samsung Galaxy 6 nutitelefon.');
INSERT INTO kauba_kategooria(kauba_kategooria_kood, ylem_kategooria, nimetus, kirjeldus) VALUES (6, 1, 'Emaplaadid', 'Valik erinevaid emaplaate.');
INSERT INTO kauba_kategooria(kauba_kategooria_kood, ylem_kategooria, nimetus, kirjeldus) VALUES (7, NULL, 'Mängukonsoolid', 'Valik erinevaid mängukonsoole.');
INSERT INTO kauba_kategooria(kauba_kategooria_kood, ylem_kategooria, nimetus, kirjeldus) VALUES (8, 7, 'Sony Playstation 4', 'Sony Playstation 4 mängukonsool.');

INSERT INTO kauba_staatus(kauba_staatuse_kood, nimetus, kirjeldus) VALUES (0, 'kustutatud', 'Kaup on kustutatud, kuid säilib siiski süsteemis.');
INSERT INTO kauba_staatus(kauba_staatuse_kood, nimetus, kirjeldus) VALUES (1, 'aktiivne', 'Kaup on müügil.');
INSERT INTO kauba_staatus(kauba_staatuse_kood, nimetus, kirjeldus) VALUES (2, 'mitteaktiivne', 'Kaup ei ole müügil.');

INSERT INTO tootaja_roll(tootaja_rolli_kood, nimetus, kirjeldus) VALUES (1, 'kaupade_haldur', 'See annab õiguse teha mida iganes.');

INSERT INTO tootaja_staatus(tootaja_staatuse_kood, nimetus, kirjeldus) VALUES (1, 'aktiivne', 'Töötaja on tegev.');
INSERT INTO tootaja_staatus(tootaja_staatuse_kood, nimetus, kirjeldus) VALUES (2, 'mitteaktiivne', 'Töötaja ei ole tegev.');

INSERT INTO organisatsiooni_tyyp(organisatsiooni_tyybi_kood, organisatsiooni_tyybi_nimetus) VALUES (1, 'tarnija');
INSERT INTO organisatsiooni_tyyp(organisatsiooni_tyybi_kood, organisatsiooni_tyybi_nimetus) VALUES (2, 'tootja');

INSERT INTO riik(riigi_kood, nimi) VALUES ('EE', 'Eesti');
INSERT INTO riik(riigi_kood, nimi) VALUES ('RU', 'Venemaa');
INSERT INTO riik(riigi_kood, nimi) VALUES ('LV', 'Läti');
INSERT INTO riik(riigi_kood, nimi) VALUES ('LT', 'Leedu');
INSERT INTO riik(riigi_kood, nimi) VALUES ('FI', 'Soome');
