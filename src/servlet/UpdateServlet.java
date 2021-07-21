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
import model.Todo;
import model.UpdateLogic;
import model.User;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String importance = request.getParameter("importance");
		String content = request.getParameter("content");
		String deadline = request.getParameter("deadline");
		int no = Integer.parseInt(request.getParameter("no"));
		String errorMsg = "";
		//エラーチェック
		if (content == null || content.length() == 0) {
			errorMsg += "内容が入力されていません<br>";
		}
		if (deadline == null || deadline.length() == 0) {
			errorMsg += "期日が入力されていません<br>";
		}
		if (!errorMsg.equals("")) {
			request.setAttribute("errorMsg", errorMsg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
			dispatcher.forward(request, response);
			return;
		}

		Todo todo = new Todo(no, importance, content, deadline);
		//入力値をプロパティに設定
		UpdateLogic updateLogic = new UpdateLogic();
		updateLogic.execute(todo);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		GetTodoListLogic getTodoListLogic = new GetTodoListLogic();
		List<Todo> todoList = getTodoListLogic.execute(user.getName());
		request.setAttribute("todoList", todoList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ListServlet");
		dispatcher.forward(request, response);
	}
}