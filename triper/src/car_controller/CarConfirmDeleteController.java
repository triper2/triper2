package car_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car_db.CarDAO;

@WebServlet("/CarConfirmDeleteController.do")
public class CarConfirmDeleteController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	requestpro(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	
	}
	private void requestpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		request.setCharacterEncoding("UTF-8");
	      response.setContentType("text/html;charset=UTF-8");
		//사용자로 부터 입력
		int orderid= Integer.parseInt(request.getParameter("orderid"));
		String memberpass = request.getParameter("memberpass");
		
		//데이터 베이스 객체를 생성
		CarDAO cdao = new CarDAO();

		int result = cdao.CarOrderDelete(orderid,memberpass);
		
		if(result!=0){//1. 쿼리가 제대로 실행되었다면
			RequestDispatcher dis = 
				request.getRequestDispatcher("CarListController.do");
			dis.forward(request, response);
		}else{//쿼리가 제대로 실행되지 않았다면 = password가 틀림
			
			request.setAttribute("result", result);//result값은 0입니다.
			RequestDispatcher dis = 
					request.getRequestDispatcher("/_car/CarMain.jsp?center=CarConfirmDelete.jsp&top=_Top.jsp");
				dis.forward(request, response);
		}
	
	}

}
