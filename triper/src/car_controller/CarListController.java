package car_controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.jrockit.jfr.RequestDelegate;

import car_db.CarDAO;
import car_db.CarListBean;

/**
 * Servlet implementation class CarListController
 */
@WebServlet("/_car/CarListController.do")
public class CarListController extends HttpServlet {
	//��ü ���� ���� Ŭ�����Դϴ�.
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request,response);
	}
	//doGet,doPost ������� �����Ͱ� �Ѿ���� ��� requestpro�޼ҵ忡�� ó��
	private void requestpro(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException  {
		
	      String business_id = request.getParameter("business_id");
	      
		request.setCharacterEncoding("UTF-8");
	      response.setContentType("text/html;charset=UTF-8");
		
		
		//������ ���̽��� �����ϱ����� ModelŬ������ ����
		CarDAO cdao = new CarDAO();
		//���� ������ ���̽��� �����Ͽ� �ڵ��� ������ ��� �о ���Ϳ� ����
		Vector<CarListBean> v = cdao.getAllCarlist(business_id);
		
		//ȭ�鿡 ������ ���������� �̵���Ŵ - request��ü ��Ƽ� �����ݴϴ�.
		request.setAttribute("v", v);
		
		System.out.println();
		RequestDispatcher dis = request.getRequestDispatcher("/_car/CarMain.jsp?center=CarList.jsp&top=_Top.jsp&business_id="+business_id);
		
		//�����͸� �Ѱ��ֽÿ�
		dis.forward(request, response);
	}

}






