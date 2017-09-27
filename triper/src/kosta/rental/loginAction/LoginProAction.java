package kosta.rental.loginAction;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.SecureRandom;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kosta.rental.loginModel.RentalDAO;
import kosta.rental.loginModel.RentalDTO;
import kosta.rental.loginAction.*;

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
		String conPath = request.getContextPath(); // http://localhost:8080/triper �뿬湲곌퉴吏� 湲몄씠 援ы븯湲� /_main_login/loginPro.do
		String com = uri.substring(conPath.length()); // 湲몄씠媛� 鍮쇨퀬(�씠�썑�쓽) /_main_login/loginPro.do
		int check = 0;
		ServletRequest session = null;
		String page = request.getParameter("page");
		if (com.equals("/_main_login/loginPro.do")) { ///////////////////////////////////loginPro.do
			String id = request.getParameter("id");
			String pwd = request.getParameter("password");
			RentalDAO dao = RentalDAO.getInstance();
			RentalDTO dto = dao.getMember(id);

			try {
				check = dao.userCheck(id, pwd);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (check == 1) {
				request.getSession().setAttribute("id", id);
				request.getSession().setAttribute("dto", dto);
			}
			request.setAttribute("check", check);
			viewPage = "/_main_login/loginPro.jsp";
			if(!(page.equals("") || page == null)) {
				request.setAttribute("page", page);
			} 
			RequestDispatcher dp = request.getRequestDispatcher(viewPage);
			dp.forward(request, response);
		} 
		else if (com.equals("/_main_login/loginForm.do")) { ///////////////////////////////////loginForm.do
			viewPage = "/_main_login/main.jsp";
			RequestDispatcher dp = request.getRequestDispatcher(viewPage);
			dp.forward(request, response);
		} 
		else if (com.equals("/_main_login/registerPro.do")){ ///////////////////////////////////registerPro.do
			MultipartRequest multi = FileUtil.createFile(request);
			//String member_img = multi.getFilesystemName("member_img");
			
			RentalDAO dao = RentalDAO.getInstance();
			RentalDTO dto = new RentalDTO();
			dto.setMember_id(multi.getParameter("member_id"));
			dto.setMember_name(multi.getParameter("member_name"));
			dto.setMember_pwd(multi.getParameter("member_pwd"));
			dto.setMember_phone(multi.getParameter("member_phone"));
			dto.setMember_email(multi.getParameter("member_email"));
			dto.setMember_img("basicface.jpg");
			//System.out.println(member_img);
			//dto.setMember_img(member_img);
			dao.insert(dto);
			//request.getSession().setAttribute("dto", dto);

			viewPage = "/_main_login/registerPro.jsp";
			RequestDispatcher dp = request.getRequestDispatcher(viewPage);
			dp.forward(request, response);
		}
		else if (com.equals("/_main_login/idCheck.do")) { ///////////////////////////////////idCheck.do
			String id = request.getParameter("member_id");
			RentalDAO dao = RentalDAO.getInstance();
			try {
				PrintWriter out = response.getWriter(); //ajax�븣臾몄뿉 �씠�젃寃� write瑜� �뜥�빞�븿
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
				out.write(dao.pwCheck(pwd)+""); //ajax�븣臾몄뿉 �씠�젃寃� write瑜� �뜥�빞�븿
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
				out.write(dao.phoneCheck(phone)+""); //ajax�븣臾몄뿉 �씠�젃寃� write瑜� �뜥�빞�븿
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
				out.write(dao.emailCheck(email)+""); //ajax�븣臾몄뿉 �씠�젃寃� write瑜� �뜥�빞�븿
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
		else if (com.equals("/_main_login/findID.do")) { ///////////////////////////////////emailCheck.do
			String member_email = request.getParameter("member_email");
			RentalDAO dao = RentalDAO.getInstance();
			try {
				PrintWriter out = response.getWriter();
				out.write(dao.findID(member_email)+""); //ajax때문에 이렇게 write를 써야함
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (com.equals("/_main_login/findPWD.do")) { ///////////////////////////////////emailCheck.do
			String member_id = request.getParameter("member_id");
			String member_phone = request.getParameter("member_phone");
			RentalDAO dao = RentalDAO.getInstance();
			try {
				PrintWriter out = response.getWriter();
				out.write(dao.findPWD(member_id, member_phone)+""); //ajax때문에 이렇게 write를 써야함
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		 else if (com.equals("/_main_login/modifyPro.do")) { ///////////////////////////////////modifyPro.do
			MultipartRequest multi = FileUtil.createFile(request);
			String member_img = multi.getFilesystemName("member_img");
			RentalDAO dao = RentalDAO.getInstance();
			RentalDTO dto = new RentalDTO();
			dto.setMember_id(multi.getParameter("member_id"));
			dto.setMember_name(multi.getParameter("member_name"));
			dto.setMember_pwd(multi.getParameter("member_pwd"));
			dto.setMember_phone(multi.getParameter("member_phone"));
			dto.setMember_email(multi.getParameter("member_email"));
			dto.setMember_img(multi.getParameter("member_img"));
//			dto.setMember_img(request.getParameter("member_img"));
			/*if (member_img != null) {
				// �씠誘몄�媛� 蹂�寃쎈릺�뿀�쓣 寃쎌슦
				dto.setMember_img(FileUtil.rename(member_img));
			} else {
				// �씠誘몄�媛� 蹂�寃쎈릺吏� �븡�븯�쓣寃쎌슦
				dto.setMember_img(member_img);
			}*/
			System.out.println(member_img);
			dto.setMember_img(member_img);
			dao.modify(dto);
			request.getSession().setAttribute("dto", dto);
			viewPage = "/_main_login/main.jsp";
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
			viewPage = "/_main_login/main.jsp";
			RequestDispatcher dp = request.getRequestDispatcher(viewPage);
			dp.forward(request, response);
		} 	
		/*else { //if (com.equals("/_main_login/naverlogin.do")) 
			String clientId = "jG6JK4zeWYdD6NtIKfw4"; //애플리케이션 클라이언트 아이디값";
=======
		} else if (com.equals("/_main_login/member_img.do")) { ///////////////////////////////////mem_image.do
			
			
			
			
			
		}
		
		
		else { //if (com.equals("/_main_login/naverlogin.do")) 
			String clientId = "jG6JK4zeWYdD6NtIKfw4"; //�븷�뵆由ъ��씠�뀡 �겢�씪�씠�뼵�듃 �븘�씠�뵒媛�";
>>>>>>> branch 'master' of https://github.com/triper2/triper2.git
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
		} */
		// System.out.println(viewPage);
		
	}
}