package pl.nutrivia.domain;

public class ProductProvider {

    private ProductProvider() {
    }

    public static Product buildProduct() {
        return Product.builder()
                .withCholesterol(Mass.g(77))
                .withVitamin(Vitamin.B3, Mass.g(1))
                .withMineral(Mineral.Ca, Mass.g(3))
                .build("someNameWohooo", new Protein(Mass.g(12)), new Fat(Mass.g(3)), new Carbo(Mass.g(166)))
                ;
    }
}
