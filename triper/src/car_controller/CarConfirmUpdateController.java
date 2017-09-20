package car_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car_db.CarConfirmBean;
import car_db.CarDAO;

@WebServlet("/CarConfirmUpdateController.do")
public class CarConfirmUpdateController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}

	protected void requestpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
	      String conPath = request.getContextPath();
	      String com = uri.substring(conPath.length());
	      
	      System.out.println(uri);
	      System.out.println(conPath);
	      System.out.println(com);
		
		request.setCharacterEncoding("UTF-8");
	      response.setContentType("text/html;charset=UTF-8");
			String carimg = request.getParameter("carimg");
			int orderid = Integer.parseInt(request.getParameter("orderid"));
			
			//데베 연결
			
			CarDAO cdao = new CarDAO();
			
			//하나의 주문 정보를 얻어오는 메소드 호출
			CarConfirmBean cbean = cdao.getOnOrder(orderid);
			//차량이미지를 저장
			cbean.setProduct_carimg(carimg);
			
			request.setAttribute("cbean", cbean);
			RequestDispatcher dis = request.getRequestDispatcher("/_car/CarMain.jsp?center=CarConfirmUpdate.jsp&top=_Top.jsp");
			dis.forward(request, response);
	
	}
}
