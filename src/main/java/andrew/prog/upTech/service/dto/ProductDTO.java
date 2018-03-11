package andrew.prog.upTech.service.dto;

import andrew.prog.upTech.model.Product;

import java.io.Serializable;

public class ProductDTO implements Serializable{
    String name;
    String description;
    Float price;

    public ProductDTO(Product product) {
        name = product.getName();
        description = product.getDescription();
        price = product.getPrice();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
