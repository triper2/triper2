package car_controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car_db.CarConfirmBean;
import car_db.CarDAO;


@WebServlet("/_car/CarReserveConfirmController.do")
public class CarReserveConfirmController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}
	protected void requestpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
	      response.setContentType("text/html;charset=UTF-8");
		//����ڷ� ���� �Ѿ�� ��ȭ��ȣ�� ��й�ȣ�� �о�帲
		String memberphone=request.getParameter("memberphone");
		String memberpass = request.getParameter("memberpass");
		
		//������ ���̽� ��ü����
		CarDAO cdao = new CarDAO();
		
		//carconfirmbean Ÿ������ �� ������ Ŭ���� ����
		Vector<CarConfirmBean> v = cdao.getAllCarOrder(memberphone, memberpass);
		
		//jsp�� ������ �Ѱ��־���ϱ⿡ request��ü
		request.setAttribute("v", v);
		RequestDispatcher dis = request.getRequestDispatcher("../_car/CarMain.jsp?center=CarReserveResult.jsp&top=_Top.jsp");
		dis.forward(request, response);
	
	}

}
