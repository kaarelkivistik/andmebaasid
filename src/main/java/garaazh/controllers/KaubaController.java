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
import javax.persistence.*;
import java.math.BigDecimal;
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
        entityManager.close();
    }

    @RequestMapping("/kaup-lisa")
    public String kaupLisa(Model model) {
        return "kaubad";
    }

    @RequestMapping("/kaubad")
    public String kaubad(Model model) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT k FROM Kaup AS k");
        Collection<Kaup> kaubad = query.getResultList();

        model.addAttribute("kaubad", kaubad);

        return "kaubad";
    }

}
