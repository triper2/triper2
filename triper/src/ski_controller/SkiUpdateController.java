package ski_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ski_db.SkiDAO;
import ski_db.Skiorder1;

/**
 * Servlet implementation class SkiUpdateController
 */
@WebServlet("/SkiUpdateController.do")
public class SkiUpdateController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}

	protected void requestpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			String skiimg = request.getParameter("skiimg");
			int s_orderid = Integer.parseInt(request.getParameter("s_orderid"));
			
			
			//데베 연결
			
			SkiDAO sdao = new SkiDAO();
			
			Skiorder1 spbean = sdao.getSkiOneprice(skiimg);
			//하나의 주문 정보를 얻어오는 메소드 호출
			Skiorder1 ssbean = sdao.getSkiOneOrder(s_orderid);
			//차량이미지를 저장
			ssbean.setProduct_skiimg(skiimg);
			
			request.setAttribute("spbean", spbean);
			request.setAttribute("ssbean", ssbean);
			
			RequestDispatcher dis = request.getRequestDispatcher("/_ski/SkiMain.jsp?center=SkiUpdate.jsp");
			dis.forward(request, response);
	
	}

}
