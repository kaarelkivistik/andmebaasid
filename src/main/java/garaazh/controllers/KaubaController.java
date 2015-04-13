package garaazh.controllers;

import garaazh.models.KaubaSeisund;
import garaazh.models.Kaup;
import garaazh.models.Organisatsioon;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import java.math.BigDecimal;

/**
 * Created by kaarel on 12/04/15.
 */
@Controller
public class KaubaController {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @PostConstruct
    protected void setUp() throws Exception {
        System.out.println("KaubaController.setUp");

        entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
    }

    @RequestMapping("/kaubad")
    public @ResponseBody String kaubad(Model model) {
        System.out.println("KaubaController.kaubad");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(new Kaup("ultrabook", new BigDecimal("9000.0"), new KaubaSeisund("inaktiivne"), new Organisatsioon(1337, "Samsung"), new Organisatsioon(1338, "Samyang")));
        entityManager.getTransaction().commit();
        entityManager.close();

        return "a-okay";
    }

}
