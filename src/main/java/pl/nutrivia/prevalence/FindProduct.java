package pl.nutrivia.prevalence;

import org.prevayler.Query;
import org.prevayler.TransactionWithQuery;
import pl.nutrivia.domain.Carbo;
import pl.nutrivia.domain.Fat;
import pl.nutrivia.domain.Product;
import pl.nutrivia.domain.Protein;

import java.util.Date;

public class FindProduct implements Query<Products, Product> {

    private final String name;

    public FindProduct(String name) {
        this.name = name;
    }

    @Override
    public Product query(Products prevalentSystem, Date executionTime) throws Exception {
        return prevalentSystem.get(name).orElse(null);
    }

}
