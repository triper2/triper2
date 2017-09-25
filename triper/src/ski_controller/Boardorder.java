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
@WebServlet("/BoardOrder.do")
public class Boardorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}
	protected void requestpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardOrder bean =  new BoardOrder();
		
		bean.setBoardbeginday(request.getParameter("boardbeginday"));
		bean.setBoardendday(request.getParameter("boardendday"));
		bean.setBoardsize(request.getParameter("boardsize"));
		bean.setProduct_boardno(Integer.parseInt(request.getParameter("product_boardno")));
		bean.setProduct_boardname(request.getParameter("product_boardname"));
		bean.setProduct_boardprice(Integer.parseInt(request.getParameter("product_boardprice")));
		bean.setProduct_boardimg(request.getParameter("product_boardimg"));
		bean.setMemberphone(request.getParameter("memberphone"));
		bean.setMemberpass(request.getParameter("memberpass"));
		
		BoardDAO dao = new BoardDAO();
		
		dao.insertBoardorder(bean);
		
		RequestDispatcher dis = request.getRequestDispatcher("BoardListController.do");
		dis.forward(request, response);
		
	}

}
