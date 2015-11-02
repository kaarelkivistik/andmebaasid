CREATE DOMAIN d_nimetus varchar(100) NOT NULL DEFAULT 'nimetu'
	CHECK (VALUE !~ '^\s*$');
	
ALTER TABLE garaazh.kauba_kategooria DROP CONSTRAINT IF EXISTS CHK_kauba_kategooria_nimetus_ei_ole_tyhi;
ALTER TABLE garaazh.kauba_staatus DROP CONSTRAINT IF EXISTS CHK_kauba_staatuse_nimetus_ei_ole_tyhi;
ALTER TABLE garaazh.tootaja_staatus DROP CONSTRAINT IF EXISTS CHK_tootaja_staatuse_nimetus_ei_ole_tyhi;
ALTER TABLE garaazh.tootaja_roll DROP CONSTRAINT IF EXISTS CHK_tootaja_rolli_nimetus_ei_ole_tyhi;

ALTER TABLE garaazh.kauba_kategooria ALTER COLUMN nimetus TYPE d_nimetus;
ALTER TABLE garaazh.kauba_staatus ALTER COLUMN nimetus TYPE d_nimetus;
ALTER TABLE garaazh.tootaja_staatus ALTER COLUMN nimetus TYPE d_nimetus;
ALTER TABLE garaazh.tootaja_roll ALTER COLUMN nimetus TYPE d_nimetus;