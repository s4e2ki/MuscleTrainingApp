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
import model.InputLogic;
import model.Todo;
import model.User;

@WebServlet("/InputServlet")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String importance = request.getParameter("importance");
		String content = request.getParameter("content");
		String deadline = request.getParameter("deadline");
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
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/input.jsp");
			dispatcher.forward(request, response);
			return;
		}

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		Todo todo = new Todo(importance, content, deadline, user.getName());
		//入力値をプロパティに設定
		InputLogic inputLogic = new InputLogic();
		inputLogic.execute(todo);


		GetTodoListLogic getTodoListLogic = new GetTodoListLogic();
		List<Todo> todoList = getTodoListLogic.execute(user.getName());
		request.setAttribute("todoList", todoList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("ListServlet");
		dispatcher.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User userCheck = (User) session.getAttribute("user");
		if (userCheck == null) {
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/input.jsp");
			dispatcher.forward(request, response);
		}
	}
}