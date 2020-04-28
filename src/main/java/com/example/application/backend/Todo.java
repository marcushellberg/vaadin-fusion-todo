package com.example.application.backend;

import java.util.UUID;

public class Todo {
  private UUID id;
  private String task;

  public Todo(){}

  public Todo(String task) {
    this.setId(UUID.randomUUID());
    this.setTask(task);
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getTask() {
    return task;
  }

  public void setTask(String task) {
    this.task = task;
  }
}