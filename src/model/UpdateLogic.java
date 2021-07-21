package model;

import dao.TodoDAO;

public class UpdateLogic {
	public boolean execute(Todo todo) {
		TodoDAO todoDAO = new TodoDAO();
		return todoDAO.update(todo);
	}
}
