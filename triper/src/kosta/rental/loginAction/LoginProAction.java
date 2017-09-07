package kosta.rental.loginAction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.rental.loginModel.RentalDAO;

public class LoginProAction implements CommandAction{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
    	request.setCharacterEncoding("UTF-8");
    	System.out.println("sdf");
    	String id = request.getParameter("id");
        String pwd = request.getParameter("password");
        RentalDAO dao = RentalDAO.getInstance();
        int check = dao.userCheck(id, pwd);
        
		return "/_main_login/loginPro.jsp";
	}	
}
