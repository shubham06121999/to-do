package com.spartan.todo.respository;

import com.spartan.todo.model.db.ORGINIZATION;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrginizationRepository extends JpaRepository<ORGINIZATION,String> {

    Optional<ORGINIZATION> findById(String id);
}
