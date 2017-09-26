package car_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car_db.CarDAO;

@WebServlet("/_car/CarConfirmDeleteController.do")
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
	      String business_id = request.getParameter("business_id");
		//����ڷ� ���� �Է�
		int orderid= Integer.parseInt(request.getParameter("orderid"));
		String memberpass = request.getParameter("memberpass");
		
		//������ ���̽� ��ü�� ����
		CarDAO cdao = new CarDAO();

		int result = cdao.CarOrderDelete(orderid,memberpass);
		
		if(result!=0){//1. ������ ����� ����Ǿ��ٸ�
			RequestDispatcher dis = 
				request.getRequestDispatcher("CarListController.do");
			dis.forward(request, response);
		}else{//������ ����� ������� �ʾҴٸ� = password�� Ʋ��
			
			request.setAttribute("result", result);//result���� 0�Դϴ�.
			RequestDispatcher dis = 
					request.getRequestDispatcher("/_car/CarMain.jsp?center=CarConfirmDelete.jsp&top=_Top.jsp&business_id="+business_id);
				dis.forward(request, response);
		}
	
	}

}
