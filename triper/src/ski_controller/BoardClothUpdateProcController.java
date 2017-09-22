package ski_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ski_db.BoardClothOrder;
import ski_db.BoardDAO;

/**
 * Servlet implementation class BoardClothUpdateProcController
 */
@WebServlet("/BoardClothUpdateProcController.do")
public class BoardClothUpdateProcController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}
	protected void requestpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	      response.setContentType("text/html;charset=UTF-8");
		
		int bl_orderid = Integer.parseInt(request.getParameter("bl_orderid"));
		String boardclothbeginday = request.getParameter("boardclothbeginday");
		String boardclothendnday = request.getParameter("boardclothendnday");
		String boardclothsize = request.getParameter("boardclothsize");
		String memberpass = request.getParameter("memberpass");
		
		
		BoardClothOrder bcbean = new BoardClothOrder();
		bcbean.setBl_orderid(bl_orderid);
		bcbean.setBoardclothbeginday(boardclothbeginday);
		bcbean.setBoardclothendnday(boardclothendnday);
		bcbean.setBoardclothsize(boardclothsize);
		bcbean.setMemberpass(memberpass);
		
		
		BoardDAO bdao = new BoardDAO();
		bdao.BoardClothupdate(bcbean);
		
		request.setAttribute("bbean", bcbean);
		RequestDispatcher dis = request.getRequestDispatcher("/BoardListController.do");
		dis.forward(request, response);
		
		
	}

}
