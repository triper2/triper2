package kosta.rental.loginAction;

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

@WebServlet("/loginNaver.do")
public class LoginFormAction extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println("get");
		try {
			process(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println("post");
		try {
			process(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	private void process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String clientId = "jG6JK4zeWYdD6NtIKfw4"; //애플리케이션 클라이언트 아이디값";
		String redirectURI = URLEncoder.encode("http://localhost:8080/triper/_main_login/index.jsp", "UTF-8");
		SecureRandom random = new SecureRandom();
		String state = new BigInteger(130, random).toString();
		String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
		apiURL += "&client_id=" + clientId;
		apiURL += "&redirect_uri=" + redirectURI;
		apiURL += "&state=" + state;
		request.getSession().setAttribute("state", state);
		System.out.println("state : "+state);
		System.out.println("apiURL : "+apiURL);
		RequestDispatcher dp = request.getRequestDispatcher(apiURL);
		dp.forward(request, response);
		//return apiURL;
	}

}

//https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=jG6JK4zeWYdD6NtIKfw4&redirect_uri=http://localhost:8080/triper/_main_login/index.jsp