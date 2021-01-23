import {
  LitElement,
  html,
  customElement,
  css,
  internalProperty,
} from "lit-element";
import "@vaadin/vaadin-text-field";
import "@vaadin/vaadin-button";
import { Binder, field } from "@vaadin/flow-frontend/form";
import * as todoService from "../generated/TodoService";
import Todo from "../generated/com/example/application/backend/Todo";
import TodoModel from "../generated/com/example/application/backend/TodoModel";

@customElement("todo-view")
export class TodoView extends LitElement {
  @internalProperty()
  private todos: Todo[] = [];
  private binder = new Binder(this, TodoModel);

  static styles = css`
    :host {
      margin: var(--lumo-space-m);
      display: block;
    }

    .form {
      display: inline-grid;
      gap: var(--lumo-space-m);
      grid-template-columns: 3fr 1fr;
      align-items: baseline;
    }
  `;

  protected render() {
    return html`
      <h1>Todo</h1>

      <div class="form">
        <vaadin-text-field
          label="Task"
          ...=${field(this.binder.model.task)}
        ></vaadin-text-field>
        <vaadin-button @click=${this.add}>Add</vaadin-button>
      </div>

      <ul>
        ${this.todos.map(
          (todo) => html`
            <li>
              ${todo.task}
              <vaadin-button @click=${() => this.clear(todo.id)}
                >Delete</vaadin-button
              >
            </li>
          `
        )}
      </ul>
    `;
  }

  async firstUpdated() {
    this.todos = await todoService.getTodos();
  }

  async add() {
    const saved = await this.binder.submitTo(todoService.saveTodo);
    if (saved) {
      this.todos = [...this.todos, saved];
      this.binder.clear();
    }
  }

  async clear(id: any) {
    await todoService.deleteTodo(id);
    this.todos = this.todos.filter((t) => t.id !== id);
  }
}
