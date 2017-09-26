package car_controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		try {
			requestpro(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			requestpro(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void requestpro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
	      response.setContentType("text/html;charset=UTF-8");
		//사용자로부터 넘어온 데이터를 입력
		int orderid = Integer.parseInt(request.getParameter("orderid"));
		int carqty=Integer.parseInt(request.getParameter("carqty"));
		int carins=Integer.parseInt(request.getParameter("carins"));
		int carwifi=Integer.parseInt(request.getParameter("carwifi"));
		
		int carseat=Integer.parseInt(request.getParameter("carbabyseat"));
		String reserved_carbegindate = request.getParameter("carbegindate");
		String reserved_carenddate= request.getParameter("carenddate");
		String memberpass = request.getParameter("memberpass");
		int carprice = Integer.parseInt(request.getParameter("carprice"));
		System.out.println(reserved_carbegindate);
		//carorderbean 클래스 이용하여 데이터를 저정 후 빈클래스로 DAO
		CarOrderBean bean = new CarOrderBean();
		
		bean.setOrderid(orderid);
		bean.setReserved_product_count(carqty);
		bean.setReserved_option_carwifi(carwifi);
		//날짜 비교
		bean.setReserved_carbegindate(reserved_carbegindate);
		bean.setReserved_carenddate(reserved_carenddate);
		Date d1=new Date();
		Date d2=new Date();
		Date d3=new Date();
		//날짜를 2016-4-4 포맷 해주는 클래스 선언
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		
		d1=sdf.parse(bean.getReserved_carbegindate());
		d2=sdf.parse(bean.getReserved_carenddate());
		d3=sdf.parse(sdf.format(d3));
		
		//날짜 비교 메소드를 사용
		 long calDate = d1.getTime() - d2.getTime(); 
	        
	        // Date.getTime() 은 해당날짜를 기준으로1970년 00:00:00 부터 몇 초가 흘렀는지를 반환해준다. 
	        // 이제 24*60*60*1000(각 시간값에 따른 차이점) 을 나눠주면 일수가 나온다.
	        int calDateDays = (int) (calDate / ( 24*60*60*1000)); 
	 
	        calDateDays = Math.abs(calDateDays);

		int compare =d1.compareTo(d3);
		int compare1 =d2.compareTo(d3);
		
		int totalprice =( carprice * carqty* calDateDays)
		 + ((( carins +  carwifi +  carseat) * calDateDays)*10000);
		
		bean.setReserved_option_usein(carins);
		bean.setReserved_option_carbabyseat(carseat);
		bean.setCalDateDays(calDateDays);
		bean.setMemberpass(memberpass);
		bean.setTotalprice(totalprice);
		//데이터 베이스 객체
		System.out.println(totalprice);
		System.out.println(carprice);
		System.out.println(calDateDays);
		CarDAO cdao = new CarDAO();
		cdao.CarOrderUpdate(bean);
		System.out.println(carprice);
		System.out.println(carqty);
		System.out.println(calDateDays);
		System.out.println(carins);
		System.out.println(carwifi);
		System.out.println(carseat);
		
		request.setAttribute("bean", bean);
		RequestDispatcher dis = request.getRequestDispatcher("/CarListController.do");
		dis.forward(request, response);
		
		
	}

}
