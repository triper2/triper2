package kosta.rental.loginAction;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import kosta.rental.loginModel.RentalDAO;
import kosta.rental.loginModel.RentalDTO;

@WebServlet("*.do")
public class LoginProAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String name;

	public LoginProAction() {
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
		ServletRequest session = null;
		if (com.equals("/_main_login/loginPro.do")) { ///////////////////////////////////loginPro.do
			String id = request.getParameter("id");
			String pwd = request.getParameter("password");
			RentalDAO dao = RentalDAO.getInstance();
			try {
				check = dao.userCheck(id, pwd);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (check == 1) {
				request.getSession().setAttribute("id", id);
				request.getSession().setAttribute("sessionInfo", dao.getMember(id));
			}
			request.setAttribute("check", check);
			viewPage = "/_main_login/loginPro.jsp";
			RequestDispatcher dp = request.getRequestDispatcher(viewPage);
			dp.forward(request, response);
		} 
		else if (com.equals("/_main_login/loginForm.do")) { ///////////////////////////////////loginForm.do
			viewPage = "/_main_login/index.jsp";
			RequestDispatcher dp = request.getRequestDispatcher(viewPage);
			dp.forward(request, response);
		} 
		else if (com.equals("/_main_login/registerPro.do")){ ///////////////////////////////////registerPro.do
			RentalDAO dao = RentalDAO.getInstance();
			RentalDTO dto = new RentalDTO();
			dto.setMember_id(request.getParameter("member_id"));
			dto.setMember_name(request.getParameter("member_name"));
			dto.setMember_pwd(request.getParameter("member_pwd"));
			dto.setMember_phone(request.getParameter("member_phone"));
			dto.setMember_email(request.getParameter("member_email"));
			dto.setMember_img(request.getParameter("member_img"));
			dao.insert(dto);
			viewPage = "/_main_login/registerPro.jsp";
			RequestDispatcher dp = request.getRequestDispatcher(viewPage);
			dp.forward(request, response);
		}
		else if (com.equals("/_main_login/idCheck.do")) { ///////////////////////////////////idCheck.do
			String id = request.getParameter("member_id");
			RentalDAO dao = RentalDAO.getInstance();
			try {
				PrintWriter out = response.getWriter(); //ajax때문에 이렇게 write를 써야함
				out.write(dao.idCheck(id)+"");
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (com.equals("/_main_login/pwCheck.do")) { ///////////////////////////////////pwCheck.do
			String pwd = request.getParameter("member_pwd");
			RentalDAO dao = RentalDAO.getInstance();
			try {
				PrintWriter out = response.getWriter();
				out.write(dao.pwCheck(pwd)+""); //ajax때문에 이렇게 write를 써야함
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (com.equals("/_main_login/phoneCheck.do")) { ///////////////////////////////////phoneCheck.do
			String phone = request.getParameter("member_phone");
			RentalDAO dao = RentalDAO.getInstance();
			try {
				PrintWriter out = response.getWriter();
				out.write(dao.phoneCheck(phone)+""); //ajax때문에 이렇게 write를 써야함
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (com.equals("/_main_login/emailCheck.do")) { ///////////////////////////////////emailCheck.do
			String email = request.getParameter("member_email");
			RentalDAO dao = RentalDAO.getInstance();
			try {
				PrintWriter out = response.getWriter();
				out.write(dao.emailCheck(email)+""); //ajax때문에 이렇게 write를 써야함
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
		 else if (com.equals("/_main_login/modifyPro.do")) { ///////////////////////////////////modifyPro.do
			String id = request.getParameter("member_id");
			RentalDAO dao = RentalDAO.getInstance();
			RentalDTO dto = dao.getMember(id);
			dto.setMember_id(request.getParameter("member_id"));
			dto.setMember_name(request.getParameter("member_name"));
			dto.setMember_pwd(request.getParameter("member_pwd"));
			dto.setMember_phone(request.getParameter("member_phone"));
			dto.setMember_email(request.getParameter("member_email"));
			dto.setMember_img(request.getParameter("member_img"));
			dao.modify(dto);
			request.getSession().setAttribute("sessionInfo", dto);
			viewPage = "/_main_login/index.jsp";
			RequestDispatcher dp = request.getRequestDispatcher(viewPage);
			dp.forward(request, response);
		} 
		 else if (com.equals("/_main_login/deletePro.do")) { ///////////////////////////////////deletePro.do
			String id = (String)request.getSession().getAttribute("id");
			String pwd = request.getParameter("password");
			RentalDAO dao = RentalDAO.getInstance();
			try {
				check = dao.delete(id, pwd);
				System.out.println(check);

			} catch (Exception e) {
				e.printStackTrace();
			}
			if (check == 1) {
				request.getSession().invalidate();
			}
			request.setAttribute("check", check);
			viewPage = "/_main_login/deletePro.jsp";
			RequestDispatcher dp = request.getRequestDispatcher(viewPage);
			dp.forward(request, response);
		} 
		 else if (com.equals("/_main_login/mypage.do")) { ///////////////////////////////////mypage.do
			viewPage = "/_main_login/mypage.jsp";
			RequestDispatcher dp = request.getRequestDispatcher(viewPage);
			dp.forward(request, response);
		} else if (com.equals("/_main_login/member_img.do")) { ///////////////////////////////////mem_image.do
			
			
			
			
			
		}
		
		
		else { //if (com.equals("/_main_login/naverlogin.do")) 
			String clientId = "jG6JK4zeWYdD6NtIKfw4"; //애플리케이션 클라이언트 아이디값";
			String redirectURI = URLEncoder.encode("http://localhost:8080/triper/_main_login/index.jsp", "UTF-8");
			SecureRandom random = new SecureRandom();
			String state = new BigInteger(130, random).toString();
			String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
			apiURL += "&client_id=" + clientId;
			apiURL += "&redirect_uri=" + redirectURI;
			apiURL += "&state=" + state;
			//request.getSession().setAttribute("state", state);
			//RentalDAO dao = RentalDAO.getInstance();
			//request.getSession().setAttribute("sessionInfo", dao.getMember(clientId));

			System.out.println("apiURL : "+apiURL);
			
			response.sendRedirect(apiURL);
		} 
		// System.out.println(viewPage);
		
	}
}