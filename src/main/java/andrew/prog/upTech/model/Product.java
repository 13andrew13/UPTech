package andrew.prog.upTech.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.io.Serializable;

@JsonSerialize
@Entity
@Table(name = "products")
public class Product implements Serializable {
    @Id
    @SequenceGenerator(name = "PRODUCT_GEN")
    @GeneratedValue(generator = "PRODUCT_GEN", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private Float price;
    @ManyToOne
    private Category category;

    public Product() {
    }

    public Product(String name, String description, Float price, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Float getPrice() {
        return price;
    }
}
