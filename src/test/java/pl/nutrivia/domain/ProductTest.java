package pl.nutrivia.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import pl.nutrivia.config.ApplicationConfig;
import pl.nutrivia.config.DbTestWithRollback;
import pl.nutrivia.config.EmbeddedDataSourceConfig;
import pl.nutrivia.config.JpaConfig;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

import static org.fest.assertions.api.Assertions.assertThat;

public class ProductTest extends DbTestWithRollback {

    @Test
    public void shouldSaveAndLoad() {

        //given
        final EntityManager entityManager = getEntityManager();
        final Product testProduct = createAndSaveProduct(entityManager);
        final long id = testProduct.getId();

        //when
        final Product loadedProduct = entityManager.find(Product.class, id);

        //then
        assertThat(loadedProduct.getCholesterol().get()).isEqualTo(Mass.g(77));
        assertThat(loadedProduct.getProtein()).isNotNull();
        assertThat(loadedProduct.getCalories()).isEqualTo(BigDecimal.valueOf(12 * 4 + 3 * 9 + 166 * 4));
    }

    private static Product createAndSaveProduct(final EntityManager entityManager) {
        final Product product = new Product(new Protein(Mass.g(12)), new Fat(Mass.g(3)), new Carbo(Mass.g(166)), Mass.g(77), Mass.g(3));
        entityManager.persist(product);
        entityManager.flush();
        entityManager.clear();
        return product;
    }

}