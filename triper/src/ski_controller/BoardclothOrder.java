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
 * Servlet implementation class BoardclothOrder
 */
@WebServlet("/BoardclothOrder.do")
public class BoardclothOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}
	protected void requestpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		BoardClothOrder bean = new BoardClothOrder();
		
	bean.setBoardclothbeginday(request.getParameter("boardclothbeginday"));
	bean.setBoardclothendnday(request.getParameter("boardclothendnday"));
	bean.setBoardclothsize(request.getParameter("boardclothsize"));
	bean.setProduct_boardclothno(Integer.parseInt(request.getParameter("product_boardclothno")));
	bean.setProduct_boardclothname(request.getParameter("product_boardclothname"));
	bean.setProduct_boardclothprice(Integer.parseInt(request.getParameter("product_boardclothprice")));
	bean.setProduct_boardclothimg(request.getParameter("product_boardclothimg"));
	bean.setMemberphone(request.getParameter("memberphone"));
	bean.setMemberpass(request.getParameter("memberpass"));
	
	BoardDAO dao = new BoardDAO();
	
	dao.insertBoardclothOrder(bean);
	
	RequestDispatcher dis = request.getRequestDispatcher("BoardClothListController.do");
	dis.forward(request, response);
	}
	
}
