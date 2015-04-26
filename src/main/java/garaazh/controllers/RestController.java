package garaazh.controllers;

import garaazh.models.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaarel on 26/04/15.
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {

    public static final Tootaja defaultTootaja = new Tootaja("39212344321", "Laomees Lagunov", "laomees@hot.ee", "JkbHb7tVt");

    @PersistenceUnit
    EntityManagerFactory entityManagerFactory;

    @PostConstruct
    protected void setUp() throws Exception {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Tootja samyang = new Tootja(1337, "Samyang", 2f);
        Tarnija gediminas = new Tarnija(1340, "Gediminas Transports UAB", new BigDecimal(10));

        entityManager.persist(samyang);
        entityManager.persist(new Tootja(1338, "Samsung", 3.7f));
        entityManager.persist(new Tootja(1339, "chiPhone Industries Ltd", 0.5f));

        entityManager.persist(gediminas);
        entityManager.persist(new Tarnija(1341, "OÜ Patsaanid", new BigDecimal(60)));
        entityManager.persist(new Tarnija(1342, "OÜ Riskikuller", new BigDecimal(1)));

        Omadus pikkus = new Omadus("pikkus");
        Omadus laius = new Omadus("laius");
        Omadus varv = new Omadus("värv");
        entityManager.persist(pikkus);
        entityManager.persist(laius);
        entityManager.persist(varv);
        entityManager.persist(new Omadus("sügavus"));
        entityManager.persist(new Omadus("võimsus"));
        entityManager.persist(new Omadus("siinikiirus"));
        entityManager.persist(new Omadus("maht"));

        Kategooria emaplaadid = new Kategooria(null, "Emaplaadid");
        entityManager.persist(emaplaadid);
        entityManager.persist(new Kategooria(null, "Mälud"));
        entityManager.persist(new Kategooria(null, "Toiteplokid"));

        Seisund aktiivne = new Seisund("aktiivne");
        entityManager.persist(aktiivne);
        entityManager.persist(new Seisund("mitteaktiivne"));

        Kaup kaup = new Kaup();
        kaup.setKood(7832872);
        kaup.setNimetus("ABIT eXtreme Gaming Board");
        kaup.setTarnija(gediminas);
        kaup.setTootja(samyang);

        List<KaubaOmadus> kaubaOmadused = new ArrayList<>();
        kaubaOmadused.add(new KaubaOmadus(kaup, pikkus, "250mm"));
        kaubaOmadused.add(new KaubaOmadus(kaup, laius, "180mm"));
        kaubaOmadused.add(new KaubaOmadus(kaup, varv, "must"));
        kaup.setOmadused(kaubaOmadused);
        kaup.setSeisund(aktiivne);
        kaup.setKategooria(emaplaadid);
        kaup.setHind(new BigDecimal("449.90"));

        entityManager.persist(kaup);

        entityManager.getTransaction().commit();

        entityManager.close();
    }

    @RequestMapping("/api/kaubad")
    public List<Kaup> kaubad() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.createQuery("SELECT a FROM Kaup AS a").getResultList();
    }

    @RequestMapping("/api/kaubad/{kood}")
    public Kaup kaup(@PathVariable String kood) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return (Kaup) entityManager.createQuery("SELECT a FROM Kaup AS a WHERE kood = ?1")
                .setParameter(1, Long.parseLong(kood))
                .getResultList().get(0);
    }

    @RequestMapping("/api/tootjad")
    public List<Tootja> tootjad() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.createQuery("SELECT a FROM Tootja AS a").getResultList();
    }

    @RequestMapping("/api/tarnijad")
    public List<Tarnija> tarnijad() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.createQuery("SELECT a FROM Tarnija AS a").getResultList();
    }

    @RequestMapping("/api/omadused")
    public List<Omadus> omadused() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.createQuery("SELECT a FROM Omadus AS a").getResultList();
    }

    @RequestMapping("/api/seisundid")
    public List<Omadus> seisundid() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.createQuery("SELECT a FROM Seisund AS a").getResultList();
    }

    @RequestMapping("/api/kategooriad")
    public List<Omadus> kategooriad() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.createQuery("SELECT a FROM Kategooria AS a").getResultList();
    }

    @RequestMapping(value = "/api/kaubad", method = RequestMethod.POST)
    public ResponseEntity<Kaup> lisaKaup(@RequestBody Kaup kaup) {
        System.out.println(kaup);

        for(KaubaOmadus kaubaOmadus : kaup.getOmadused())
            kaubaOmadus.setKaup(kaup);

        kaup.setTootaja(defaultTootaja);

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(kaup);
        entityManager.getTransaction().commit();
        entityManager.close();

        return new ResponseEntity<>(kaup, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/kaubad/{kood}", method = RequestMethod.DELETE)
    public ResponseEntity<Kaup> kustutaKaup(@PathVariable String kood) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Kaup kaup = entityManager.find(Kaup.class, Long.parseLong(kood));

        kaup.setKategooria(null);
        kaup.setSeisund(null);
        kaup.setTarnija(null);
        kaup.setTootaja(null);
        kaup.setTootja(null);

        if(kaup.getOmadused() != null)
            for (KaubaOmadus kaubaOmadus : kaup.getOmadused()) {
                kaubaOmadus.setOmadus(null);
            }

        entityManager.getTransaction().begin();
        entityManager.remove(kaup);
        entityManager.getTransaction().commit();
        entityManager.close();

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
