package pl.nutrivia.domain;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table
public class ProductInMeal extends AbstractEntity {

    @ManyToOne private Product product;
    private Mass mass;


}
