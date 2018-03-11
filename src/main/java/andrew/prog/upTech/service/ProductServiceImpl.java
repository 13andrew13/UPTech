package andrew.prog.upTech.service;

import andrew.prog.upTech.model.Category;
import andrew.prog.upTech.model.Product;
import andrew.prog.upTech.repository.ProductRepository;
import andrew.prog.upTech.service.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository repository;
    @Autowired
    CategoryService categoryService;

    public ProductDTO getProductById(Long id) {
        Product pr = repository.findOne(id);
        return new ProductDTO(pr);
    }

    public int getCountOfProductsByCategory(Category cat) {
        return repository.countAllByCategory(cat);
    }

    public ProductDTO createProduct(String name, String description, Float price, String category) {
        return new ProductDTO(repository.save(new Product(name,description,price,categoryService.getCategoryByName(category))));
    }

    public ProductDTO deleteProduct(Long id) {
        Product pr = repository.findOne(id);
        repository.delete(pr);
        return new ProductDTO(pr);
    }

    public ProductDTO updateProduct(Long id, String name, String description, Float price) {
        Product pr = repository.findOne(id);
        if (!(name.equals("") || name.equals(null))) {
            pr.setName(name);
        }
        if (!(description.equals("") || description.equals(null))) {
            pr.setDescription(description);
        }
        if (!(price.equals(0) || price.equals(null))) {
            pr.setPrice(price);
        }
        return new ProductDTO(repository.save(pr));
    }


}
