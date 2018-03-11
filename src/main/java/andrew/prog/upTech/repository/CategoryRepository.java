package andrew.prog.upTech.repository;

import andrew.prog.upTech.model.Category;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category findByName(String name);

    List<Category> findByNameIsContainingAndDescriptionIsContaining(String name, String description);
}
