package car_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car_db.CarDAO;
import car_db.CarOrderBean;
import kosta.rental.loginModel.RentalDTO;

@WebServlet("/_car/CarOrderController.do")
public class CarOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
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
	      String memberpass="1";
	      String memberphone="1";
	      System.out.println(uri);
	      System.out.println(conPath);
	      System.out.println(com);
		
		request.setCharacterEncoding("UTF-8");
	      response.setContentType("text/html;charset=UTF-8");
		//jsp�� ���ؼ� �Ѿ���� �����͸� ��Ŭ������ ����
		CarOrderBean cbean = new CarOrderBean();
		cbean.setProduct_carno(Integer.parseInt(request.getParameter("carno")));
		cbean.setReserved_product_count(Integer.parseInt(request.getParameter("carqty")));
		cbean.setReserved_carbegindate(request.getParameter("carbegindate"));
		cbean.setReserved_carenddate(request.getParameter("carenddate"));
		cbean.setReserved_option_usein(Integer.parseInt(request.getParameter("carins")));
		cbean.setReserved_option_carwifi(Integer.parseInt(request.getParameter("carwifi")));
		cbean.setReserved_option_carnavi(Integer.parseInt(request.getParameter("carnavi")));
		cbean.setReserved_option_carbabyseat(Integer.parseInt(request.getParameter("carbabyseat")));
		cbean.setMemberphone("memberphone");
		cbean.setMemberpass("memberpass");
		cbean.setTotalprice(Integer.parseInt(request.getParameter("totalprice")));
		cbean.setCalDateDays(Integer.parseInt(request.getParameter("caldateDays")));
		cbean.setMember_id(((RentalDTO)request.getSession().getAttribute("dto")).getMember_id());
		cbean.setBusiness_id(request.getParameter("business_id"));
		//������ ���̽� ��ü ����
		CarDAO cdao = new CarDAO();
		//�ֹ� ��Ȳ�� ����
		cdao.insertCarOrder(cbean);
		
		RequestDispatcher dis = request.getRequestDispatcher("/_car/CarListController.do?business="+request.getParameter("business_id"));
		
		dis.forward(request, response);
	}

}
