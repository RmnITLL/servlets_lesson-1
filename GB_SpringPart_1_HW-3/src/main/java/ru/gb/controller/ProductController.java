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


    /**
     *
     *
    */


    @GetMapping("/show_form")
    public String showFormPage() {
        return "simple_form";
    }

    @GetMapping("/stud_add")
    public String addStud(@RequestParam Long id, @RequestParam String name) {
        Student student = new Student(id, name);
        studentRepository.add(student);
        return "redirect:/students";
    }

    @GetMapping("/resp")
    @ResponseBody
    public Student respMethod() {
        return new Student(1L, "Bob");
    }

    @PostMapping("/getStudent")
    @ResponseBody
    public Student getStudent(@RequestBody Student s) {
        s.setId(100L);
        return s;
    }

    @GetMapping("/students/{id}")
    public String showStudentPage(Model model, @PathVariable Long id) {
        Student student = studentRepository.fynfByID(id);
        model.addAttribute("student", student);
        return "student_info_page";
    }

    @GetMapping("/studetns")
    public String showStudentPage(Model model) {
        model.addAttribute("student", studentRepository.getStudents());
        return "student_page";
    }

    @GetMapping("/product/{id}/info")
    @ResponseBody
    public String showProductInfo(@PathVariable Long id) {
        return "Product #" + id;
    }

}
