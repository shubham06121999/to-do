package com.spartan.todo.controller;

import com.spartan.todo.model.api.Orginization;
import com.spartan.todo.model.db.ORGINIZATION;
import com.spartan.todo.services.OrginizationServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1")
@Slf4j
public class OrginizationController {
    @Autowired
    private  final OrginizationServices orginizationServices;

    public OrginizationController(OrginizationServices orginizationServices) {
        this.orginizationServices = orginizationServices;
    }

    @PostMapping(path = "/orginization")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Orginization createOrginization(
             @RequestBody(required = true) Orginization body) {
        return orginizationServices.createOrginization(body);
    }

    @GetMapping("/orginization/{Id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Orginization getOrginization(
            @PathVariable(name = "Id" ,required = true) String Id){
        return orginizationServices.retiveById(Id);
    }
    @DeleteMapping("/orginization/{Id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String DeleteOrginization(
            @PathVariable(name = "Id" ,required = true) String Id){
        return orginizationServices.DeleteOrginization(Id);
    }
}
