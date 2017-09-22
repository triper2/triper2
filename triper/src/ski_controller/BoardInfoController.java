package ski_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ski_db.BoardDAO;
import ski_db.BoardListBean;

/**
 * Servlet implementation class BoardInfoController
 */
@WebServlet("/BoardInfoController.do")
public class BoardInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}
	protected void requestpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����ڰ� ������ �ڵ��� ��ȣ�� �Է�
		int boardno=Integer.parseInt(request.getParameter("product_Boardno"));
				
				//�����ͺ��̽��� �����Ͽ� �ϳ��� ���� �о�帲
				BoardDAO dao =new BoardDAO();
				
				BoardListBean bean = dao.getOneBoard(boardno);
				
				request.setAttribute("bean", bean);
				RequestDispatcher dis = request.getRequestDispatcher("/_ski/SkiMain.jsp?center=BoardInfoList.jsp");
				dis.forward(request, response);
	}

}

