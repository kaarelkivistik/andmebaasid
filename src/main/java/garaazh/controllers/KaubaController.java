package garaazh.controllers;

import garaazh.models.Kaup;
import garaazh.models.Organisatsioon;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.util.Collection;

/**
 * Created by kaarel on 12/04/15.
 */
@Controller
public class KaubaController {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @PostConstruct
    protected void setUp() throws Exception {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(new Organisatsioon(1337, "Samyang"));
        entityManager.persist(new Organisatsioon(1338, "Samsung"));
        entityManager.persist(new Organisatsioon(1339, "chiPhone Industries Ltd"));
        entityManager.persist(new Organisatsioon(1340, "Gediminas Transports UAB"));
        entityManager.persist(new Organisatsioon(1341, "OÜ Huiarid"));
        entityManager.getTransaction().commit();

        System.out.println("Transaction: " + entityManager.getTransaction());

        entityManager.close();
    }

    @RequestMapping(value = "/kaubad/lisa", method = RequestMethod.GET)
    public String kaupLisa(Model model) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Collection<Organisatsioon> organisatsioonid = entityManager.createQuery("SELECT k FROM Organisatsioon AS k").getResultList();

        model.addAttribute("kaup", new Kaup());
        model.addAttribute("organisatsioonid", organisatsioonid);

        return "lisa";
    }

    @RequestMapping(value = "/kaubad/lisa", method = RequestMethod.POST)
    public String kaupLisa(Kaup kaup) {
        System.out.println("Kaup: " + kaup);

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(kaup);
        entityManager.getTransaction().commit();
        entityManager.close();

        return "redirect:/kaubad/lisa";
    }

    @RequestMapping("/kaubad")
    public String kaubad(Model model) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Collection<Kaup> kaubad = entityManager.createQuery("SELECT k FROM Kaup AS k").getResultList();

        model.addAttribute("kaubad", kaubad);

        return "kaubad";
    }

}
