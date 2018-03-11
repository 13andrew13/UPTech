package andrew.prog.upTech.repository;

import andrew.prog.upTech.model.Category;
import andrew.prog.upTech.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    int countAllByCategory(Category category);

}
