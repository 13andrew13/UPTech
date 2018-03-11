package andrew.prog.upTech.service.dto;

import java.io.Serializable;

public class CategoryDTO implements Serializable {
    public String name;
    public String description;
    public Integer count;

    public CategoryDTO(String name, String description, Integer count) {
        this.name = name;
        this.description = description;
        this.count = count;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
