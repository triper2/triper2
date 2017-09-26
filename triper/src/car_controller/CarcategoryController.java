package car_controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car_db.CarDAO;
import car_db.CarListBean;

/**
 * Servlet implementation class CarcategoryController
 */
@WebServlet("/_car/CarcategoryController.do")
public class CarcategoryController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request,response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request,response);
	}
	private void requestpro(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException  {
		
		String uri = request.getRequestURI();
	      String conPath = request.getContextPath();
	      String com = uri.substring(conPath.length());
	      
	      String business_id = request.getParameter("business_id");
	      
		request.setCharacterEncoding("UTF-8");
	      response.setContentType("text/html;charset=UTF-8");
		String carcategory = request.getParameter("carcategory");
		
		CarDAO dao=new CarDAO();
		
		Vector<CarListBean> v = dao.getCategoryCarList(carcategory, business_id);
		
		request.setAttribute("v",v);
		RequestDispatcher dis = request.getRequestDispatcher("/_car/CarMain.jsp?center=CarList.jsp&top=_Top.jsp&business_id="+business_id);
		dis.forward(request, response);
	}

}
