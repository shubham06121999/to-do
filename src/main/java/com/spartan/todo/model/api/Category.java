package com.spartan.todo.model.api;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class Category {
    private String id;
    private String name;
    private ArrayList<Category> categories;

}
