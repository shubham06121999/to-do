package com.spartan.todo.model.enums;
public enum ActionType {

    CREATE("CREATE"),
    UPDATE("UPDATE"),
    DELETE("DELETE"),
    UPDATE_TRANSACTION("UPDATE_TRANSACTION");

    private final String value;

    ActionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
