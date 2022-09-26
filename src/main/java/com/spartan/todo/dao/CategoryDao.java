package com.spartan.todo.dao;

import com.spartan.todo.model.api.Category;
import com.spartan.todo.model.db.CATEGORY;
import com.spartan.todo.model.db.ORGINIZATION;
import com.spartan.todo.respository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
@Slf4j
public class CategoryDao {
    public final CategoryRepository categoryRepository;

    public CategoryDao(CategoryRepository categoryRepository){
        this.categoryRepository= categoryRepository;
    }

    public CATEGORY createCategory(Category data, String actionType, Date createdTime, String uuid) {
        CATEGORY result = saveCategory(data,actionType,createdTime,uuid);
        return result;
    }

    private CATEGORY saveCategory(Category data, String actionType, Date createdTime, String uuid) {
        CATEGORY category = new CATEGORY();
        category.setId(uuid);
        category.setName(data.getName());
        category.setUserId(data.getUserId());
        category.setOrganizationId(data.getOrganizationId());
        category.setAction(actionType);
        category.setCreated_dttm(createdTime);
        category.setUpdateddttm(createdTime);
        return categoryRepository.save(category);

    }
}
