import { LitElement, html, property, customElement } from "lit-element";
import "@vaadin/vaadin-text-field";
import "@vaadin/vaadin-button";
import { addTodo, deleteTodo, getTodos } from "../generated/TodoService";
import Todo from "../generated/com/example/application/backend/Todo";

@customElement("todo-view")
export class TodoView extends LitElement {
  @property({ type: String })
  private task = "";
  @property({ type: Array })
  private todos: Todo[] = [];

  protected render() {
    return html`
      <h1>Todo</h1>

      <div class="form">
        <vaadin-text-field
          .value=${this.task}
          @change=${this.updateTask}
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
    this.todos = await getTodos();
  }

  updateTask(e: { target: HTMLInputElement }) {
    this.task = e.target.value;
  }

  async add() {
    const todo = await addTodo(this.task);
    this.todos = [...this.todos, todo];
    this.task = "";
  }

  async clear(id: any) {
    await deleteTodo(id);
    this.todos = this.todos.filter((t) => t.id !== id);
  }
}
