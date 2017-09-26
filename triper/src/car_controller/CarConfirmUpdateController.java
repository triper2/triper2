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

@WebServlet("/_car/CarConfirmUpdateController.do")
public class CarConfirmUpdateController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}

	protected void requestpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			String carimg = request.getParameter("carimg");
			int orderid = Integer.parseInt(request.getParameter("orderid"));
			String business_id = request.getParameter("business_id");
			//���� ����
			
			CarDAO cdao = new CarDAO();
			CarConfirmBean cpbean = cdao.getOneprice(carimg);
			//�ϳ��� �ֹ� ������ ������ �޼ҵ� ȣ��
			CarConfirmBean cbean = cdao.getOnOrder(orderid);
			//�����̹����� ����
			cbean.setProduct_carimg(carimg);
			
			request.setAttribute("cbean", cbean);
			request.setAttribute("cpbean", cpbean);
			RequestDispatcher dis = request.getRequestDispatcher("/_car/CarMain.jsp?center=CarConfirmUpdate.jsp&top=_Top.jsp&business_id="+business_id);
			dis.forward(request, response);
	
	}
}
