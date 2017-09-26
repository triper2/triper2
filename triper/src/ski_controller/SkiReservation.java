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

import ski_db.SkiOrder;
import ski_db.Skiorder1;


@WebServlet("/SkiReservation.do")
public class SkiReservation extends HttpServlet {
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
		String skibeginday=request.getParameter("skibeginday");
		String skiendday=request.getParameter("skiendday");
		String skisize=request.getParameter("skisize");
		int skino =Integer.parseInt(request.getParameter("skino"));
		String product_skiname=request.getParameter("product_skiname");
		int skiprice =Integer.parseInt(request.getParameter("skiprice"));
		String product_skiimg = request.getParameter("product_skiimg");
		
		
		
		Skiorder1 bean = new Skiorder1();
		bean.setSkibeginday(skibeginday);
		bean.setSkiendday(skiendday);
		bean.setSkisize(skisize);
		bean.setProduct_skino(Integer.parseInt(request.getParameter("skino")));
		bean.setProduct_skiname(product_skiname);
		bean.setProduct_skiprice(Integer.parseInt(request.getParameter("skiprice")));
		bean.setProduct_skiimg(product_skiimg);
		
		//��¥ ��
		
		Date d1=new Date();
		Date d2=new Date();
		Date d3=new Date();
		//��¥�� 2016-4-4 ���� ���ִ� Ŭ���� ����
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		
		d1=sdf.parse(bean.getSkibeginday());
		d2=sdf.parse(bean.getSkiendday());
		d3=sdf.parse(sdf.format(d3));
		
		//��¥ �� �޼ҵ带 ���
		 long calDate = d1.getTime() - d2.getTime(); 
	        
	        // Date.getTime() �� �ش糯¥�� ��������1970�� 00:00:00 ���� �� �ʰ� �귶������ ��ȯ���ش�. 
	        // ���� 24*60*60*1000(�� �ð����� ���� ������) �� �����ָ� �ϼ��� ���´�.
	        int calDateDays = (int) (calDate / ( 24*60*60*1000)); 
	 
	        calDateDays = Math.abs(calDateDays);

		int compare =d1.compareTo(d3);
		int compare1 =d2.compareTo(d3);
		int s_total = skiprice * calDateDays;
		
		
		request.setAttribute("bean", bean);
		request.setAttribute("s_total", s_total);
		request.setAttribute("compare",compare);
		request.setAttribute("compare1",compare1);
		request.setAttribute("calDateDays", calDateDays);
	
	
		
		
		RequestDispatcher dis = request.getRequestDispatcher("/_ski/SkiMain.jsp?center=SkiReserve.jsp");
		dis.forward(request, response);
		
	}

}
