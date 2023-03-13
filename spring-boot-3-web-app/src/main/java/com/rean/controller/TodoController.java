package com.rean.controller;

import com.rean.model.Todo;
import com.rean.model.TodoBuilder;
import com.rean.repository.CommonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api/todos")
public class TodoController {

    private final CommonRepository<Todo> commonRepository;


    public TodoController(CommonRepository<Todo> commonRepository) {
        this.commonRepository = commonRepository;
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<?> createOrUpdate(@RequestBody Todo todo) {

        Todo todoInstance = commonRepository.save(todo);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{/id").buildAndExpand(todoInstance.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Todo> updateCompleted(@PathVariable Long id) {
        Todo todoData = commonRepository.findById(id);
        todoData.setCompleted(true);
        commonRepository.save(todoData);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{/id").buildAndExpand(todoData.getId()).toUri();
        return ResponseEntity.ok().header("Location", location.toString()).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Todo> deleteById(@PathVariable Long id) {
        commonRepository.delete(TodoBuilder.create().withId(id).build());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping()
    public ResponseEntity<Todo> delete(@RequestBody Todo todo) {
        commonRepository.delete(todo);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Todo> getById(@PathVariable Long id) {
        return ResponseEntity.ok(commonRepository.findById(id));
    }

    @GetMapping()
    public ResponseEntity<Iterable<Todo>> getAll() {
        return ResponseEntity.ok(commonRepository.findAll());
    }

}
