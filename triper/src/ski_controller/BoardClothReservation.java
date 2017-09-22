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
 * Servlet implementation class BoardClothReservation
 */
@WebServlet("/BoardClothReservation.do")
public class BoardClothReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}
	protected void requestpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardclothbeginday=request.getParameter("boardclothbeginday");
		String boardclothendnday=request.getParameter("boardclothendnday");
		String boardclothsize=request.getParameter("boardclothsize");
		int boardclothno =Integer.parseInt(request.getParameter("boardclothno"));
		String product_boardclothname=request.getParameter("product_boardclothname");
		int boardclothprice =Integer.parseInt(request.getParameter("boardclothprice"));
		String product_boardclothimg = request.getParameter("product_boardclothimg");
		
		int total = boardclothprice;
		
		BoardClothOrder bean = new BoardClothOrder();
		bean.setBoardclothbeginday(boardclothbeginday);
		bean.setBoardclothendnday(boardclothendnday);
		bean.setBoardclothsize(boardclothsize);
		bean.setProduct_boardclothno(Integer.parseInt(request.getParameter("boardclothno")));
		bean.setProduct_boardclothname(product_boardclothname);
		bean.setProduct_boardclothprice(Integer.parseInt(request.getParameter("boardclothprice")));
		bean.setProduct_boardclothimg(product_boardclothimg);
		request.setAttribute("bean", bean);
		request.setAttribute("total", total);
	
	
		
		
		RequestDispatcher dis = request.getRequestDispatcher("/_ski/SkiMain.jsp?center=BoardClothReserve.jsp");
		dis.forward(request, response);
		
	}


}
