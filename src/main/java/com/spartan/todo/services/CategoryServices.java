package com.spartan.todo.services;

import com.spartan.todo.dao.CategoryDao;
import com.spartan.todo.model.api.Category;
import com.spartan.todo.model.api.Orginization;
import com.spartan.todo.model.db.CATEGORY;
import com.spartan.todo.model.db.ORGINIZATION;
import com.spartan.todo.model.enums.ActionType;
import com.spartan.todo.respository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class CategoryServices {
    public final CategoryDao categoryDao;
    public final CategoryRepository categoryRepository;

    public CategoryServices(CategoryDao categoryDao,CategoryRepository categoryRepository){
        this.categoryDao=categoryDao;
        this.categoryRepository=categoryRepository;

    }

    public Category createOrginization(Category data) {
        CATEGORY category = createAndPublish(data, ActionType.CREATE.getValue());
        Category  response =  setresponse(category);
        return response;
    }

    private Category setresponse(CATEGORY data) {
        Category response = new Category();
        response.setId(data.getId());
        response.setName(data.getName());
        response.setUserId(data.getUserId());
        response.setOrganizationId(data.getOrganizationId());
        return response;
    }

    private CATEGORY createAndPublish(Category data, String actionType) {
        CATEGORY  response =  categoryDao.createCategory(data,actionType, new Date(), UUID.randomUUID().toString());
        return  response;
    }
}
