CREATE OR REPLACE FUNCTION uuenda_kaupa(uuendatava_kauba_kood VARCHAR(20), _nimetus VARCHAR(255), _hind NUMERIC(19), _pikkus INT, _korgus INT, laius INT, _pildi_aadress VARCHAR(255), _kauba_kategooria INT, _tootja INT, _tarnija INT)

RETURNS VOID AS $$

UPDATE kaup as k
SET nimetus = _nimetus, hind = _hind, pikkus = _pikkus, korgus = _korgus, pildi_aadress = _pildi_aadress, kauba_kategooria = _kauba_kategooria, tootja = _tootja, tarnija = _tarnija WHERE kauba_kood = uuendatava_kauba_kood AND kauba_staatus != 3;

$$ LANGUAGE SQL SECURITY DEFINER SET SEARCH_PATH = public, pg_temp;

COMMENT ON FUNCTION uuenda_kauba_staatus_mitteaktiivseks (VARCHAR) IS '(OP6.1) Muudab kauba infot.';
DROP FUNCTION uuenda_kaupa(uuendatava_kauba_kood VARCHAR(20), _nimetus VARCHAR(255), _hind NUMERIC(19), _pikkus INT, _korgus INT, laius INT, _pildi_aadress VARCHAR(255), _kauba_kategooria INT, _tootja INT, _tarnija INT);



CREATE OR REPLACE FUNCTION kustuta_kaup(kauba_kood VARCHAR) 

RETURNS void AS $$

UPDATE kaup SET kauba_staatus = 0 WHERE kauba_kood = $1 AND kauba_staatus = 1; 

$$ LANGUAGE SQL SECURITY DEFINER

SET search_path = public, pg_temp;

COMMENT ON FUNCTION kustuta_kaup(kauba_kood VARCHAR) IS '(OP7.1) Kauba kustutamisel muutub kauba staatus 0-ks.';
DROP FUNCTION kustuta_kaup(kauba_kood VARCHAR);



CREATE OR REPLACE FUNCTION uuenda_kauba_staatus_aktiivseks(uuendatava_kauba_kood VARCHAR(20))

RETURNS VOID AS $$

UPDATE kaup
SET kauba_staatus = 1
WHERE kauba_kood = uuendatava_kauba_kood AND kauba_staatus = 2;

$$ LANGUAGE SQL SECURITY DEFINER SET SEARCH_PATH = public, pg_temp;

COMMENT ON FUNCTION uuenda_kauba_staatus_aktiivseks (VARCHAR) IS '(OP3.1) Seab kauba aktiivseks.';
DROP FUNCTION uuenda_kauba_staatus_aktiivseks(uuendatava_kauba_kood VARCHAR(20));



CREATE OR REPLACE FUNCTION uuenda_kauba_staatus_mitteaktiivseks(uuendatava_kauba_kood VARCHAR(20))

RETURNS VOID AS $$

UPDATE kaup
SET kauba_staatus = 2
WHERE kauba_kood = uuendatava_kauba_kood AND kauba_staatus = 1;

$$ LANGUAGE SQL SECURITY DEFINER SET SEARCH_PATH = public, pg_temp;

COMMENT ON FUNCTION uuenda_kauba_staatus_mitteaktiivseks (VARCHAR) IS '(OP4.1) Seab kauba mitteaktiivseks.';
DROP FUNCTION uuenda_kauba_staatus_mitteaktiivseks(uuendatava_kauba_kood VARCHAR(20));