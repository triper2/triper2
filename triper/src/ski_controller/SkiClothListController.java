package ski_controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ski_db.SkiClothListBean;
import ski_db.SkiDAO;

/**
 * Servlet implementation class SkiClothListController
 */
@WebServlet("/SkiClothListController.do")
public class SkiClothListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}
	protected void requestpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//������ ���̽��� �����ϱ����� ModelŬ������ ����
		SkiDAO sdao = new SkiDAO();
		//���� ������ ���̽��� �����Ͽ� �ڵ��� ������ ��� �о ���Ϳ� ����
		Vector<SkiClothListBean> v = sdao.getAllSkiclothlist();
		
		//ȭ�鿡 ������ ���������� �̵���Ŵ - request��ü ��Ƽ� �����ݴϴ�.
		request.setAttribute("v", v);
		RequestDispatcher dis = request.getRequestDispatcher("/_ski/SkiMain.jsp?center=SkiClothList.jsp");
		dis.forward(request, response);
	}

}
