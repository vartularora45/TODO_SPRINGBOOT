package org.example.todoapp2.controller;

import lombok.RequiredArgsConstructor;
import org.example.todoapp2.model.model;
import org.example.todoapp2.service.service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private final service todoService;
    @PostMapping("/create")
    public model createTodo(@RequestBody model todo) {
        return todoService.createTodo(todo);
    }


    @GetMapping("/")
    public List<model> getAllTodos() {
        return todoService.getAllTodos();
    }


    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable String id) {
        todoService.deleteTodo(id);
    }
}
