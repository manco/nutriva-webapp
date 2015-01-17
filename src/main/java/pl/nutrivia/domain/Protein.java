package pl.nutrivia.domain;

public class Protein extends Nutrition {

    //Białko + zwierzęce/roślinne

    private Protein(){}

    public Protein(Mass mass) {
        super(mass);
    }

    @Override
    protected int caloriesFactor() {
        return 4;
    }
}
