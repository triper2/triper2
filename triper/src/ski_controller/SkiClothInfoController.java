package ski_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ski_db.SkiClothListBean;
import ski_db.SkiDAO;

/**
 * Servlet implementation class SkiClothInfoController
 */
@WebServlet("/SkiClothInfoController.do")
public class SkiClothInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}

	protected void requestpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자가 선택한 자동차 번호를 입력
		int skiclothno=Integer.parseInt(request.getParameter("product_skiclothno"));
				
				//데이터베이스에 연결하여 하나의 정보 읽어드림
			SkiDAO dao = new SkiDAO();
				
			SkiClothListBean bean = dao.getOneSkicloth(skiclothno);
				
				request.setAttribute("bean", bean);
				RequestDispatcher dis = request.getRequestDispatcher("/_ski/SkiMain.jsp?center=SkiClothInfoList.jsp");
				dis.forward(request, response);
	}
}
