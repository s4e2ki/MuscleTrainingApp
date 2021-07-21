package model;

import dao.UsersDAO;

public class LoginLogic {
	public boolean execute(User user) {
//		if(user.getPass().equals("1234")) {
//			return true;
//		}
//		return false;
		UsersDAO usersDAO = new UsersDAO();
		return usersDAO.findByUser(user);
	}
}

