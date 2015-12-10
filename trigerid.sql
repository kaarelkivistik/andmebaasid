CREATE OR REPLACE FUNCTION kaupa_ei_loodud_aktiivsena()
  RETURNS TRIGGER AS $$
BEGIN
  RAISE EXCEPTION 'Kauba loomisel saab staatus olla ainult aktiivne!';
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER kaup_insert BEFORE INSERT ON kaup
  FOR EACH ROW WHEN (NEW.kauba_staatus != 1) EXECUTE PROCEDURE kaupa_ei_loodud_aktiivsena();


CREATE OR REPLACE FUNCTION kaupa_yritati_kustutada()
  RETURNS TRIGGER AS $$
BEGIN
  RAISE EXCEPTION 'Kaupa ei saa kustutada! Mitte kunagi! Jäta see meelde!';
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER kaup_delete BEFORE DELETE ON kaup
  FOR EACH ROW EXECUTE PROCEDURE kaupa_yritati_kustutada();