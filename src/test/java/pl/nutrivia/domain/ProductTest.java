package pl.nutrivia.domain;

import org.junit.Test;
import pl.nutrivia.config.DbTestWithRollback;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

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
        assertThat(loadedProduct.getVitamines()).contains(entry(Vitamin.B3, Mass.g(1)));

        assertThat(loadedProduct.getMinerals()).contains(entry(Mineral.Ca, Mass.g(3)));
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