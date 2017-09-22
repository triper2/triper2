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
 * Servlet implementation class SkiUpdateProcController
 */
@WebServlet("/SkiUpdateProcController.do")
public class SkiUpdateProcController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
		}
		protected void requestpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			request.setCharacterEncoding("UTF-8");
		      response.setContentType("text/html;charset=UTF-8");
			//����ڷκ��� �Ѿ�� �����͸� �Է�
			int s_orderid = Integer.parseInt(request.getParameter("s_orderid"));
			
			String skibeginday = request.getParameter("skibeginday");
			String skiendday = request.getParameter("skiendday");
			String skisize=request.getParameter("skisize");
			String memberpass = request.getParameter("memberpass");
			System.out.println(s_orderid);
			System.out.println(skibeginday);
			System.out.println(skiendday);
			System.out.println(skisize);
			
			Skiorder1 sbean = new Skiorder1();
			
			sbean.setS_orderid(s_orderid);
			sbean.setSkibeginday(skibeginday);
			sbean.setSkiendday(skiendday);
		
			sbean.setSkisize(skisize);
			sbean.setMemberpass(memberpass);
			
			//������ ���̽� ��ü
			SkiDAO sdao = new SkiDAO();
			sdao.SkiOrderUpdate(sbean);
			
			request.setAttribute("sbean", sbean);
			RequestDispatcher dis = request.getRequestDispatcher("/SkiListController1.do");
			dis.forward(request, response);
			
			
		}

}
