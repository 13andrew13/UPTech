package andrew.prog.upTech.controller;

import andrew.prog.upTech.service.dto.ProductDTO;
import andrew.prog.upTech.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService service;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<ProductDTO> createProduct(@RequestParam String name, @RequestParam String description, @RequestParam Float price, @RequestParam String category) {
        return new ResponseEntity<ProductDTO>(service.createProduct(name, description, price, category), HttpStatus.OK);
    }

    @RequestMapping("/get/{id}")
    public ResponseEntity<ProductDTO> get(@PathVariable Long id) {
        return new ResponseEntity<ProductDTO>(service.getProductById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ProductDTO> delete(@PathVariable Long id) {
        return new ResponseEntity<ProductDTO>(service.deleteProduct(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestParam String name, @RequestParam String description, @RequestParam Float price) {
        return new ResponseEntity<ProductDTO>(service.updateProduct(id, name, description, price), HttpStatus.OK);
    }
}

