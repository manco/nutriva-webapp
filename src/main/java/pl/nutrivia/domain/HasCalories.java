package pl.nutrivia.domain;

import java.math.BigDecimal;

@FunctionalInterface
public interface HasCalories {
    BigDecimal getCalories();
}
