package pl.nutrivia.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Mass implements Serializable {

    private long ug;

    private Mass() {}
    public Mass(long ug) {
        this.ug = ug;
    }

    public long ug() {
        return ug;
    }

    public double mg() {
        return ug /100.0;
    }

    public double g() {
        return mg()/100.0;
    }

    public static Mass g(double amount) {
        return new Mass(g2ug(amount));
    }

    private static long g2ug(double amount) {
        return (long) (100 * 100 * amount);
    }

}
