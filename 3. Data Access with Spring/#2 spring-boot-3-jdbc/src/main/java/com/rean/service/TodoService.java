package com.rean.service;

import com.rean.model.Todo;
import com.rean.repository.CommonRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@Service
public class TodoService implements CommonRepository<Todo> {


    private static final String SQL_INSERT = "insert into tbl_todo (id, title, description, created, modified, completed) values (:id,:title,:description,:created,:modified,:completed)";
    private static final String SQL_QUERY_FIND_ALL = "select id, title, description, created, modified, completed from tbl_todo";
    private static final String SQL_QUERY_FIND_BY_ID = SQL_QUERY_FIND_ALL +" where id = :id";
    private static final String SQL_UPDATE = "update tbl_todo set title = :title, description = :description, modified = :modified, completed = :completed where id = :id";
    private static final String SQL_DELETE = "delete from tbl_todo where id = :id ";
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public TodoService(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Todo> todoRowMapper = (ResultSet rs, int rowNum) -> {
        Todo todo = new Todo();
        todo.setId(rs.getLong("id"));
        todo.setTitle(rs.getString("title"));
        todo.setDescription(rs.getString("description"));
        todo.setCreated(rs.getTimestamp("created").toLocalDateTime());
        todo.setModified(rs.getTimestamp("modified").toLocalDateTime());
        todo.setCompleted(rs.getBoolean("completed"));
        return todo;
    };

    @Override
    public Todo save(Todo model) {
        Todo todoInstance = this.findById(model.getId());
        if(todoInstance != null) {
            todoInstance.setId(model.getId());
            todoInstance.setTitle(model.getTitle());
            todoInstance.setDescription(model.getDescription());
            todoInstance.setCompleted(model.isCompleted());
            return this.saveOrUpdate(todoInstance, SQL_UPDATE);
        }
        return this.saveOrUpdate(model, SQL_INSERT);
    }

    @Override
    public void delete(Todo model) {
        Map<String, Long> namedParameters = Collections.singletonMap("id", model.getId());
        this.jdbcTemplate.update(SQL_DELETE, namedParameters);
    }

    @Override
    public Todo findById(Long id) {
        try {
            Map<String, Long> namedParameters = Collections.singletonMap("id", id);
            return this.jdbcTemplate.queryForObject(SQL_QUERY_FIND_BY_ID, namedParameters, todoRowMapper);
        }catch (EmptyResultDataAccessException ex) {
            System.out.println(ex.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public Iterable<Todo> findAll() {
        return this.jdbcTemplate.query(SQL_QUERY_FIND_ALL, todoRowMapper);
    }

    private Todo saveOrUpdate(Todo todo, String sql) {
        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("id", todo.getId());
        namedParameters.put("title", todo.getTitle());
        namedParameters.put("description", todo.getDescription());
        namedParameters.put("created", todo.getCreated());
        namedParameters.put("modified", todo.getModified());
        namedParameters.put("completed", todo.isCompleted());
        this.jdbcTemplate.update(sql, namedParameters);
        return this.findById(todo.getId());
    }

}
