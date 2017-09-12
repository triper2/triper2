/*package kosta.rental.loginAction;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.SecureRandom;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import kosta.rental.loginModel.RentalDAO;

@WebServlet("*.do")
public class RegisterProAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterProAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println("get");
		try {
			actionDo(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println("post");
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
		int check = 0;
		
		if (com.equals("/_main_login/registerPro.do")) {
			String id = request.getParameter("member_id");
			String pwd = request.getParameter("member_pwd");
			RentalDAO dao = RentalDAO.getInstance();
			System.out.println("회원가입액션");
			try {
				check = dao.insert(id, pwd);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("check", check);
			viewPage = "/_main_login/registerPro.jsp";
			RequestDispatcher dp = request.getRequestDispatcher(viewPage);
			dp.forward(request, response);
		} 
		
		System.out.println(viewPage);
		
	}
}*/