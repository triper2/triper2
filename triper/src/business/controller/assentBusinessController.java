package business.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.service.AddBusinessService;
import business.service.Service;
import business.service.assentBusinessService;

@WebServlet("/_business/assent.business")
public class assentBusinessController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher dp = null;
		String viewPage = null;
		Service command = null;
		System.out.println("asd");
		if(request.getSession().getAttribute("dto") == null) {
			response.getWriter().println("<script type='text/javascript'>"
					+ "alert('로그인을 해야 이용가능한 페이지 입니다.');"
					+ "location.href = '../_main_login/loginForm.jsp?page=businessAdd';"
					+ "</script>");
		} else {
			System.out.println("asd");
			command = new assentBusinessService();
			command.execute(request,response);
			viewPage="/_business/myList.business";                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
					
			dp = request.getRequestDispatcher(viewPage);
			dp.forward(request, response);
		}
	}

}
