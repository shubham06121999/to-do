package com.spartan.todo.model.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Data
public class Orginization {
    private String id;
    private String name;
    private String userId;
//    private ArrayList<Category> categories;
}
