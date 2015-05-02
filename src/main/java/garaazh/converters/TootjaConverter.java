package garaazh.converters;

import garaazh.models.Tootja;
import org.springframework.core.convert.converter.Converter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

public class TootjaConverter implements Converter<String,Tootja> {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    public TootjaConverter() {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
    }

    @Override
    public Tootja convert(String source) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return (Tootja) entityManager.createQuery("SELECT a FROM Tootja AS a WHERE a.organisatsiooniKood = ?1")
                .setParameter(1, Long.parseLong(source))
                .getResultList().get(0);
    }
}