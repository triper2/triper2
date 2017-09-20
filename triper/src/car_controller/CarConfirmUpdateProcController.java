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

/**
 * Servlet implementation class CarConfirmUpdateProcController
 */
@WebServlet("/CarConfirmUpdateProcController.do")
public class CarConfirmUpdateProcController extends HttpServlet {
	
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
		//사용자로부터 넘어온 데이터를 입력
		int orderid = Integer.parseInt(request.getParameter("orderid"));
		int carqty=Integer.parseInt(request.getParameter("carqty"));
		int carins=Integer.parseInt(request.getParameter("carins"));
		int carwifi=Integer.parseInt(request.getParameter("carwifi"));
		
		int carseat=Integer.parseInt(request.getParameter("carbabyseat"));
		String carbegindate = request.getParameter("carbegindate");
		String memberpass = request.getParameter("memberpass");
		
		//carorderbean 클래스 이용하여 데이터를 저정 후 빈클래스로 DAO
		CarOrderBean bean = new CarOrderBean();
		
		bean.setOrderid(orderid);
		bean.setReserved_product_count(carqty);
		bean.setReserved_option_carwifi(carwifi);
	
		bean.setReserved_option_usein(carins);
		bean.setReserved_option_carbabyseat(carseat);
		bean.setReserved_carbegindate(carbegindate);
		bean.setMemberpass(memberpass);
		
		//데이터 베이스 객체
		CarDAO cdao = new CarDAO();
		cdao.CarOrderUpdate(bean);
		
		request.setAttribute("bean", bean);
		RequestDispatcher dis = request.getRequestDispatcher("/_car/CarMain.jsp?center=CarReserveConfirm.jsp&top=_Top.jsp");
		dis.forward(request, response);
		
		
	}

}
