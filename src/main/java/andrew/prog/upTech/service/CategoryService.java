package andrew.prog.upTech.service;

import andrew.prog.upTech.model.Category;
import andrew.prog.upTech.service.dto.CategoryDTO;

public interface CategoryService {
    CategoryDTO getCategoryInformation(Long id);

    Category getCategoryByName(String category);

    CategoryDTO update(Long id, String name, String description);

    CategoryDTO delete(Long id);

    CategoryDTO create(String name, String description);
}
