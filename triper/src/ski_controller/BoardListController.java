package ski_controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ski_db.BoardDAO;
import ski_db.BoardListBean;


@WebServlet("/BoardListController.do")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}
	protected void requestpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//������ ���̽��� �����ϱ����� ModelŬ������ ����
		BoardDAO sdao = new BoardDAO();
		//���� ������ ���̽��� �����Ͽ� �ڵ��� ������ ��� �о ���Ϳ� ����
		Vector<BoardListBean> v = sdao.getAllBoardlist();
		
		//ȭ�鿡 ������ ���������� �̵���Ŵ - request��ü ��Ƽ� �����ݴϴ�.
		request.setAttribute("v", v);
		RequestDispatcher dis = request.getRequestDispatcher("/_ski/SkiMain.jsp?center=BoardList.jsp");
		dis.forward(request, response);
	}
}
