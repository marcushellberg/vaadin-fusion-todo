import { Router } from "@vaadin/router";

import "./views/todo-view";

const routes = [{ path: "", component: "todo-view" }];

const router = new Router(document.querySelector("#outlet"));
router.setRoutes(routes);
