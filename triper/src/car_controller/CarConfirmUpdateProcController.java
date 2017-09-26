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
@WebServlet("/_car/CarConfirmUpdateProcController.do")
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
	      
	      String business_id = request.getParameter("business_id");
		//����ڷκ��� �Ѿ�� �����͸� �Է�
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
		//carorderbean Ŭ���� �̿��Ͽ� �����͸� ���� �� ��Ŭ������ DAO
		CarOrderBean bean = new CarOrderBean();
		
		bean.setOrderid(orderid);
		bean.setReserved_product_count(carqty);
		bean.setReserved_option_carwifi(carwifi);
		//��¥ ��
		bean.setReserved_carbegindate(reserved_carbegindate);
		bean.setReserved_carenddate(reserved_carenddate);
		Date d1=new Date();
		Date d2=new Date();
		Date d3=new Date();
		//��¥�� 2016-4-4 ���� ���ִ� Ŭ���� ����
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		
		d1=sdf.parse(bean.getReserved_carbegindate());
		d2=sdf.parse(bean.getReserved_carenddate());
		d3=sdf.parse(sdf.format(d3));
		
		//��¥ �� �޼ҵ带 ���
		 long calDate = d1.getTime() - d2.getTime(); 
	        
	        // Date.getTime() �� �ش糯¥�� ��������1970�� 00:00:00 ���� �� �ʰ� �귶������ ��ȯ���ش�. 
	        // ���� 24*60*60*1000(�� �ð����� ���� ������) �� �����ָ� �ϼ��� ���´�.
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
		//������ ���̽� ��ü
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
		RequestDispatcher dis = request.getRequestDispatcher("/_car/CarListController.do?business_id="+business_id);
		dis.forward(request, response);
		
		
	}

}
