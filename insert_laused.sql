#Kauba kategooria

INSERT INTO garaazh.kauba_kategooria(kauba_kategooria_kood, ylem_kategooria, nimetus, kirjeldus) VALUES (1, NULL, 'Arvutikomponendid', 'Erinevad komponendid arvutitele.');

INSERT INTO garaazh.kauba_kategooria(kauba_kategooria_kood, ylem_kategooria, nimetus, kirjeldus) VALUES (2, 1, 'Kõvakettad', 'SSD ning HDD kõvakettad.');

INSERT INTO garaazh.kauba_kategooria(kauba_kategooria_kood, ylem_kategooria, nimetus, kirjeldus) VALUES (3, 1, 'Mälud', 'Operatiivmälud.');

INSERT INTO garaazh.kauba_kategooria(kauba_kategooria_kood, ylem_kategooria, nimetus, kirjeldus) VALUES (4, NULL, 'Telefonid', 'Erinevad nuti- ning mobiiltelefonid.');

INSERT INTO garaazh.kauba_kategooria(kauba_kategooria_kood, ylem_kategooria, nimetus, kirjeldus) VALUES (5, 4, 'Samsung Galaxy 6', 'Samsung Galaxy 6 nutitelefon.');

INSERT INTO garaazh.kauba_kategooria(kauba_kategooria_kood, ylem_kategooria, nimetus, kirjeldus) VALUES (6, 1, 'Emaplaadid', 'Valik erinevaid emaplaate.');
	
INSERT INTO garaazh.kauba_kategooria(kauba_kategooria_kood, ylem_kategooria, nimetus, kirjeldus) VALUES (7, NULL, 'Mängukonsoolid', 'Valik erinevaid mängukonsoole.');

INSERT INTO garaazh.kauba_kategooria(kauba_kategooria_kood, ylem_kategooria, nimetus, kirjeldus) VALUES (8, 7, 'Sony Playstation 4', 'Sony Playstation 4 mängukonsool.');


#Kauba staatus

INSERT INTO garaazh.kauba_staatus(kauba_staatuse_kood, nimetus, kirjeldus) VALUES (1, 'aktiivne', 'Lenovo IdeaPad sülearvuti Intel i3 protsessoriga.');

INSERT INTO garaazh.kauba_staatus(kauba_staatuse_kood, nimetus, kirjeldus) VALUES (2, 'mitteaktiivne', 'Playstation 3 mängukonsool.');


#Töötaja roll

INSERT INTO garaazh.tootaja_roll(tootaja_rolli_kood, nimetus, kirjeldus) VALUES (1, 'kaupade_haldaja', 'See annab õiguse teha mida iganes.');

#Töötaja staatus

INSERT INTO garaazh.tootaja_staatus(tootaja_staatuse_kood, nimetus, kirjeldus) VALUES (1, 'aktiivne', 'Töötaja on tegev.');

INSERT INTO garaazh.tootaja_staatus(tootaja_staatuse_kood, nimetus, kirjeldus) VALUES (2, 'mitteaktiivne', 'Töötaja ei ole tegev.');

#Riik

INSERT INTO garaazh.riik(riigi_kood, nimi) VALUES ('EE', 'Eesti');

INSERT INTO garaazh.riik(riigi_kood, nimi) VALUES ('RU', 'Venemaa');

INSERT INTO garaazh.riik(riigi_kood, nimi) VALUES ('LV', 'Läti');

INSERT INTO garaazh.riik(riigi_kood, nimi) VALUES ('LT', 'Leedu');

INSERT INTO garaazh.riik(riigi_kood, nimi) VALUES ('FI', 'Soome');


#Organisatsioon

INSERT INTO garaazh.organisatsioon(organisatsiooni_kood, aadress, e_mail, nimi, registri_kood, tarneaeg, hinne, riik) VALUES (11027462, 'Akadeemia tee 5, Tallinn 93811, Eesti', 'info@samsung.com', 'Samsung','110A2746B2C', 5.0, 5.0, 'EE');

INSERT INTO garaazh.organisatsioon(organisatsiooni_kood, aadress, e_mail, nimi, registri_kood, tarneaeg, hinne, riik) VALUES (11027463, 'Hobujaama 3, Tallinn 15334, Eesti', 'info@nokia.com', 'Nokia','210A2746B3D', 5.0, 5.0, 'EE');

