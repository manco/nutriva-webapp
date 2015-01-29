package pl.nutrivia.domain;

public class Carbo extends Nutrition {

    public Carbo(Mass mass) {
        super(mass);
    }

    @Override
    protected int caloriesFactor() {
        return 4;
    }

    //Węgle + sacharoza / ...
}
