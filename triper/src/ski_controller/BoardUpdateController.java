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

/**
 * Servlet implementation class BoardUpdateController
 */
@WebServlet("/BoardUpdateController.do")
public class BoardUpdateController extends HttpServlet {
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
		
		int b_orderid = Integer.parseInt(request.getParameter("b_orderid"));
		String boardimg = request.getParameter("boardimg");
		
		BoardDAO bdao = new BoardDAO();
		BoardOrder bbean = bdao.getBoardOneOrder(b_orderid);
		
		bbean.setProduct_boardimg(boardimg);
		
		request.setAttribute("bbean", bbean);
		
		RequestDispatcher dis = request.getRequestDispatcher("/_ski/SkiMain.jsp?center=BoardUpdate.jsp");
		dis.forward(request, response);
		
	}

}
