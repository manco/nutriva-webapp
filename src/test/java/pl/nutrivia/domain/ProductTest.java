package pl.nutrivia.domain;

import org.fest.assertions.data.MapEntry;
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
        assertThat(loadedProduct.getVitamines()).contains(MapEntry.entry(Vitamin.B3, Mass.g(1)));

        assertThat(loadedProduct.getMinerals()).contains(MapEntry.entry(Mineral.Ca, Mass.g(3)));
        assertThat(loadedProduct.getCalories()).isEqualTo(BigDecimal.valueOf(12 * 4 + 3 * 9 + 166 * 4));
    }

    private static Product createAndSaveProduct(final EntityManager entityManager) {
        final Product product = Product.builder()
                .withCholesterol(Mass.g(77))
                .withVitamin(Vitamin.B3, Mass.g(1))
                .withMineral(Mineral.Ca, Mass.g(3))
                .build(new Protein(Mass.g(12)), new Fat(Mass.g(3)), new Carbo(Mass.g(166)))
                ;
        entityManager.persist(product);
        entityManager.flush();
        entityManager.clear();
        return product;
    }

}