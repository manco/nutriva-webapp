package pl.nutrivia.config;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        ApplicationConfig.class,
        EmbeddedDataSourceConfig.class,
       JpaConfig.class,
})
@Transactional
@TestExecutionListeners(listeners = {TransactionalTestExecutionListener.class, DependencyInjectionTestExecutionListener.class})
public abstract class DbTestWithRollback {

    //TODO włączyć debugowanie zapytań
    @PersistenceContext private EntityManager entityManager;

    public final EntityManager getEntityManager() {
        return entityManager;
    }
}
