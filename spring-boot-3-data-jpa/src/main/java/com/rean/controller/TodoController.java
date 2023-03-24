package com.rean.controller;

import com.rean.model.Todo;
import com.rean.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api/todos")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<?> createOrUpdate(@RequestBody Todo todo) {

        Todo todoInstance = todoService.saveOrUpdate(todo);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(todoInstance.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Todo> updateCompleted(@PathVariable Long id) {
        Todo todo = todoService.update(id);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(todo.getId()).toUri();
        return ResponseEntity.ok().header("Location", location.toString()).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Todo> deleteById(@PathVariable Long id) {
        todoService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Todo> getById(@PathVariable Long id) {
        return ResponseEntity.ok(todoService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<Iterable<Todo>> getAll() {
        return ResponseEntity.ok(todoService.findAll());
    }

}
