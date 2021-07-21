package model;

import dao.TodoDAO;

public class InputLogic {

	public boolean execute(Todo todo) {
		TodoDAO todoDAO = new TodoDAO();
		return todoDAO.create(todo);
	}
}
