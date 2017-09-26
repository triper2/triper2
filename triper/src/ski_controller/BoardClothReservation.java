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

import ski_db.BoardClothOrder;
import ski_db.BoardDAO;


/**
 * Servlet implementation class BoardClothReservation
 */
@WebServlet("/BoardClothReservation.do")
public class BoardClothReservation extends HttpServlet {
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
		String boardclothbeginday=request.getParameter("boardclothbeginday");
		String boardclothendnday=request.getParameter("boardclothendnday");
		String boardclothsize=request.getParameter("boardclothsize");
		int boardclothno =Integer.parseInt(request.getParameter("boardclothno"));
		String product_boardclothname=request.getParameter("product_boardclothname");
		int boardclothprice =Integer.parseInt(request.getParameter("boardclothprice"));
		String product_boardclothimg = request.getParameter("product_boardclothimg");
		
		
		
		BoardClothOrder bean = new BoardClothOrder();
		bean.setBoardclothbeginday(boardclothbeginday);
		bean.setBoardclothendnday(boardclothendnday);
		bean.setBoardclothsize(boardclothsize);
		bean.setProduct_boardclothno(Integer.parseInt(request.getParameter("boardclothno")));
		bean.setProduct_boardclothname(product_boardclothname);
		bean.setProduct_boardclothprice(Integer.parseInt(request.getParameter("boardclothprice")));
		bean.setProduct_boardclothimg(product_boardclothimg);
		
		//날짜 비교
		
		Date d1=new Date();
		Date d2=new Date();
		Date d3=new Date();
		//날짜를 2016-4-4 포맷 해주는 클래스 선언
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		
		d1=sdf.parse(bean.getBoardclothbeginday());
		d2=sdf.parse(bean.getBoardclothendnday());
		d3=sdf.parse(sdf.format(d3));
		
		//날짜 비교 메소드를 사용
		 long calDate = d1.getTime() - d2.getTime(); 
	        
	        // Date.getTime() 은 해당날짜를 기준으로1970년 00:00:00 부터 몇 초가 흘렀는지를 반환해준다. 
	        // 이제 24*60*60*1000(각 시간값에 따른 차이점) 을 나눠주면 일수가 나온다.
	        int calDateDays = (int) (calDate / ( 24*60*60*1000)); 
	 
	        calDateDays = Math.abs(calDateDays);

		int compare =d1.compareTo(d3);
		int compare1 =d2.compareTo(d3);
		
		int bc_total = boardclothprice * calDateDays;
		request.setAttribute("bean", bean);
		request.setAttribute("bc_total", bc_total);
		request.setAttribute("compare",compare);
		request.setAttribute("compare1",compare1);
		request.setAttribute("calDateDays", calDateDays);
	
	
		
		
		RequestDispatcher dis = request.getRequestDispatcher("/_ski/SkiMain.jsp?center=BoardClothReserve.jsp");
		dis.forward(request, response);
		
	}


}
