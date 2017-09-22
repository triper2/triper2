package ski_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ski_db.BoardOrder;

/**
 * Servlet implementation class BoardReservation
 */
@WebServlet("/BoardReservation.do")
public class BoardReservation extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
		}
		protected void requestpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String boardbeginday=request.getParameter("boardbeginday");
			String boardendday=request.getParameter("boardendday");
			String boardsize=request.getParameter("boardsize");
			int boardno =Integer.parseInt(request.getParameter("boardno"));
			String product_boardname=request.getParameter("product_boardname");
			int boardprice =Integer.parseInt(request.getParameter("boardprice"));
			String product_boardimg = request.getParameter("product_boardimg");
			
			int total = boardprice;
			
			BoardOrder bean = new BoardOrder();
			bean.setBoardbeginday(boardbeginday);
			bean.setBoardendday(boardendday);
			bean.setBoardsize(boardsize);
			bean.setProduct_boardno(Integer.parseInt(request.getParameter("boardno")));
			bean.setProduct_boardname(product_boardname);
			bean.setProduct_boardprice(Integer.parseInt(request.getParameter("boardprice")));
			bean.setProduct_boardimg(product_boardimg);
			request.setAttribute("bean", bean);
			request.setAttribute("total", total);
		
		
			
			
			RequestDispatcher dis = request.getRequestDispatcher("/_ski/SkiMain.jsp?center=BoardReserve.jsp");
			dis.forward(request, response);
			
		}

}
