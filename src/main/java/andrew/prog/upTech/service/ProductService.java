package andrew.prog.upTech.service;

import andrew.prog.upTech.model.Category;
import andrew.prog.upTech.service.dto.ProductDTO;

public interface ProductService {
    ProductDTO getProductById(Long id);

    int getCountOfProductsByCategory(Category cat);

    ProductDTO createProduct(String name, String description, Float price, String category);

    ProductDTO deleteProduct(Long id);


    ProductDTO updateProduct(Long id, String name, String description, Float price);
}
