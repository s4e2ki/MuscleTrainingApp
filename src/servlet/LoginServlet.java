package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータの取得
		//		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String errorMsg = "";
		if (name == null || name.length() == 0) {
			errorMsg += "ユーザ名が入力されていません<br>";
		}
		if (pass == null || pass.length() == 0) {
			errorMsg += "パスワードが入力されていません<br>";
		}
		if (!errorMsg.equals("")) {
			request.setAttribute("errorMsg", errorMsg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			return;
		}
		// 登録するユーザーの情報を設定
		User user = new User(name, pass);
		LoginLogic logic = new LoginLogic();
		if (!logic.execute(user)) {
			//ログインエラーの場合
			errorMsg += "ユーザ名、またはパスワードに誤りがあります";
			request.setAttribute("errorMsg", errorMsg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			return;
		}
		// セッションスコープに登録ユーザーを保存
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
		dispatcher.forward(request, response);
		// return;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//リダイレクト
		response.sendRedirect("index.jsp");
	}
}