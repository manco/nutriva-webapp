package pl.nutrivia.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Carbo extends Nutrition {

    public Carbo() {
    }

    public Carbo(Mass mass) {
        super(mass);
    }

    @Override
    protected int caloriesFactor() {
        return 4;
    }

    //Węgle + sacharoza / ...
}
