package andrew.prog.upTech.service;

import andrew.prog.upTech.model.Category;
import andrew.prog.upTech.repository.CategoryRepository;
import andrew.prog.upTech.service.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository repository;
    @Autowired
    private ProductService productService;

    public CategoryDTO getCategoryInformation(Long id) {
        Category cat = repository.findOne(id);
        CategoryDTO categoryDTO = new CategoryDTO(cat.getName(), cat.getDescription(), productService.getCountOfProductsByCategory(cat));
        return categoryDTO;
    }

    public Category getCategoryByName(String category) {
        return repository.findByName(category);
    }

    public CategoryDTO update(Long id, String name, String description) {
        Category ct = repository.findOne(id);
        if (!(name.equals("") || name.equals(null))) ;
        {
            ct.setName(name);
        }
        if (!(description.equals("") || description.equals(null))) {
            ct.setDescription(description);
        }
        return new CategoryDTO(ct.getName(), ct.getDescription(), productService.getCountOfProductsByCategory(ct));

    }

    public CategoryDTO delete(Long id) {
        Category ct = repository.findOne(id);
        CategoryDTO res = new CategoryDTO(ct.getName(), ct.getDescription(), productService.getCountOfProductsByCategory(ct));
        repository.delete(ct);
        return res;
    }

    public CategoryDTO create(String name, String description) {
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        Category res = repository.save(category);
        return new CategoryDTO(res.getName(), res.getDescription(), productService.getCountOfProductsByCategory(category));
    }
}
