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
			
			
			//���� ����
			
			SkiDAO sdao = new SkiDAO();
			
			Skiorder1 spbean = sdao.getSkiOneprice(skiimg);
			//�ϳ��� �ֹ� ������ ������ �޼ҵ� ȣ��
			Skiorder1 ssbean = sdao.getSkiOneOrder(s_orderid);
			//�����̹����� ����
			ssbean.setProduct_skiimg(skiimg);
			
			request.setAttribute("spbean", spbean);
			request.setAttribute("ssbean", ssbean);
			
			RequestDispatcher dis = request.getRequestDispatcher("/_ski/SkiMain.jsp?center=SkiUpdate.jsp");
			dis.forward(request, response);
	
	}

}
