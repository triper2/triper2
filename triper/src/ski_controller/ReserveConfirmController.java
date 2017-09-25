package ski_controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ski_db.BoardClothOrder;
import ski_db.BoardDAO;
import ski_db.BoardOrder;
import ski_db.SkiClothOrder;
import ski_db.SkiDAO;
import ski_db.Skiorder1;

/**
 * Servlet implementation class ReserveConfirmController
 */
@WebServlet("/ReserveConfirmController.do")
public class ReserveConfirmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
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
		
		
	////////////////////////////////////보드//////////////////////////////////	
		//데이터 베이스 객체선언
		BoardDAO bdao = new BoardDAO();
		
		//carconfirmbean 타입으로 된 베ㄱ터 클래스 선언
		Vector<BoardOrder> bv = bdao.getAllBoardOrder(memberphone, memberpass);
		
	
		
	////////////////////////////보드복//////////////////////////////////////////
		//데이터 베이스 객체선언
		BoardDAO bcdao = new BoardDAO();
		
		//carconfirmbean 타입으로 된 베ㄱ터 클래스 선언
		Vector<BoardClothOrder> bcv = bcdao.getAllBoardClothOrder(memberphone, memberpass);
		
		
	///////////////////////////////스키/////////////////////////////////////////	
		//데이터 베이스 객체선언
		SkiDAO sdao = new SkiDAO();
		
		//carconfirmbean 타입으로 된 베ㄱ터 클래스 선언
		Vector<Skiorder1> sv = sdao.getAllSkiOrder(memberphone, memberpass);
		
		
		///////////////////////////스키복////////////////////////////////////
		//데이터 베이스 객체선언
		SkiDAO scdao = new SkiDAO();
		
		//carconfirmbean 타입으로 된 베ㄱ터 클래스 선언
		Vector<SkiClothOrder> scv = sdao.getAllSkiClothOrder(memberphone, memberpass);
		
		
		
	///////////////////////////////////////////////////////////////////////
		//jsp로 데이터 넘겨주어야하기에 request객체
		request.setAttribute("bv", bv);

		//jsp로 데이터 넘겨주어야하기에 request객체
		request.setAttribute("bcv", bcv);
		//jsp로 데이터 넘겨주어야하기에 request객체
			request.setAttribute("sv", sv);
		//jsp로 데이터 넘겨주어야하기에 request객체
		request.setAttribute("scv", scv);
			
		
		RequestDispatcher dis = request.getRequestDispatcher("/_ski/SkiMain.jsp?center=ReserveResult.jsp");
		dis.forward(request, response);
	
	}

}
