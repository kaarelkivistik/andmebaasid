DROP DOMAIN IF EXISTS d_nimetus;
CREATE DOMAIN d_nimetus varchar(100) NOT NULL DEFAULT 'nimetu'
	CHECK (VALUE !~ '^\s*$');
	
ALTER TABLE kauba_kategooria DROP CONSTRAINT IF EXISTS CHK_kauba_kategooria_nimetus_ei_ole_tyhi;
ALTER TABLE kauba_staatus DROP CONSTRAINT IF EXISTS CHK_kauba_staatuse_nimetus_ei_ole_tyhi;
ALTER TABLE tootaja_staatus DROP CONSTRAINT IF EXISTS CHK_tootaja_staatuse_nimetus_ei_ole_tyhi;
ALTER TABLE tootaja_roll DROP CONSTRAINT IF EXISTS CHK_tootaja_rolli_nimetus_ei_ole_tyhi;
ALTER TABLE organisatsiooni_tyyp DROP CONSTRAINT IF EXISTS CHK_organisatsiooni_tyybi_nimetus_ei_ole_tyhi;

ALTER TABLE kauba_kategooria ALTER COLUMN nimetus TYPE d_nimetus;
ALTER TABLE kauba_staatus ALTER COLUMN nimetus TYPE d_nimetus;
ALTER TABLE tootaja_staatus ALTER COLUMN nimetus TYPE d_nimetus;
ALTER TABLE tootaja_roll ALTER COLUMN nimetus TYPE d_nimetus;
ALTER TABLE organisatsiooni_tyyp ALTER COLUMN organisatsiooni_tyybi_nimetus TYPE d_nimetus;