package kosta.triper.mainAction;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/_main/index")
public class MenuFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public MenuFormAction() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			actionDo(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			actionDo(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		String viewPage = null;
		String uri = request.getRequestURI(); // http://localhost:8080/triper/_main_login/loginPro.do
		String conPath = request.getContextPath(); // http://localhost:8080/triper 여기까지 길이 구하기 /_main_login/loginPro.do
		String com = uri.substring(conPath.length()); // 길이값 빼고(이후의) /_main_login/loginPro.do
		
		viewPage = "/_main_login/index.jsp";
		
		RequestDispatcher dp = request.getRequestDispatcher(viewPage);
		dp.forward(request, response);
	}

}
