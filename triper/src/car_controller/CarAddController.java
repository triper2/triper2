package car_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import car_db.CarDAO;
import car_db.CarListBean;

@WebServlet("/_car/CarAddController.do")
public class CarAddController extends HttpServlet {
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
	      String business_id = request.getParameter("business_id");
	      MultipartRequest multi = Fileutil.createFile(request);
	         String product_carimg = multi.getFilesystemName("product_carimg");
	     
	         CarListBean cbean = new CarListBean();
	         System.out.println(business_id+"asd");
			cbean.setProduct_carno(Integer.parseInt(multi.getParameter("product_carno")));

			cbean.setProduct_carname(multi.getParameter("product_carname")); 
			cbean.setProduct_carcompany(multi.getParameter("product_carcompany")); 
			cbean.setProduct_carprice(Integer.parseInt(multi.getParameter("product_carprice")));
			cbean.setProduct_carusepeople(Integer.parseInt(multi.getParameter("product_carusepeople")));
			cbean.setProduct_carinfo(multi.getParameter("product_carinfo")); 
			cbean.setProduct_carimg(Fileutil.rename(multi.getFilesystemName("product_carimg")));
			cbean.setProduct_carcategory(multi.getParameter("product_carcategory"));
			cbean.setBusiness_id(multi.getParameter("business_id"));

		
		CarDAO cdao = new CarDAO();
		//�ֹ� ��Ȳ�� ����
		cdao.insertCarAdd(cbean);
		RequestDispatcher dis =request.getRequestDispatcher("/_car/CarListController.do?business_id="+business_id);
		dis.forward(request, response);
	}

}
