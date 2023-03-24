package com.rean.service.impl;

import com.rean.excpetion.ResourceNotFoundException;
import com.rean.model.Todo;
import com.rean.repository.TodoRepository;
import com.rean.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    public Todo saveOrUpdate(Todo todo) {
        Optional<Todo> todoInstance = todoRepository.findById(todo.getId());
        if(todoInstance.isPresent()) {
            todoInstance.get().setId(todo.getId());
            todoInstance.get().setTitle(todo.getTitle());
            todoInstance.get().setDescription(todo.getDescription());
            todoInstance.get().setCompleted(todo.isCompleted());
            return todoRepository.save(todoInstance.get());
        }
        return todoRepository.save(todo);
    }

    @Override
    public Todo update(Long id) {
        Optional<Todo> todoOptional = todoRepository.findById(id);
        if(todoOptional.isPresent()) {
            todoOptional.get().setCompleted(true);
            todoRepository.save(todoOptional.get());
        }
        log.warn("Todo ID {} not found.", id);
        throw new ResourceNotFoundException(String.format("Update Todo with ID %s not found", id));
    }

    @Override
    public void delete(Long id) {
        //todoRepository.deleteById(id);

        Optional<Todo> todoOptional = todoRepository.findById(id);
        todoOptional.ifPresent(todoRepository::delete);
    }

    @Override
    public Todo findById(Long id) {
        Optional<Todo> todoOptional = todoRepository.findById(id);
        if(todoOptional.isPresent()) {
            return todoOptional.get();
        }
        log.warn("Find Todo ID {} not found.", id);
        throw new ResourceNotFoundException(String.format("Todo ID %s not found", id));
    }

    @Override
    public Iterable<Todo> findAll() {
        return todoRepository.findAll();
    }
}
