package ski_controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ski_db.SkiDAO;
import ski_db.SkiListBean;

/**
 * Servlet implementation class SkiListController
 */
@WebServlet("/SkiListController2.ski")
public class SkiListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}
	protected void requestpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		//데이터 베이스에 접근하기위한 Model클래스를 생성
				SkiDAO sdao = new SkiDAO();
				//실제 데이터 베이스에 접근하여 자동차 정보를 모두 읽어서 백터에 저장
				Vector<SkiListBean> v = sdao.getAllSkilist();
				
				//화면에 보여질 뷰페이지로 이동시킴 - request객체 담아서 보내줍니다.
				request.setAttribute("v", v);
				RequestDispatcher dis = request.getRequestDispatcher("/_ski/SkiMain.jsp?center=SkiList.jsp");
				dis.forward(request, response);
				
	}

}
