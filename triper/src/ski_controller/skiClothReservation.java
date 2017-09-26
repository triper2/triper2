package ski_controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ski_db.SkiClothOrder;


@WebServlet("/skiClothReservation.do")
public class skiClothReservation extends HttpServlet {

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
			String skiclothbeginday=request.getParameter("skiclothbeginday");
			String skiclothendday=request.getParameter("skiclothendday");
			String skiclothsize=request.getParameter("skiclothsize");
			int skiclothno =Integer.parseInt(request.getParameter("skiclothno"));
			String product_skiclothname=request.getParameter("product_skiclothname");
			int skiclothprice =Integer.parseInt(request.getParameter("skiclothprice"));
			String product_skiclothimg = request.getParameter("product_skiclothimg");
			
		
			
			SkiClothOrder bean = new SkiClothOrder();
			bean.setSkiclothbeginday(skiclothbeginday);
			bean.setSkiclothendday(skiclothendday);
			bean.setSkiclothsize(skiclothsize);
			bean.setProduct_skiclothno(Integer.parseInt(request.getParameter("skiclothno")));
			bean.setProduct_skiclothname(product_skiclothname);
			bean.setProduct_skiclothprice(Integer.parseInt(request.getParameter("skiclothprice")));
			bean.setProduct_skiclothimg(product_skiclothimg);
			
			//날짜 비교
			
			Date d1=new Date();
			Date d2=new Date();
			Date d3=new Date();
			//날짜를 2016-4-4 포맷 해주는 클래스 선언
			SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
			
			d1=sdf.parse(bean.getSkiclothbeginday());
			d2=sdf.parse(bean.getSkiclothendday());
			d3=sdf.parse(sdf.format(d3));
			
			//날짜 비교 메소드를 사용
			 long calDate = d1.getTime() - d2.getTime(); 
		        
		        // Date.getTime() 은 해당날짜를 기준으로1970년 00:00:00 부터 몇 초가 흘렀는지를 반환해준다. 
		        // 이제 24*60*60*1000(각 시간값에 따른 차이점) 을 나눠주면 일수가 나온다.
		        int calDateDays = (int) (calDate / ( 24*60*60*1000)); 
		 
		        calDateDays = Math.abs(calDateDays);

			int compare =d1.compareTo(d3);
			int compare1 =d2.compareTo(d3);
			
			int sc_total = skiclothprice * calDateDays;
			request.setAttribute("bean", bean);
			request.setAttribute("sc_total", sc_total);
			request.setAttribute("compare",compare);
			request.setAttribute("compare1",compare1);
			request.setAttribute("calDateDays", calDateDays);
		
			
			
			RequestDispatcher dis = request.getRequestDispatcher("/_ski/SkiMain.jsp?center=SkiClothReserve.jsp");
			dis.forward(request, response);
			
		}

}
