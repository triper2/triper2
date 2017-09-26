package ski_controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		try {
			requestpro(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			requestpro(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void requestpro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
	      response.setContentType("text/html;charset=UTF-8");
		
		int bl_orderid = Integer.parseInt(request.getParameter("bl_orderid"));
		String boardclothbeginday = request.getParameter("boardclothbeginday");
		String boardclothendnday = request.getParameter("boardclothendnday");
		String boardclothsize = request.getParameter("boardclothsize");
		String memberpass = request.getParameter("memberpass");
		int boardclothprice = Integer.parseInt(request.getParameter("boardclothprice"));
		
		BoardClothOrder bcbean = new BoardClothOrder();
		bcbean.setBl_orderid(bl_orderid);
		bcbean.setBoardclothbeginday(boardclothbeginday);
		bcbean.setBoardclothendnday(boardclothendnday);
		bcbean.setBoardclothsize(boardclothsize);
		bcbean.setMemberpass(memberpass);
		//��¥ ��
		
				Date d1=new Date();
				Date d2=new Date();
				Date d3=new Date();
				//��¥�� 2016-4-4 ���� ���ִ� Ŭ���� ����
				SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
				
				d1=sdf.parse(bcbean.getBoardclothbeginday());
				d2=sdf.parse(bcbean.getBoardclothendnday());
				d3=sdf.parse(sdf.format(d3));
				
				//��¥ �� �޼ҵ带 ���
				 long calDate = d1.getTime() - d2.getTime(); 
			        
			        // Date.getTime() �� �ش糯¥�� ��������1970�� 00:00:00 ���� �� �ʰ� �귶������ ��ȯ���ش�. 
			        // ���� 24*60*60*1000(�� �ð����� ���� ������) �� �����ָ� �ϼ��� ���´�.
			        int calDateDays = (int) (calDate / ( 24*60*60*1000)); 
			 
			        calDateDays = Math.abs(calDateDays);

				int compare =d1.compareTo(d3);
				int compare1 =d2.compareTo(d3);
				
				int bc_total = boardclothprice * calDateDays;
				bcbean.setProduct_boardclothprice(bc_total);
		
		BoardDAO bdao = new BoardDAO();
		bdao.BoardClothupdate(bcbean);
		
		request.setAttribute("bbean", bcbean);
		RequestDispatcher dis = request.getRequestDispatcher("/BoardListController.do");
		dis.forward(request, response);
		
		
	}

}
