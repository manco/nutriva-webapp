package pl.nutrivia.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Fat extends Nutrition {

    public Fat() {
    }

    public Fat(Mass mass) {
        super(mass);
    }

    @Override
    protected int caloriesFactor() {
        return 9;
    }

    //skład kwasów tłuszczowych
}
