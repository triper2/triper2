package ski_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ski_db.BoardClothListBean;
import ski_db.BoardDAO;

/**
 * Servlet implementation class BoardClothInfoController
 */
@WebServlet("/BoardClothInfoController.do")
public class BoardClothInfoController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}
	protected void requestpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����ڰ� ������ �ڵ��� ��ȣ�� �Է�
		int boardclothno=Integer.parseInt(request.getParameter("product_boardclothno"));
				
				//�����ͺ��̽��� �����Ͽ� �ϳ��� ���� �о�帲
			BoardDAO dao = new BoardDAO();
				
			BoardClothListBean bean = dao.getOneBoardcloth(boardclothno);
				
				request.setAttribute("bean", bean);
				RequestDispatcher dis = request.getRequestDispatcher("/_ski/SkiMain.jsp?center=BoardClothInfoList.jsp");
				dis.forward(request, response);
	}

}
