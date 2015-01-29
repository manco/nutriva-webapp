package pl.nutrivia.domain;

public class Fat extends Nutrition {

    public Fat(Mass mass) {
        super(mass);
    }

    @Override
    protected int caloriesFactor() {
        return 9;
    }

    //skład kwasów tłuszczowych
}
