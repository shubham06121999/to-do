package com.spartan.todo.controller;


import com.spartan.todo.model.api.Category;
import com.spartan.todo.services.CategoryServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1")
@Slf4j
public class CategoryController {
    @Autowired
    private  final CategoryServices categoryServices;

    public CategoryController(CategoryServices categoryServices) {
        this.categoryServices = categoryServices;
    }

    @PostMapping(path = "/category")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Category createcategory(
            @RequestBody(required = true) Category body) {
        return categoryServices.createOrginization(body);
    }
}
