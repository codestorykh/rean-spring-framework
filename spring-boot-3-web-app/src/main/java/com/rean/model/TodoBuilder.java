package com.rean.model;

public class TodoBuilder {

    private final static TodoBuilder todoBuilderInstance = new TodoBuilder();

    private Long id = 0L;
    private String title = "";
    private String description = "";

    public TodoBuilder() {

    }

    public static TodoBuilder create() {
        return todoBuilderInstance;
    }

    public TodoBuilder withId(Long id) {
        this.id = id;
        return todoBuilderInstance;
    }

    public TodoBuilder withTitle(String title) {
        this.title = title;
        return todoBuilderInstance;
    }

    public Todo build() {
        Todo todo = new Todo(this.id, this.title, this.description);
        if(null != id && id > 0L) {
            todo.setId(id);
        }
        return todo;
    }
}
