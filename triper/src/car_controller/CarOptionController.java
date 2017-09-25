package car_controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car_db.CarOrderBean;


@WebServlet("/CarOptionController.do")
public class CarOptionController extends HttpServlet {
	
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
	protected void requestpro(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		request.setCharacterEncoding("UTF-8");
	      response.setContentType("text/html;charset=UTF-8");
		
		//금액 연산을 윟ㅏ여 데이터를 일일이 받아줌
		int carqty= Integer.parseInt(request.getParameter("carqty"));
		int carprice= Integer.parseInt(request.getParameter("carprice"));
		String carbegindate =request.getParameter("carbegindate");
		String carbegintime =request.getParameter("carbegintime");
		String carenddate =request.getParameter("carenddate");
		String carendtime =request.getParameter("carendtime");
		int carins= Integer.parseInt(request.getParameter("carins"));
		int carwifi= Integer.parseInt(request.getParameter("carwifi"));
		int carnavi= Integer.parseInt(request.getParameter("carnavi"));
		int carbabyseat= Integer.parseInt(request.getParameter("carbabyseat"));
		
		
		
	
		
		
		/*연산후 결과 CarOrder.jsp로 데이터를 넘겨줌
		차량가액 = 수량 * 대여기간 * 차량가격
		
		int totalreserve =carqty *  (DateFormat. carenddate-carbegindate) * carprice;
		int totalreserve =carqty *  carprice;
		옵션금액 = 각종 옵션의 대여기간과 수량을 곱해서
		int totaloption = (carins*(carenddate-carbegindate))+(carwifi*(carenddate-carbegindate))
					+(carbabyseat*(carenddate-carbegindate))*10000 * carqty;
		int totaloption =  carqty;*/
		
		//jsp 쪽으로 선택데이터 모두 넘겨줌
		//carorderbean 클래스로
		
		CarOrderBean cbean = new CarOrderBean();
		cbean.setProduct_carno(Integer.parseInt(request.getParameter("carno")));
		cbean.setReserved_carbegindate(carbegindate);
		cbean.setReserved_carenddate(carenddate);
		cbean.setReserved_product_count(carqty);
		cbean.setReserved_option_usein(carins);
		cbean.setReserved_option_carwifi(carwifi);
		cbean.setReserved_option_carnavi(carnavi);
		cbean.setReserved_option_carbabyseat(carbabyseat);
		cbean.setReserved_carbegindate(request.getParameter("carbegindate"));
		
		//날짜 비교
		
		Date d1=new Date();
		Date d2=new Date();
		Date d3=new Date();
		//날짜를 2016-4-4 포맷 해주는 클래스 선언
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		
		d1=sdf.parse(cbean.getReserved_carbegindate());
		d2=sdf.parse(cbean.getReserved_carenddate());
		d3=sdf.parse(sdf.format(d3));
		
		//날짜 비교 메소드를 사용
		 long calDate = d1.getTime() - d2.getTime(); 
	        
	        // Date.getTime() 은 해당날짜를 기준으로1970년 00:00:00 부터 몇 초가 흘렀는지를 반환해준다. 
	        // 이제 24*60*60*1000(각 시간값에 따른 차이점) 을 나눠주면 일수가 나온다.
	        int calDateDays = (int) (calDate / ( 24*60*60*1000)); 
	 
	        calDateDays = Math.abs(calDateDays);

		int compare =d1.compareTo(d3);
		int compare1 =d2.compareTo(d3);
		//예약하려는 날짜보다 현재날짜가 크다면 -1
		//예약하려는 날짜와 현재날짜가 같다면 0
		//예약하려는 날짜가 더 크다면 1을 리턴

		//연산후 결과 CarOrder.jsp로 데이터를 넘겨줌
		//차량가액 = 수량 * 대여기간 * 차량가격
		
		/*int totalreserve =carqty *  (DateFormat. carenddate-carbegindate) * carprice;*/
		int totalreserve =(int) (carqty *  carprice * calDateDays);
		//옵션금액 = 각종 옵션의 대여기간과 수량을 곱해서
		int totaloption = (int) ((carins+carwifi+carbabyseat)*calDateDays*10000 * carqty);
		int totalprice = totalreserve + totaloption;
		
		//jsp 쪽으로 선택데이터 모두 넘겨줌
		//carorderbean 클래스로
		cbean.setTotalprice(totalprice);
		cbean.setCalDateDays(calDateDays);
		System.out.println(totalprice);
		//carOrder.jsp 데이터 넘김
		request.setAttribute("cbean", cbean);
		request.setAttribute("totalreserve", totalreserve);
		request.setAttribute("totaloption", totaloption);
		request.setAttribute("compare",compare);
		request.setAttribute("compare1",compare1);
		request.setAttribute("calDateDays", calDateDays);
	
		RequestDispatcher dis = request.getRequestDispatcher("/_car/CarMain.jsp?center=CarOrder.jsp&top=_Top.jsp");
		dis.forward(request, response);
	}
}
