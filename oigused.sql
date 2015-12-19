DROP USER IF EXISTS garaazh_rakendus;
CREATE USER garaazh_rakendus WITH PASSWORD 'garaga';

REVOKE CONNECT, TEMP ON DATABASE t123665 FROM PUBLIC; 
REVOKE CREATE, USAGE ON SCHEMA public FROM PUBLIC;
REVOKE USAGE ON LANGUAGE plpgsql FROM PUBLIC;

REVOKE EXECUTE ON FUNCTION
f_uuenda_kaupa(uuendatava_kauba_kood VARCHAR(20), _nimetus VARCHAR(255), _hind NUMERIC(19), _pikkus INT, _korgus INT, _laius INT, _pildi_aadress VARCHAR(255), _kauba_kategooria INT, _tootja INT, _tarnija INT),
f_kustuta_kaup(kauba_kood VARCHAR),
f_uuenda_kauba_staatus_aktiivseks(uuendatava_kauba_kood VARCHAR(20)),
f_uuenda_kauba_staatus_mitteaktiivseks(uuendatava_kauba_kood VARCHAR(20)) FROM PUBLIC;

GRANT CONNECT ON DATABASE t123665 TO garaazh_rakendus; 
GRANT USAGE ON SCHEMA public TO garaazh_rakendus;

GRANT SELECT, UPDATE ON TABLE kaup TO garaazh_rakendus;
GRANT SELECT ON TABLE kauba_kategooria TO garaazh_rakendus;
GRANT SELECT ON TABLE tootja TO garaazh_rakendus;
GRANT SELECT ON TABLE tarnija TO garaazh_rakendus;
GRANT SELECT ON TABLE tootaja TO garaazh_rakendus;

GRANT EXECUTE ON FUNCTION
f_on_kaupade_haldur(text, text),
f_uuenda_kaupa(uuendatava_kauba_kood VARCHAR(20), _nimetus VARCHAR(255), _hind NUMERIC(19), _pikkus INT, _korgus INT, _laius INT, _pildi_aadress VARCHAR(255), _kauba_kategooria INT, _tootja INT, _tarnija INT),
f_kustuta_kaup(kauba_kood VARCHAR),
f_uuenda_kauba_staatus_aktiivseks(uuendatava_kauba_kood VARCHAR(20)),
f_uuenda_kauba_staatus_mitteaktiivseks(uuendatava_kauba_kood VARCHAR(20))
TO garaazh_rakendus;