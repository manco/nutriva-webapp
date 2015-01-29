package pl.nutrivia.domain;

import com.google.common.annotations.VisibleForTesting;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

@Table
@Entity
public class Product extends AbstractEntity implements HasCalories {

    //TODO cena lub ceny
    private Integer ig;
    @AttributeOverrides(@AttributeOverride(name = "mass.ug", column = @Column(name = "protein_ug")))
    private Protein protein;
    @AttributeOverrides(@AttributeOverride(name = "mass.ug", column = @Column(name = "fat_ug")))
    private Fat fat;
    @AttributeOverrides(@AttributeOverride(name = "mass.ug", column = @Column(name = "carbo_ug")))
    private Carbo carbo;
    @AttributeOverrides(@AttributeOverride(name = "ug", column = @Column(name = "cholesterol_ug")))
    private Mass cholesterol;
    @AttributeOverrides(@AttributeOverride(name = "ug", column = @Column(name = "fiber_ug")))
    private Mass fiber;

    @ElementCollection
    private Map<Vitamin, Mass> vitamines = new EnumMap<>(Vitamin.class);

    @ElementCollection
    private Map<Mineral, Mass> minerals = new EnumMap<>(Mineral.class);

    private Product() {}

    @VisibleForTesting public Product(Protein protein, Fat fat, Carbo carbo, Mass cholesterol, Mass fiber) {
        this.protein = protein;
        this.fat = fat;
        this.carbo = carbo;
        this.cholesterol = cholesterol;
        this.fiber = fiber;
    }


    @Override
    public BigDecimal getCalories() {
        //TODO czy uwzględniać fiber?
        return Stream.of(fat, protein, carbo).map(Nutrition::getCalories).reduce(BigDecimal.ZERO, BigDecimal::add);
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

    public Optional<Integer> getIg() {
        return Optional.ofNullable(ig);
    }

    public Optional<Mass> getCholesterol() {
        return Optional.ofNullable(cholesterol);
    }

    public Optional<Mass> getFiber() {
        return Optional.ofNullable(fiber);
    }

    @VisibleForTesting Map<Vitamin, Mass> getVitamines() {
        return vitamines;
    }

    @VisibleForTesting Map<Mineral, Mass> getMinerals() {
        return minerals;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private final Product entity = new Product();

        public Builder withVitamin(Vitamin vitamin, Mass mass) {
            entity.vitamines.put(vitamin, mass);
            return this;
        }

        public Builder withMineral(Mineral mineral, Mass mass) {
            entity.minerals.put(mineral, mass);
            return this;
        }

        public Builder withCholesterol(Mass value) {
            entity.cholesterol = value;
            return this;
        }

        public Product build(Protein protein, Fat fat, Carbo carbo) {
            entity.protein = protein;
            entity.fat = fat;
            entity.carbo = carbo;
            return entity;
        }
    }
}
