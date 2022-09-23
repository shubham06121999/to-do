package com.spartan.todo.respository;

import com.spartan.todo.model.db.CATEGORY;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CATEGORY, String>{

}
