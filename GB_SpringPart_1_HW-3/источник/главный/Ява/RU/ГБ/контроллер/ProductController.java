package ru.gb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.сategories.Product;
import ru.gb.сategories.ProductRepository;
import ru.gb.сategories.Student;
import ru.gb.сategories.StudentRepository;

@Controller
@RequestMapping("/product")
public class ProductController {

    private ProductRepository productRepository;

    private StudentRepository studentRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public String listPage(Model model) {
        model.addAttribute("product", productRepository.findAll());
        return "product";
    }

    @GetMapping("{/id}")
    public String editPage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("product", productRepository.findAll());
        return "product_form";
    }

    @PostMapping("/update")
    public String updatePage(Product product) {
        productRepository.update(product);
        return "redirect:/product";
    }

    @GetMapping("/new")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "product_form";
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable("id") Long id) {
        productRepository.delete(id);
        return "redirect:/user";
    }


}
