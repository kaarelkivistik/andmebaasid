/* Trigerid */

DROP TRIGGER kaup_insert ON kaup;
DROP TRIGGER kaup_delete ON kaup;

/* Funktsioonid */

DROP FUNCTION f_uuenda_kaupa(uuendatava_kauba_kood VARCHAR(20), _nimetus VARCHAR(255), _hind NUMERIC(19), _pikkus INT, _korgus INT, laius INT, _pildi_aadress VARCHAR(255), _kauba_kategooria INT, _tootja INT, _tarnija INT);
DROP FUNCTION f_kustuta_kaup(kauba_kood VARCHAR);
DROP FUNCTION f_uuenda_kauba_staatus_aktiivseks(uuendatava_kauba_kood VARCHAR(20));
DROP FUNCTION f_uuenda_kauba_staatus_mitteaktiivseks(uuendatava_kauba_kood VARCHAR(20));