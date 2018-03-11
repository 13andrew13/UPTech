package andrew.prog.upTech.controller;

import andrew.prog.upTech.service.dto.CategoryDTO;
import andrew.prog.upTech.service.CategoryService;
import andrew.prog.upTech.service.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService service;

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable("id") Long id) {
        return new ResponseEntity<CategoryDTO>(service.getCategoryInformation(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CategoryDTO> update(@PathVariable Long id, @RequestParam String name, @RequestParam String description) {
        return new ResponseEntity<CategoryDTO>(service.update(id, name, description), HttpStatus.OK);
    }

    @RequestMapping("/delete/{id}")
    public ResponseEntity<CategoryDTO> delete(@PathVariable Long id) {
        return new ResponseEntity<CategoryDTO>(service.delete(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<CategoryDTO> createProduct(@RequestParam String name, @RequestParam String description) {
        return new ResponseEntity<CategoryDTO>(service.create(name, description), HttpStatus.OK);
    }
}
