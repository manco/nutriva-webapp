package pl.nutrivia.domain;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Table
public class Meal extends AbstractEntity {

    @OneToMany private Set<ProductInMeal> products;
}
