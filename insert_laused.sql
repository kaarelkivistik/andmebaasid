INSERT INTO organisatsioon(organisatsiooni_kood, organisatsiooni_tyybi_kood, aadress, e_mail, nimi, registri_kood, tarneaeg, hinne, riik) VALUES (1, 2, 'Akadeemia tee 5, Tallinn 93811, Eesti', 'info@samsung.com', 'Samsung','110A2746B2C', 	5.0, 5.0, 'EE');
INSERT INTO organisatsioon(organisatsiooni_kood, organisatsiooni_tyybi_kood, aadress, e_mail, nimi, registri_kood, tarneaeg, hinne, riik) VALUES (2, 2, 'Hobujaama 3, Tallinn 15334, Eesti', 'info@nokia.com', 'Nokia','210A2746B3D', 			5.0, 5.0, 'EE');
INSERT INTO organisatsioon(organisatsiooni_kood, organisatsiooni_tyybi_kood, aadress, e_mail, nimi, registri_kood, tarneaeg, hinne, riik) VALUES (3, 2, 'Vilde tee 18, Tallinn 13545, Eesti', 'info@dell.com', 'Dell','310A2746B4E', 			5.0, 5.0, 'EE');
INSERT INTO organisatsioon(organisatsiooni_kood, organisatsiooni_tyybi_kood, aadress, e_mail, nimi, registri_kood, tarneaeg, hinne, riik) VALUES (4, 2, 'Müürivahe 33, Tallinn 85773, Eesti', 'info@asus.com', 'Asus','410A2746B5F', 			5.0, 5.0, 'EE');
INSERT INTO organisatsioon(organisatsiooni_kood, organisatsiooni_tyybi_kood, aadress, e_mail, nimi, registri_kood, tarneaeg, hinne, riik) VALUES (5, 2, 'Viru tn 9, Tallinn 34283, Eesti', 'info@intel.com', 'Intel','510A2746B6G', 				5.0, 5.0, 'EE');
INSERT INTO organisatsioon(organisatsiooni_kood, organisatsiooni_tyybi_kood, aadress, e_mail, nimi, registri_kood, tarneaeg, hinne, riik) VALUES (6, 1, 'Kopli liinid, Tallinn 01337, Eesti', 'mart@hot.ee', 'Mardi Kiirkuller','43J2HJHJH23', 	5.0, 5.0, 'EE');

INSERT INTO tootaja(tootaja_kood, e_mail, eesnimi, isikukood, parool, perenimi) VALUES (1, 'hans@mets.ee', 'Hans', '38503053399', 'parool1', 'Mets');
INSERT INTO tootaja(tootaja_kood, e_mail, eesnimi, isikukood, parool, perenimi) VALUES (2, 'jaan@koer.ee', 'Jaan', '38404053539', 'parool2', 'Koer');
INSERT INTO tootaja(tootaja_kood, e_mail, eesnimi, isikukood, parool, perenimi) VALUES (3, 'nele@keel.ee', 'Nele', '49011124567', 'parool3', 'Keel');
INSERT INTO tootaja(tootaja_kood, e_mail, eesnimi, isikukood, parool, perenimi) VALUES (4, 'ingrid@leht.ee', 'Ingrid', '48503058475', 'parool4', 'Leht');
INSERT INTO tootaja(tootaja_kood, e_mail, eesnimi, isikukood, parool, perenimi) VALUES (5, 'jaanus@paber.ee', 'Jaanus', '38803084390', 'parool5', 'Paber');

INSERT INTO kaup(kauba_kood, hind, korgus, laius, nimetus, pikkus, kauba_kategooria, kauba_staatus, tootaja, tarnija, tootja) VALUES ('123456789', 15.5, 200, 200, 'DELL 90W AC Adapter', 			200, 1, 1, 1, 6, 1);
INSERT INTO kaup(kauba_kood, hind, korgus, laius, nimetus, pikkus, kauba_kategooria, kauba_staatus, tootaja, tarnija, tootja) VALUES ('987654321', 20.5, 250, 250, 'Playstation 4', 				250, 7, 1, 1, 6, 2);
INSERT INTO kaup(kauba_kood, hind, korgus, laius, nimetus, pikkus, kauba_kategooria, kauba_staatus, tootaja, tarnija, tootja) VALUES ('483659682', 25.5, 100, 50, 'iPhone 6', 						10,  4, 1, 1, 6, 3);
INSERT INTO kaup(kauba_kood, hind, korgus, laius, nimetus, pikkus, kauba_kategooria, kauba_staatus, tootaja, tarnija, tootja) VALUES ('759384627', 35.5, 220, 200, 'Samsung 3.5 D3 Station 5TB', 	200, 1, 1, 1, 6, 4);
INSERT INTO kaup(kauba_kood, hind, korgus, laius, nimetus, pikkus, kauba_kategooria, kauba_staatus, tootaja, tarnija, tootja) VALUES ('649027384', 45.5, 100, 50, 'Samsung Galaxy S6', 				10,  4, 1, 1, 6, 5);
