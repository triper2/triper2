package ski_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ski_db.BoardDAO;
import ski_db.BoardOrder;


@WebServlet("/BoardUpdateProcController.do")
public class BoardUpdateProcController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}
	protected void requestpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	      response.setContentType("text/html;charset=UTF-8");
		
		int b_orderid = Integer.parseInt(request.getParameter("b_orderid"));
		String boardbeginday = request.getParameter("boardbeginday");
		String boardendday = request.getParameter("boardendday");
		String boardsize = request.getParameter("boardsize");
		String memberpass = request.getParameter("memberpass");
		
		
		BoardOrder bbean = new BoardOrder();
		bbean.setB_orderid(b_orderid);
		bbean.setBoardbeginday(boardbeginday);
		bbean.setBoardendday(boardendday);
		bbean.setBoardsize(boardsize);
		bbean.setMemberpass(memberpass);
		
		
		BoardDAO bdao = new BoardDAO();
		bdao.Boardupdate(bbean);
		
		request.setAttribute("bbean", bbean);
		RequestDispatcher dis = request.getRequestDispatcher("/BoardListController.do");
		dis.forward(request, response);
		
		
	}

}
