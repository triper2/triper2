package car_controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car_db.CarConfirmBean;
import car_db.CarDAO;


@WebServlet("/CarReserveConfirmController.do")
public class CarReserveConfirmController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}
	protected void requestpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
	      response.setContentType("text/html;charset=UTF-8");
		//사용자로 부터 넘어온 전화번호와 비밀번호를 읽어드림
		String memberphone=request.getParameter("memberphone");
		String memberpass = request.getParameter("memberpass");
		
		//데이터 베이스 객체선언
		CarDAO cdao = new CarDAO();
		
		//carconfirmbean 타입으로 된 베ㄱ터 클래스 선언
		Vector<CarConfirmBean> v = cdao.getAllCarOrder(memberphone, memberpass);
		
		//jsp로 데이터 넘겨주어야하기에 request객체
		request.setAttribute("v", v);
		RequestDispatcher dis = request.getRequestDispatcher("/_car/CarMain.jsp?center=CarReserveResult.jsp&top=_Top.jsp");
		dis.forward(request, response);
	
	}

}
