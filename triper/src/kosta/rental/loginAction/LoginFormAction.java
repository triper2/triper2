package kosta.rental.loginAction;

import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.SecureRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFormAction implements CommandAction {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		String clientId = "jG6JK4zeWYdD6NtIKfw4"; //애플리케이션 클라이언트 아이디값";
		String redirectURI = URLEncoder.encode("http://localhost:8080/triper/_main_login/index.jsp", "UTF-8");
		SecureRandom random = new SecureRandom();
		String state = new BigInteger(130, random).toString();
		String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
		apiURL += "&client_id=" + clientId;
		apiURL += "&redirect_uri=" + redirectURI;
		apiURL += "&state=" + state;
		session.setAttribute("state", state);
		return apiURL;
	}

}
