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

import static org.fest.assertions.api.Assertions.assertThat;

public class ProductTest extends DbTestWithRollback {


    //TODO włączyć debugowanie zapytań
    @PersistenceContext private EntityManager entityManager;

    @Test
    public void shouldSaveAndLoad() {

        //given
        final Product testProduct = createAndSaveProduct();
        final long id = testProduct.getId();
        final double calories = testProduct.getCalories();

        //when
        final Product loadedProduct = entityManager.find(Product.class, id);

        //then
        assertThat(loadedProduct.getCalories()).isNotZero().isEqualTo(calories);
    }

    private Product createAndSaveProduct() {
        final Product product = new Product(77, new Protein(Mass.g(12)), new Fat(Mass.g(3)), new Carbo(Mass.g(166)));
        entityManager.persist(product);
        entityManager.flush();
        entityManager.clear();
        return product;
    }

}