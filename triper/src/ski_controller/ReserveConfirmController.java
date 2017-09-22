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
		//����ڷ� ���� �Ѿ�� ��ȭ��ȣ�� ��й�ȣ�� �о�帲
		String memberphone=request.getParameter("memberphone");
		String memberpass = request.getParameter("memberpass");
		
		
	////////////////////////////////////����//////////////////////////////////	
		//������ ���̽� ��ü����
		BoardDAO bdao = new BoardDAO();
		
		//carconfirmbean Ÿ������ �� ������ Ŭ���� ����
		Vector<BoardOrder> bv = bdao.getAllBoardOrder(memberphone, memberpass);
		
	
		
	////////////////////////////���庹//////////////////////////////////////////
		//������ ���̽� ��ü����
		BoardDAO bcdao = new BoardDAO();
		
		//carconfirmbean Ÿ������ �� ������ Ŭ���� ����
		Vector<BoardClothOrder> bcv = bcdao.getAllBoardClothOrder(memberphone, memberpass);
		
		
	///////////////////////////////��Ű/////////////////////////////////////////	
		//������ ���̽� ��ü����
		SkiDAO sdao = new SkiDAO();
		
		//carconfirmbean Ÿ������ �� ������ Ŭ���� ����
		Vector<Skiorder1> sv = sdao.getAllSkiOrder(memberphone, memberpass);
		
		
		///////////////////////////��Ű��////////////////////////////////////
		//������ ���̽� ��ü����
		SkiDAO scdao = new SkiDAO();
		
		//carconfirmbean Ÿ������ �� ������ Ŭ���� ����
		Vector<SkiClothOrder> scv = sdao.getAllSkiClothOrder(memberphone, memberpass);
		
		
		
	///////////////////////////////////////////////////////////////////////
		//jsp�� ������ �Ѱ��־���ϱ⿡ request��ü
		request.setAttribute("bv", bv);

		//jsp�� ������ �Ѱ��־���ϱ⿡ request��ü
		request.setAttribute("bcv", bcv);
		//jsp�� ������ �Ѱ��־���ϱ⿡ request��ü
			request.setAttribute("sv", sv);
		//jsp�� ������ �Ѱ��־���ϱ⿡ request��ü
		request.setAttribute("scv", scv);
			
		
		RequestDispatcher dis = request.getRequestDispatcher("/_ski/SkiMain.jsp?center=ReserveResult.jsp");
		dis.forward(request, response);
	
	}

}
