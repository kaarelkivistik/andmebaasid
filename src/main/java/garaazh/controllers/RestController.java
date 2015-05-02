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
import java.util.List;

/**
 * Created by kaarel on 26/04/15.
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {

    public static final Tootaja defaultTootaja = new Tootaja(1, "39212344321", "Laomees", "Lagunov", "laomees@hot.ee", "JkbHb7tVt");

    @PersistenceUnit
    EntityManagerFactory entityManagerFactory;

    @PostConstruct
    protected void setUp() throws Exception {
        /*Riik eesti = new Riik(6, "Eesti");
        Riik leedu = new Riik(6, "Leedu");
        Tootja samyang = new Tootja(1, "89213989", "Samyang", leedu, 3.3f);
        Tarnija gediminas = new Tarnija(2, "938249842", "Gediminas Transports UAB", leedu, new BigDecimal(10));
        KaubaKategooria emaplaadid = new KaubaKategooria(1, "Emaplaadid");
        KaubaStaatus aktiivne = new KaubaStaatus(2, "aktiivne");

        Kaup kaup = new Kaup();
        kaup.setKaubaKood(7832872);
        kaup.setNimetus("ABIT eXtreme Gaming Board");
        kaup.setTarnija(gediminas);
        kaup.setTootja(samyang);
        kaup.setKaubaStaatus(aktiivne);
        kaup.setKaubaKategooria(emaplaadid);
        kaup.setHind(new BigDecimal("449.90"));
        kaup.setTootaja(defaultTootaja);

        entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(defaultTootaja);

        entityManager.persist(samyang);
        entityManager.persist(new Tootja(3, "93482984239", "Samsung", eesti, 3.7f));
        entityManager.persist(new Tootja(4, "5982343", "chiPhone Industries Ltd", leedu, 0.5f));

        entityManager.persist(gediminas);
        entityManager.persist(new Tarnija(5, "39292492", "OÜ Patsaanid", eesti, new BigDecimal(60)));
        entityManager.persist(new Tarnija(6, "983839498", "OÜ Riskikuller", eesti, new BigDecimal(1)));

        entityManager.persist(emaplaadid);
        entityManager.persist(new KaubaKategooria(3, "Mälud"));
        entityManager.persist(new KaubaKategooria(4, "Toiteplokid"));

        entityManager.persist(aktiivne);
        entityManager.persist(new KaubaStaatus(5, "mitteaktiivne"));

        entityManager.persist(kaup);

        entityManager.getTransaction().commit();

        entityManager.close();*/
    }

    @RequestMapping("/api/kaubad")
    public List<Kaup> kaubad() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.createQuery("SELECT a FROM Kaup AS a").getResultList();
    }

    @RequestMapping("/api/kaubad/{kood}")
    public Kaup kaup(@PathVariable String kood) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.find(Kaup.class, Long.parseLong(kood));
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

    @RequestMapping("/api/kategooriad")
    public List<KaubaKategooria> kategooriad() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.createQuery("SELECT a FROM KaubaKategooria AS a").getResultList();
    }

    @RequestMapping(value = "/api/kaubad", method = RequestMethod.POST)
    public ResponseEntity<Kaup> lisaKaup(@RequestBody Kaup kaup) {
        System.out.println(kaup);


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

        kaup.setKaubaKategooria(null);
        kaup.setKaubaStaatus(null);
        kaup.setTarnija(null);
        kaup.setTootaja(null);
        kaup.setTootja(null);

        entityManager.getTransaction().begin();
        entityManager.remove(kaup);
        entityManager.getTransaction().commit();
        entityManager.close();

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
