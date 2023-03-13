package com.rean.service;

import com.rean.model.Todo;
import com.rean.repository.CommonRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class TodoService implements CommonRepository<Todo> {

    private final Map<Long, Todo> todoMap = new HashMap<>();


    @Override
    public Todo save(Todo model) {

        Todo todoInstance = todoMap.get(model.getId());
        if(todoInstance != null) {
            todoInstance.setId(model.getId());
            todoInstance.setTitle(model.getTitle());
            todoInstance.setDescription(model.getDescription());
            todoInstance.setCompleted(model.isCompleted());
            model = todoInstance;
        }
        todoMap.put(model.getId(), model);
        return todoMap.get(model.getId());
    }

    @Override
    public void delete(Todo model) {
        todoMap.remove(model.getId());
    }

    @Override
    public Todo findById(Long id) {
        return todoMap.get(id);
    }

    @Override
    public Iterable<Todo> findAll() {
        return todoMap.entrySet().stream().sorted()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

}
