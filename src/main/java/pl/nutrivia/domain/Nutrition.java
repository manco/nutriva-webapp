package pl.nutrivia.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@MappedSuperclass
public abstract class Nutrition implements HasMass, HasCalories, Serializable {

    private Mass mass;

    protected Nutrition(){}
    protected Nutrition(Mass mass) {
        this.mass = mass;
    }

    @Override
    public Mass getMass() {
        return mass;
    }

    @Override
    public BigDecimal getCalories() {
        return mass.g().multiply(BigDecimal.valueOf(caloriesFactor()));
    }

    protected abstract int caloriesFactor();

}
