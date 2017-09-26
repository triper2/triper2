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

import ski_db.BoardDAO;
import ski_db.BoardOrder;


@WebServlet("/BoardUpdateProcController.do")
public class BoardUpdateProcController extends HttpServlet {
	
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
		
		int b_orderid = Integer.parseInt(request.getParameter("b_orderid"));
		String boardbeginday = request.getParameter("boardbeginday");
		String boardendday = request.getParameter("boardendday");
		String boardsize = request.getParameter("boardsize");
		String memberpass = request.getParameter("memberpass");
		int boardprice = Integer.parseInt(request.getParameter("boardprice"));
		
		BoardOrder bbean = new BoardOrder();
		bbean.setB_orderid(b_orderid);
		bbean.setBoardbeginday(boardbeginday);
		bbean.setBoardendday(boardendday);
		//��¥ ��
		
		Date d1=new Date();
		Date d2=new Date();
		Date d3=new Date();
		//��¥�� 2016-4-4 ���� ���ִ� Ŭ���� ����
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		
		d1=sdf.parse(bbean.getBoardbeginday());
		d2=sdf.parse(bbean.getBoardendday());
		d3=sdf.parse(sdf.format(d3));
		
		//��¥ �� �޼ҵ带 ���
		 long calDate = d1.getTime() - d2.getTime(); 
	        
	        // Date.getTime() �� �ش糯¥�� ��������1970�� 00:00:00 ���� �� �ʰ� �귶������ ��ȯ���ش�. 
	        // ���� 24*60*60*1000(�� �ð����� ���� ������) �� �����ָ� �ϼ��� ���´�.
	        int calDateDays = (int) (calDate / ( 24*60*60*1000)); 
	 
	        calDateDays = Math.abs(calDateDays);

		int compare =d1.compareTo(d3);
		int compare1 =d2.compareTo(d3);
		
		int b_total = boardprice * calDateDays;
		bbean.setBoardsize(boardsize);
		bbean.setMemberpass(memberpass);
		bbean.setProduct_boardprice(b_total);
		
		BoardDAO bdao = new BoardDAO();
		bdao.Boardupdate(bbean);
		
		request.setAttribute("bbean", bbean);
		RequestDispatcher dis = request.getRequestDispatcher("/BoardListController.do");
		dis.forward(request, response);
		
		
	}

}
