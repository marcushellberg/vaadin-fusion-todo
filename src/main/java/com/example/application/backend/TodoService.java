package com.example.application.backend;

import java.util.List;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.fusion.Endpoint;
import com.vaadin.fusion.Nonnull;


@Endpoint
@AnonymousAllowed
public class TodoService {
  private TodoRepository repo;

  TodoService(TodoRepository repo) {
    this.repo = repo;
  }

  public @Nonnull List<@Nonnull Todo> getTodos() {
    return repo.findAll();
  }

  public Todo saveTodo(Todo todo) {
    return repo.save(todo);
  }

  public void deleteTodo(Long id) {
    repo.deleteById(id);
  }
}
