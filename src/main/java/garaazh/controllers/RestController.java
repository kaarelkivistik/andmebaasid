package garaazh.controllers;

import garaazh.Entities;
import garaazh.models.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.util.List;

/**
 * Created by kaarel on 26/04/15.
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @PersistenceUnit
    EntityManagerFactory entityManagerFactory;

    @PostConstruct
    protected void setUp() throws Exception {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(Entities.TOOTAJA_LAGUNOV);
        entityManager.persist(Entities.RIIK_EESTI);
        entityManager.persist(Entities.RIIK_LEEDU);
        entityManager.persist(Entities.KAUBA_STAATUS_AKTIIVNE);
        entityManager.persist(Entities.KAUBA_STAATUS_MITTEAKTIIVNE);
        entityManager.persist(Entities.KAUBA_STAATUS_KUSTUTATUD);
        entityManager.persist(Entities.KAUBA_KATEGOORIA_ARVUTIKOMPONENDID);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        entityManager.persist(Entities.KAUBA_KATEGOORIA_EMAPLAADID);
        entityManager.persist(Entities.TOOTJA_SAMYANG);
        entityManager.persist(Entities.TOOTJA_SAMSUNG);
        entityManager.persist(Entities.TARNIJA_GEDIMINAS);
        entityManager.persist(Entities.TARNIJA_RISKIKULLER);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        entityManager.persist(Entities.KAUP_ABIT_EXTREME_EMAPLAAT);
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

        return entityManager.find(Kaup.class, kood);
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

    @RequestMapping("/api/staatused")
    public List<KaubaStaatus> staatused() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.createQuery("SELECT a FROM KaubaStaatus AS a").getResultList();
    }

    @RequestMapping(value = "/api/kaubad", method = RequestMethod.POST)
    public ResponseEntity<Kaup> lisaKaup(@RequestBody Kaup kaup) {
        System.out.println(kaup);


        kaup.setTootaja(Entities.TOOTAJA_LAGUNOV);

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

        Kaup kaup = entityManager.find(Kaup.class, kood);

        entityManager.getTransaction().begin();
        entityManager.remove(kaup);
        entityManager.getTransaction().commit();
        entityManager.close();

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
