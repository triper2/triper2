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

import ski_db.SkiDAO;
import ski_db.Skiorder1;

/**
 * Servlet implementation class SkiUpdateProcController
 */
@WebServlet("/SkiUpdateProcController.do")
public class SkiUpdateProcController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
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
			int s_orderid = Integer.parseInt(request.getParameter("s_orderid"));
			
			String skibeginday = request.getParameter("skibeginday");
			String skiendday = request.getParameter("skiendday");
			String skisize=request.getParameter("skisize");
			String memberpass = request.getParameter("memberpass");
			int skiprice = Integer.parseInt(request.getParameter("skiprice"));
			
			
			Skiorder1 sbean = new Skiorder1();
			
			sbean.setS_orderid(s_orderid);
			sbean.setSkibeginday(skibeginday);
			sbean.setSkiendday(skiendday);
			sbean.setSkisize(skisize);
			//날짜 비교
			
			Date d1=new Date();
			Date d2=new Date();
			Date d3=new Date();
			//날짜를 2016-4-4 포맷 해주는 클래스 선언
			SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
			
			d1=sdf.parse(sbean.getSkibeginday());
			d2=sdf.parse(sbean.getSkiendday());
			d3=sdf.parse(sdf.format(d3));
			
			//날짜 비교 메소드를 사용
			 long calDate = d1.getTime() - d2.getTime(); 
		        
		        // Date.getTime() 은 해당날짜를 기준으로1970년 00:00:00 부터 몇 초가 흘렀는지를 반환해준다. 
		        // 이제 24*60*60*1000(각 시간값에 따른 차이점) 을 나눠주면 일수가 나온다.
		        int calDateDays = (int) (calDate / ( 24*60*60*1000)); 
		 
		        calDateDays = Math.abs(calDateDays);

			int compare =d1.compareTo(d3);
			int compare1 =d2.compareTo(d3);
			
			int s_total = skiprice * calDateDays;
			
			
			sbean.setMemberpass(memberpass);
			sbean.setProduct_skiprice(s_total);
			//데이터 베이스 객체
			SkiDAO sdao = new SkiDAO();
			sdao.SkiOrderUpdate(sbean);
			
			request.setAttribute("sbean", sbean);
			RequestDispatcher dis = request.getRequestDispatcher("/SkiListController1.do");
			dis.forward(request, response);
			
			
		}

}
