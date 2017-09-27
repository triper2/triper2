package car_controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car_db.CarOrderBean;
import kosta.rental.loginModel.RentalDTO;


@WebServlet("/_car/CarOptionController.do")
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
	      
	      
	      String member_id = null;
	         
	         
	         try {
	            RentalDTO dto = (RentalDTO)request.getSession().getAttribute("dto");
	            member_id = dto.getMember_id();
	         } catch (Exception e) {
	            member_id = null;
	         }
	         
	         if (member_id == null) {
	        	 System.out.println("여긴오니???");
	            PrintWriter script;
	            try {
	               script = response.getWriter();
	               script.println("<script>");
	               script.println("alert('로그인을 하세요')");
	               script.println("location.href = '/triper/_main_login/loginForm.jsp'");
	               script.println("</script>");
	            } catch (IOException e) {
	               // TODO Auto-generated catch block
	               e.printStackTrace();
	            }

	         }else{
	      
	      
//	      String member_id=null;
//	       member_id = ((RentalDTO)request.getSession().getAttribute("dto")).getMember_id();
//	      System.out.println(member_id);
//	      if(member_id!=null){
//	    	  PrintWriter script;
//	            try {
//	               script = response.getWriter();
//	               script.println("<script>");
//	               script.println("alert('로그인을 하세요')");
//	               script.println("location.href = '/triper/_main_login/loginForm.jsp'");
//	               script.println("</script>");
//	            } catch (IOException e) {
//	               // TODO Auto-generated catch block
//	               e.printStackTrace();
//	            }
//	      }
//	      
	      
	      String business_id = request.getParameter("business_id");
		
		//�ݾ� ������ ������ �����͸� ������ �޾���
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
		
		
		
	
		
		
		/*������ ��� CarOrder.jsp�� �����͸� �Ѱ���
		�������� = ���� * �뿩�Ⱓ * ��������
		
		int totalreserve =carqty *  (DateFormat. carenddate-carbegindate) * carprice;
		int totalreserve =carqty *  carprice;
		�ɼǱݾ� = ���� �ɼ��� �뿩�Ⱓ�� ������ ���ؼ�
		int totaloption = (carins*(carenddate-carbegindate))+(carwifi*(carenddate-carbegindate))
					+(carbabyseat*(carenddate-carbegindate))*10000 * carqty;
		int totaloption =  carqty;*/
		
		//jsp ������ ���õ����� ��� �Ѱ���
		//carorderbean Ŭ������
		
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
		
		//��¥ ��
		
		Date d1=new Date();
		Date d2=new Date();
		Date d3=new Date();
		//��¥�� 2016-4-4 ���� ���ִ� Ŭ���� ����
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		
		d1=sdf.parse(cbean.getReserved_carbegindate());
		d2=sdf.parse(cbean.getReserved_carenddate());
		d3=sdf.parse(sdf.format(d3));
		
		//��¥ �� �޼ҵ带 ���
		 long calDate = d1.getTime() - d2.getTime(); 
	        
	        // Date.getTime() �� �ش糯¥�� ��������1970�� 00:00:00 ���� �� �ʰ� �귶������ ��ȯ���ش�. 
	        // ���� 24*60*60*1000(�� �ð����� ���� ������) �� �����ָ� �ϼ��� ���´�.
	        int calDateDays = (int) (calDate / ( 24*60*60*1000)); 
	 
	        calDateDays = Math.abs(calDateDays);

		int compare =d1.compareTo(d3);
		int compare1 =d2.compareTo(d3);
		//�����Ϸ��� ��¥���� ���糯¥�� ũ�ٸ� -1
		//�����Ϸ��� ��¥�� ���糯¥�� ���ٸ� 0
		//�����Ϸ��� ��¥�� �� ũ�ٸ� 1�� ����

		//������ ��� CarOrder.jsp�� �����͸� �Ѱ���
		//�������� = ���� * �뿩�Ⱓ * ��������
		
		/*int totalreserve =carqty *  (DateFormat. carenddate-carbegindate) * carprice;*/
		int totalreserve =(int) (carqty *  carprice * calDateDays);
		//�ɼǱݾ� = ���� �ɼ��� �뿩�Ⱓ�� ������ ���ؼ�
		int totaloption = (int) ((carins+carwifi+carbabyseat)*calDateDays*10000 * carqty);
		int totalprice = totalreserve + totaloption;
		
		//jsp ������ ���õ����� ��� �Ѱ���
		//carorderbean Ŭ������
		cbean.setTotalprice(totalprice);
		cbean.setCalDateDays(calDateDays);
		System.out.println(totalprice);
		//carOrder.jsp ������ �ѱ�
		request.setAttribute("member_id", member_id);
		request.setAttribute("cbean", cbean);
		request.setAttribute("totalreserve", totalreserve);
		request.setAttribute("totaloption", totaloption);
		request.setAttribute("compare",compare);
		request.setAttribute("compare1",compare1);
		request.setAttribute("calDateDays", calDateDays);
	
		RequestDispatcher dis = request.getRequestDispatcher("/_car/CarMain.jsp?center=CarOrder.jsp&top=_Top.jsp&business_id="+business_id);
		dis.forward(request, response);
	}
	}
}
