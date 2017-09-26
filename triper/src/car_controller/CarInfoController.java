package car_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car_db.CarDAO;
import car_db.CarListBean;

/**
 * Servlet implementation class CarInfoController
 */
@WebServlet("/_car/CarInfoController.do")
public class CarInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}
	protected void requestpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	      response.setContentType("text/html;charset=UTF-8");
		
		String business_id = request.getParameter("business_id");
		//����ڰ� ������ �ڵ��� ��ȣ�� �Է�
		int carno=Integer.parseInt(request.getParameter("product_carno"));
		
		//�����ͺ��̽��� �����Ͽ� �ϳ��� ���� �о�帲
		CarDAO dao =new CarDAO();
		
		CarListBean bean = dao.getOneCar(carno);
		
		request.setAttribute("bean", bean);
		RequestDispatcher dis = request.getRequestDispatcher("/_car/CarMain.jsp?center=CarInfo.jsp&top=_Top.jsp&business_id="+business_id);
		dis.forward(request, response);
	}

}
