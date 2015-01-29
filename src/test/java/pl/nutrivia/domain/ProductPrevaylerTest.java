package pl.nutrivia.domain;

import org.junit.Test;
import org.prevayler.Prevayler;
import org.prevayler.PrevaylerFactory;
import pl.nutrivia.prevalence.CreateProduct;
import pl.nutrivia.prevalence.FindProduct;
import pl.nutrivia.prevalence.Products;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductPrevaylerTest {

    public static final String SOME_NAME = "someName";

    @Test
    public void shouldSaveAndLoad() throws Exception {

        //given
        final Prevayler<Products> prevayler = PrevaylerFactory.createTransientPrevayler(new Products());
        createAndSaveProduct(prevayler);

        //when
        final Product loadedProduct = prevayler.execute(new FindProduct("someName"));

        //then
        assertThat(loadedProduct.getCalories()).isEqualTo(BigDecimal.valueOf(21 * 4 + 5 * 9 + 83 * 4));
    }

    private static Product createAndSaveProduct(final Prevayler<Products> prevayler) throws Exception {
        return prevayler.execute(new CreateProduct(SOME_NAME, Mass.g(21), Mass.g(5), Mass.g(83)));
    }

}
