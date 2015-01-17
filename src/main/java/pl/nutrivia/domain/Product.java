package pl.nutrivia.domain;

import com.google.common.annotations.VisibleForTesting;

import javax.persistence.*;
import java.util.Optional;
import java.util.stream.Stream;

@Table
@Entity
public class Product extends AbstractEntity implements HasCalories {

    //cena lub ceny
    private Integer ig;
    @AttributeOverrides(@AttributeOverride(name = "ug", column = @Column(name = "protein_ug")))
    private Protein protein;
    @AttributeOverrides(@AttributeOverride(name = "ug", column = @Column(name = "fat_ug")))
    private Fat fat;
    @AttributeOverrides(@AttributeOverride(name = "ug", column = @Column(name = "carbo_ug")))
    private Carbo carbo;
    @AttributeOverrides(@AttributeOverride(name = "ug", column = @Column(name = "cholesterol_ug")))
    private Mass cholesterol;
    @AttributeOverrides(@AttributeOverride(name = "ug", column = @Column(name = "fiber_ug")))
    private Mass fiber;
    //minerals from parser + pomyśleć o jednostkach
    //vitamines from parser

    private Product() {}

    @VisibleForTesting public Product(Integer ig, Protein protein, Fat fat, Carbo carbo) {
        this.ig = ig;
        this.protein = protein;
        this.fat = fat;
        this.carbo = carbo;
    }

    @Override
    public double getCalories() {
        //TODO czy uwzględniać fiber?
        return Stream.of(fat, protein, carbo).mapToDouble(Nutrition::getCalories).sum();
    }

    public Optional<Integer> getIg() {
        return Optional.ofNullable(ig);
    }

    public Protein getProtein() {
        return protein;
    }

    public Fat getFat() {
        return fat;
    }

    public Carbo getCarbo() {
        return carbo;
    }

    public Mass getCholesterol() {
        return cholesterol;
    }

    public Mass getFiber() {
        return fiber;
    }
}
