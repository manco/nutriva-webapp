package pl.nutrivia.prevalence;

import org.prevayler.TransactionWithQuery;
import pl.nutrivia.domain.*;

import java.util.Date;

public class CreateProduct implements TransactionWithQuery<Products, Product> {

    private final String name;
    private final Mass protein;
    private final Mass fat;
    private final Mass carbo;

    public CreateProduct(String name, Mass protein, Mass fat, Mass carbo) {
        this.name = name;
        this.protein = protein;
        this.fat = fat;
        this.carbo = carbo;
    }

    @Override
    public Product executeAndQuery(Products prevalentSystem, Date executionTime) throws Exception {
        final Product newProduct = Product.builder().build(name, new Protein(protein), new Fat(fat), new Carbo(carbo));
        prevalentSystem.add(newProduct);
        return newProduct;
    }
}
