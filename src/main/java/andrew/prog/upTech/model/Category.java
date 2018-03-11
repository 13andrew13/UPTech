package andrew.prog.upTech.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "CATEGORIES")
public class Category implements Serializable {
    @Id
    @SequenceGenerator(name = "CATEGORY_GEN")
    @GeneratedValue(generator = "CATEGORY_GEN", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products;

    public Category() {
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
