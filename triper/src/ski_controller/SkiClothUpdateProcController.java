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
import ski_db.SkiDAO;

/**
 * Servlet implementation class SkiClothUpdateProcController
 */
@WebServlet("/SkiClothUpdateProcController.do")
public class SkiClothUpdateProcController extends HttpServlet {
	
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
		int sc_orderid=Integer.parseInt(request.getParameter("sc_orderid"));
		String skiclothimg = request.getParameter("skiclothimg");
		String skiclothbeginday = request.getParameter("skiclothbeginday");
		String skiclothendday= request.getParameter("skiclothendday");
		String skiclothsize = request.getParameter("skiclothsize");
		
		String memberpass = request.getParameter("memberpass");
		int skiclothprice = Integer.parseInt(request.getParameter("skiclothprice"));
		
		SkiClothOrder scbean = new SkiClothOrder();
		scbean.setSc_orderid(sc_orderid);
		scbean.setSkiclothbeginday(skiclothbeginday);
		scbean.setSkiclothendday(skiclothendday);
		scbean.setSkiclothsize(skiclothsize);
		scbean.setMemberpass(memberpass);
		
		//��¥ ��
		
		Date d1=new Date();
		Date d2=new Date();
		Date d3=new Date();
		//��¥�� 2016-4-4 ���� ���ִ� Ŭ���� ����
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		
		d1=sdf.parse(scbean.getSkiclothbeginday());
		d2=sdf.parse(scbean.getSkiclothendday());
		d3=sdf.parse(sdf.format(d3));
		
		//��¥ �� �޼ҵ带 ���
		 long calDate = d1.getTime() - d2.getTime(); 
	        
	        // Date.getTime() �� �ش糯¥�� ��������1970�� 00:00:00 ���� �� �ʰ� �귶������ ��ȯ���ش�. 
	        // ���� 24*60*60*1000(�� �ð����� ���� ������) �� �����ָ� �ϼ��� ���´�.
	        int calDateDays = (int) (calDate / ( 24*60*60*1000)); 
	 
	        calDateDays = Math.abs(calDateDays);

		int compare =d1.compareTo(d3);
		int compare1 =d2.compareTo(d3);
		
		int sc_total = skiclothprice * calDateDays;
		scbean.setProduct_skiclothprice(sc_total);
		
		
		SkiDAO sdao = new SkiDAO();
		
		sdao.Skiclothupdate(scbean);
		
		request.setAttribute("scbean", scbean);
		RequestDispatcher dis = request.getRequestDispatcher("/SkiClothListController.do");
		dis.forward(request, response);
		
	}
}
