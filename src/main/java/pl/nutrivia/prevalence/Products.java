package pl.nutrivia.prevalence;

import pl.nutrivia.domain.Product;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Products implements Serializable {

    private final Map<String, Product> products = new HashMap<>();

    public Optional<Product> get(String id) {
        return Optional.ofNullable(products.get(id));
    }

    public void add(Product product) {
        products.put(product.getName(), product);
    }

}
