package ski_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ski_db.SkiDAO;
import ski_db.SkiListBean;

/**
 * Servlet implementation class SkiInfoController
 */
@WebServlet("/SkiInfoController.do")
public class SkiInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}
	protected void requestpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����ڰ� ������ �ڵ��� ��ȣ�� �Է�
		int skino=Integer.parseInt(request.getParameter("product_skino"));
				
				//�����ͺ��̽��� �����Ͽ� �ϳ��� ���� �о�帲
			SkiDAO dao = new SkiDAO();
				
				SkiListBean bean = dao.getOneski(skino);
				
				request.setAttribute("bean", bean);
				RequestDispatcher dis = request.getRequestDispatcher("/_ski/SkiMain.jsp?center=SkiInfoList.jsp");
				dis.forward(request, response);
	}

}
