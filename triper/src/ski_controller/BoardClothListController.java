package ski_controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ski_db.BoardClothListBean;
import ski_db.BoardDAO;
import ski_db.BoardListBean;
import ski_db.SkiDAO;

/**
 * Servlet implementation class BoardClothListController
 */
@WebServlet("/BoardClothListController.do")
public class BoardClothListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}
	
	protected void requestpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//������ ���̽��� �����ϱ����� ModelŬ������ ����
		BoardDAO bdao = new BoardDAO();
		//���� ������ ���̽��� �����Ͽ� �ڵ��� ������ ��� �о ���Ϳ� ����
		Vector<BoardClothListBean> v = bdao.getAllBoardclothlist();
		
		//ȭ�鿡 ������ ���������� �̵���Ŵ - request��ü ��Ƽ� �����ݴϴ�.
		request.setAttribute("v", v);
		RequestDispatcher dis = request.getRequestDispatcher("/_ski/SkiMain.jsp?center=BoardClothList.jsp");
		dis.forward(request, response);
	}

}