INSERT INTO garaazh.organisatsioon(organisatsiooni_kood, aadress, e_mail, nimi, registri_kood, tarneaeg, hinne, riik) VALUES (11027464, 'Vilde tee 18, Tallinn 13545, Eesti', 'info@dell.com', 'Dell','310A2746B4E', 5.0, 5.0, 'EE');

INSERT INTO garaazh.organisatsioon(organisatsiooni_kood, aadress, e_mail, nimi, registri_kood, tarneaeg, hinne, riik) VALUES (11027465, 'Müürivahe 33, Tallinn 85773, Eesti', 'info@asus.com', 'Asus','410A2746B5F', 5.0, 5.0, 'EE');

INSERT INTO garaazh.organisatsioon(organisatsiooni_kood, aadress, e_mail, nimi, registri_kood, tarneaeg, hinne, riik) VALUES (11027466, 'Viru tn 9, Tallinn 34283, Eesti', 'info@intel.com', 'Intel','510A2746B6G', 5.0, 5.0, 'EE');


#Kaup 

INSERT INTO garaazh.kaup(kauba_kood, hind, korgus, laius, nimetus, pikkus, pildi_aadress, kauba_kategooria, kauba_staatus, tarnija, tootaja, tootja) VALUES ('123456789', 15.5, 200, 200, 'DELL 90W AC Adapter', 200, 'http://www.usalaptopbattery.com/image/cache/data/Dell/dell-pa-3e-500x500.jpg', 1, 2, 3, 4, 5);

INSERT INTO garaazh.kaup(kauba_kood, hind, korgus, laius, nimetus, pikkus, pildi_aadress, kauba_kategooria, kauba_staatus, tarnija, tootaja, tootja) VALUES ('987654321', 20.5, 250, 250, 'Playstation 4', 250, 'https://psmedia.playstation.com/is/image/psmedia/ps4-system-imageblock-us-13jun14?$TwoColumn_Image$', 7, 1, 3, 4, 5);

INSERT INTO garaazh.kaup(kauba_kood, hind, korgus, laius, nimetus, pikkus, pildi_aadress, kauba_kategooria, kauba_staatus, tarnija, tootaja, tootja) VALUES ('483659682', 25.5, 100, 50, 'iPhone 6', 10, 'http://cdn2.macworld.co.uk/cmsdata/reviews/3534761/iPhone_6_MG_1953.jpg', 4, 2, 3, 4, 5);

INSERT INTO garaazh.kaup(kauba_kood, hind, korgus, laius, nimetus, pikkus, pildi_aadress, kauba_kategooria, kauba_staatus, tarnija, tootaja, tootja) VALUES ('759384627', 35.5, 220, 200, 'Samsung 3.5 D3 Station 5TB', 200, 'http://brain.pan.e-merchant.com/0/8/22424780/l_22424780.jpg', 1, 1, 3, 4, 5);

INSERT INTO garaazh.kaup(kauba_kood, hind, korgus, laius, nimetus, pikkus, pildi_aadress, kauba_kategooria, kauba_staatus, tarnija, tootaja, tootja) VALUES ('649027384', 45.5, 100, 50, 'Samsung Galaxy S6', 10, 'http://www.samsung.com/ee/consumer-images/product/smart-phones/2015/SM-G920FZBASEB/features/SM-G920FZBASEB-403979-0.jpg', 4, 2, 3, 4, 5);

#Tootaja

INSERT INTO garaazh.tootaja(tootaja_kood, e_mail, eesnimi, isikukood, parool, perenimi) VALUES (1, 'hans@mets.ee', 'Hans', '38503053399', 'parool1', 'Mets');

INSERT INTO garaazh.tootaja(tootaja_kood, e_mail, eesnimi, isikukood, parool, perenimi) VALUES (2, 'jaan@koer.ee', 'Jaan', '38404053539', 'parool2', 'Koer');

INSERT INTO garaazh.tootaja(tootaja_kood, e_mail, eesnimi, isikukood, parool, perenimi) VALUES (3, 'nele@keel.ee', 'Nele', '49011124567', 'parool3', 'Keel');

INSERT INTO garaazh.tootaja(tootaja_kood, e_mail, eesnimi, isikukood, parool, perenimi) VALUES (4, 'ingrid@leht.ee', 'Ingrid', '48503058475', 'parool4', 'Leht');

INSERT INTO garaazh.tootaja(tootaja_kood, e_mail, eesnimi, isikukood, parool, perenimi) VALUES (5, 'jaanus@paber.ee', 'Jaanus', '38803084390', 'parool5', 'Paber');
