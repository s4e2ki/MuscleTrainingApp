package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetTodoListLogic;
import model.RemoveLogic;
import model.Todo;
import model.User;

@WebServlet("/RemoveServlet")
public class RemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int no;
		try {
			no = Integer.parseInt(request.getParameter("no"));
		} catch (NumberFormatException e) {
			request.setAttribute("removeErrorMsg", "TODOリストが存在していません");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
			dispatcher.forward(request, response);
			return;
		}
		RemoveLogic removeLogic = new RemoveLogic();
		removeLogic.execute(no);


		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		GetTodoListLogic getTodoListLogic = new GetTodoListLogic();
		List<Todo> todoList = getTodoListLogic.execute(user.getName());
		request.setAttribute("todoList", todoList);
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("ListServlet");
		dispatcher.forward(request, response);
	}
}