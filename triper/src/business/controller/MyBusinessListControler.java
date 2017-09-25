package business.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.service.MyBusinessListService;
import business.service.Service;
import business.vo.BusinessVO;
import kosta.rental.loginModel.RentalDTO;

@WebServlet("/_business/myList.business")
public class MyBusinessListControler extends HttpServlet {
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
		String viewPage = "/_main_login/loginForm.jsp?page=businessMyList";
		MyBusinessListService command = null;
		if(request.getSession().getAttribute("dto") == null) {
			response.getWriter().println("<script type='text/javascript'>"
					+ "alert('로그인을 해야 이용가능한 페이지 입니다.');"
					+ "location.href = '../_main_login/loginForm.jsp?page=businessMyList';"
					+ "</script>");
		} else {
			command = new MyBusinessListService();
			command.execute(request,response);
			
			request.setAttribute("list", command.getList());
			
			viewPage="/_business/businessMyListForm.jsp";
			
			dp = request.getRequestDispatcher(viewPage);
			dp.forward(request, response);
		}
		
	}

}