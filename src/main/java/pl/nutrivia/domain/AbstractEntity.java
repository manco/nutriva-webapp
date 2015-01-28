package pl.nutrivia.domain;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    public static final String D_ID = "id";
    public static final String C_ID = "id";

    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }
}
