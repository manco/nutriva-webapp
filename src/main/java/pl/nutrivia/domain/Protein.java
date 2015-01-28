package pl.nutrivia.domain;

import javax.persistence.Embeddable;

@Embeddable
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
