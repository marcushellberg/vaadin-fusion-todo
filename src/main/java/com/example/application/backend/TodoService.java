package com.example.application.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;

import com.vaadin.flow.server.connect.Endpoint;
import com.vaadin.flow.server.connect.auth.AnonymousAllowed;

import org.springframework.stereotype.Service;

@Service
@Endpoint
@AnonymousAllowed
public class TodoService {
  private ArrayList<Todo> todos = new ArrayList<>();

  @PostConstruct
  void init() {
    todos.add(new Todo("Build todo app"));
  }

  public List<Todo> getTodos() {
    return todos;
  }

  public Todo addTodo(String task) {
    Todo todo = new Todo(task);
    todos.add(todo);
    return todo;
  }

  public void deleteTodo(UUID id) {
    todos.removeIf(t -> t.getId().equals(id));
  }
}
