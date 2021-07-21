package model;

import dao.TodoDAO;

public class RemoveLogic {
	public boolean execute(int no) {
		TodoDAO todoDAO = new TodoDAO();
		return todoDAO.delete(no);
	}
}
