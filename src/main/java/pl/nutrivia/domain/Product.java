package pl.nutrivia.domain;

import com.google.common.annotations.VisibleForTesting;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public final class Product implements Serializable, HasCalories {

    //TODO cena lub ceny
    private String name;
    private Integer ig;
    private Protein protein;
    private Fat fat;
    private Carbo carbo;
    private Mass cholesterol;
    private Mass fiber;

    private final Map<Vitamin, Mass> vitamines = new EnumMap<>(Vitamin.class);
    private final Map<Mineral, Mass> minerals = new EnumMap<>(Mineral.class);

    private Product() {}

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

    public String getName() {
        return name;
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

        public Product build(String name, Protein protein, Fat fat, Carbo carbo) {
            entity.name = name;
            entity.protein = protein;
            entity.fat = fat;
            entity.carbo = carbo;
            return entity;
        }
    }
}
