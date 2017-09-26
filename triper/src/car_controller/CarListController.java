package car_controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.jrockit.jfr.RequestDelegate;

import car_db.CarDAO;
import car_db.CarListBean;

/**
 * Servlet implementation class CarListController
 */
@WebServlet("/CarListController.do")
public class CarListController extends HttpServlet {
	//전체 차량 보기 클래스입니다.
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request,response);
	}
	//doGet,doPost 방식으로 데이터가 넘어오던 모두 requestpro메소드에서 처리
	private void requestpro(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException  {
		
		String uri = request.getRequestURI();
	      String conPath = request.getContextPath();
	      String com = uri.substring(conPath.length());
	      
	      System.out.println(uri);
	      System.out.println(conPath);
	      System.out.println(com);
		request.setCharacterEncoding("UTF-8");
	      response.setContentType("text/html;charset=UTF-8");
		
		
		//데이터 베이스에 접근하기위한 Model클래스를 생성
		CarDAO cdao = new CarDAO();
		//실제 데이터 베이스에 접근하여 자동차 정보를 모두 읽어서 백터에 저장
		Vector<CarListBean> v = cdao.getAllCarlist();
		
		//화면에 보여질 뷰페이지로 이동시킴 - request객체 담아서 보내줍니다.
		request.setAttribute("v", v);
		
		System.out.println();
		RequestDispatcher dis = request.getRequestDispatcher("./_car/CarMain.jsp?center=CarList.jsp&top=_Top.jsp");
		
		//데이터를 넘겨주시오
		dis.forward(request, response);
	}

}






