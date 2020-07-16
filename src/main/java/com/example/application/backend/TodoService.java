package com.example.application.backend;

import java.util.List;

import com.vaadin.flow.server.connect.Endpoint;
import com.vaadin.flow.server.connect.auth.AnonymousAllowed;

@Endpoint
@AnonymousAllowed
public class TodoService {
  private TodoRepository repo;

  TodoService(TodoRepository repo) {
    this.repo = repo;
  }

  public List<Todo> getTodos() {
    return repo.findAll();
  }

  public Todo saveTodo(Todo todo) {
    return repo.save(todo);
  }

  public void deleteTodo(Long id) {
    repo.deleteById(id);
  }
}
