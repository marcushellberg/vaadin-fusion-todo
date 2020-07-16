package com.example.application.backend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Todo {

  @Id
  @GeneratedValue
  private Long id;

  @NotEmpty(message = "Task cannot be empty")
  private String task;

  public Todo() {
  }

  public Todo(String task) {
    this.setTask(task);
  }

  public Long getId() {
    return id;
  }

  public String getTask() {
    return task;
  }

  public void setTask(String task) {
    this.task = task;
  }
}