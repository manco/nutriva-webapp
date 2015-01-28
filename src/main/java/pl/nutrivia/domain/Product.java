package pl.nutrivia.domain;

import com.google.common.annotations.VisibleForTesting;

import javax.persistence.*;
import java.math.BigDecimal;
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

//    @ElementCollection
//    @JoinTable(name="product_vitamines", joinColumns=@JoinColumn(name=AbstractEntity.C_ID))
//    @MapKeyColumn (name="vitamin")
//    @Column
//    private Map<Vitamin, Mass> vitamines;

//    @ManyToMany(cascade = CascadeType.ALL)
//    private Map<Mineral, Mass> minerals;

    private Product() {}
//
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
}
