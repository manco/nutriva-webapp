package pl.nutrivia.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
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
    public double getCalories() {
        return mass.g() * caloriesFactor();
    }

    protected abstract int caloriesFactor();

}
