package pl.nutrivia.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Mass implements Serializable {

    private static final BigDecimal HUNDRED = BigDecimal.valueOf(100);

    private BigInteger ug = BigInteger.ZERO;

    public Mass() {}
    public Mass(BigInteger ug) {
        this.ug = ug;
    }

    public BigInteger ug() {
        return ug;
    }

    public BigDecimal mg() {
        return new BigDecimal(ug).divide(HUNDRED, RoundingMode.HALF_DOWN);
    }

    public BigDecimal g() {
        return mg().divide(HUNDRED, RoundingMode.HALF_DOWN);
    }

    public static Mass g(int amount) {
        return new Mass(g2ug(BigDecimal.valueOf(amount)));
    }

    private static BigInteger g2ug(BigDecimal amount) {
        return HUNDRED.multiply(HUNDRED).multiply(amount).toBigInteger();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Mass) {
            return new EqualsBuilder().append(ug, ((Mass) obj).ug()).isEquals();
        }
        return false;

    }

    @Override
    public int hashCode() {
        return ug != null ? ug.hashCode() : 0;
    }
}
