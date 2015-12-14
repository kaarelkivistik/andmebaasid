CREATE OR REPLACE FUNCTION f_on_kaupade_haldaja(text, text)
RETURNS boolean AS $$
DECLARE
rslt boolean;
BEGIN
SELECT INTO rslt (parool = public.crypt($2, parool))
FROM tootaja WHERE e_mail=$1 AND tootaja_rolli_kood IN
(1) AND tootaja_staatuse_kood IN (1);
RETURN coalesce(rslt, FALSE);
END;
$$ LANGUAGE plpgsql SECURITY DEFINER STABLE
SET search_path = public, pg_temp;

COMMENT ON FUNCTION f_on_kaupade_haldaja(text, text) IS '(OP1.1) Selle funktsiooni abil autenditakse kaupade haldaja. Funktsiooni 
väljakutsel on esimene argument e-mail ja teine argument parool. Kaupade halduril on õigus süsteemi siseneda,
vaid siis kui tema seisundiks on aktiivne';
