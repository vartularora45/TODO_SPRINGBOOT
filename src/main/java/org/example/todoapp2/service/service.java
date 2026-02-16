package org.example.todoapp2.service;

import lombok.RequiredArgsConstructor;
import org.example.todoapp2.model.model;
import org.example.todoapp2.repository.repository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class service {

    private final repository todoRepository;

    public model createTodo(model todo) {
        return todoRepository.save(todo);
    }

    public List<model> getAllTodos() {
        return todoRepository.findAll();
    }

    public model updateTodo(String id, model updatedTodo) {
        model existingTodo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found with id: " + id));

        existingTodo.setTitle(updatedTodo.getTitle());
        existingTodo.setCompleted(updatedTodo.isCompleted());

        return todoRepository.save(existingTodo);
    }

    public void deleteTodo(String id) {
        todoRepository.deleteById(id);
    }
}
