package ski_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ski_db.BoardDAO;
import ski_db.SkiDAO;


@WebServlet("/ConfirmDeleteController.do")
public class ConfirmDeleteController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
		
		}
		private void requestpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			
			request.setCharacterEncoding("UTF-8");
		      response.setContentType("text/html;charset=UTF-8");
			//����ڷ� ���� �Է�
		    
			int s_orderid= Integer.parseInt(request.getParameter("s_orderid"));
			int sc_orderid = Integer.parseInt(request.getParameter("sc_orderid"));
			int b_orderid = Integer.parseInt(request.getParameter("b_orderid"));
			int bl_orderid = Integer.parseInt(request.getParameter("bl_orderid"));
			String memberpass = request.getParameter("memberpass");
			
			//������ ���̽� ��ü�� ����
			///////////////��Ű
			SkiDAO sdao = new SkiDAO();
			
			int result = sdao.SkiOrderDelete(s_orderid,memberpass);
			/////////////��Ű��
			SkiDAO scdao = new SkiDAO();
			int result1 = scdao.Skiclothdelete(sc_orderid,memberpass);
			/////////////����
			BoardDAO bdao = new BoardDAO();
			int result2= bdao.BoardDelete(b_orderid,memberpass);
			///////////���� ��
			BoardDAO bcdao = new BoardDAO();
			int result3 = bcdao.BoardclothDelete(bl_orderid,memberpass);
			
			
			if(result!=0 || result1!=0 || result2!=0 || result3!=0){//1. ������ ����� ����Ǿ��ٸ�
				RequestDispatcher dis = 
					request.getRequestDispatcher("/_ski/SkiMain.jsp");
				dis.forward(request, response);
			}else{//������ ����� ������� �ʾҴٸ� = password�� Ʋ��
		
				
				request.setAttribute("result", result);//result���� 0�Դϴ�.
				RequestDispatcher dis = 
						request.getRequestDispatcher("/_ski/SkiMain.jsp?center=aaa.jsp");
					dis.forward(request, response);
			}
		
		}
}
