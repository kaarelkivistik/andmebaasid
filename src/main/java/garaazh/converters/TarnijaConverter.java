package garaazh.converters;

import garaazh.models.Tarnija;
import org.springframework.core.convert.converter.Converter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

public class TarnijaConverter implements Converter<String,Tarnija> {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    public TarnijaConverter() {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
    }

    @Override
    public Tarnija convert(String source) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return (Tarnija) entityManager.createQuery("SELECT a FROM Tarnija AS a WHERE a.registriKood = ?1")
                .setParameter(1, Long.parseLong(source))
                .getResultList().get(0);
    }
}