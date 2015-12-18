CREATE OR REPLACE FUNCTION kaupa_ei_loodud_aktiivsena()
  RETURNS TRIGGER AS $$
BEGIN
  RAISE EXCEPTION 'Kauba loomisel saab staatus olla ainult aktiivne!';
END;
$$ LANGUAGE plpgsql;

COMMENT ON FUNCTION kaupa_ei_loodud_aktiivsena() IS 'Kui kauba staatus pole loomisel aktiivne, siis visatakse selle funktsiooniga erand.';


CREATE TRIGGER kaup_insert BEFORE INSERT ON kaup
  FOR EACH ROW WHEN (NEW.kauba_staatus != 1) EXECUTE PROCEDURE kaupa_ei_loodud_aktiivsena();

COMMENT ON TRIGGER kaup_insert ON kaup IS 'Kauba loomisel kontrollitakse kas loodav kaup on aktiivne';

CREATE OR REPLACE FUNCTION kaupa_yritati_kustutada()
  RETURNS TRIGGER AS $$
BEGIN
  RAISE EXCEPTION 'Kaupa ei saa kustutada! Mitte kunagi! Jäta see meelde!';
END;
$$ LANGUAGE plpgsql;

COMMENT ON FUNCTION kaupa_yritati_kustutada() IS 'Kauba kustutamisel visatakse selle funktsiooniga erand.';


CREATE TRIGGER kaup_delete BEFORE DELETE ON kaup
  FOR EACH ROW EXECUTE PROCEDURE kaupa_yritati_kustutada();

COMMENT ON TRIGGER kaup_delete ON kaup IS 'Kauba kustutamist jälgitakse ning enne seda visatakse erand.';
