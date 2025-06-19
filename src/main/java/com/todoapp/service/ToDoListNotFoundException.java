package com.todoapp.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "List not found")
public class ToDoListNotFoundException extends RuntimeException {
    public ToDoListNotFoundException() {
    }

    public ToDoListNotFoundException(String message) {
        super(message);
    }
}

