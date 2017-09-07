package kosta.rental.loginAction;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.rental.loginModel.RentalDAO;

/**
 * Servlet implementation class ReviewController
 */
@WebServlet("*.do")
public class LoginProAction extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginProAction() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("get");
      actionDo(request, response);
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("post");
      actionDo(request, response);
   
   }

   private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
      String viewPage = null;
      String uri = request.getRequestURI();
      String conPath = request.getContextPath();
      String com = uri.substring(conPath.length());
      int check = 0;
      if(com.equals("/_main_login/loginPro.do")){
    	  String id = request.getParameter("id");
          String pwd = request.getParameter("password");
    	  RentalDAO dao = RentalDAO.getInstance();
    	  try {
			check = dao.userCheck(id, pwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         viewPage="/_main_login/loginPro.jsp";
      } else if(com.equals("/_main_login/loginForm.do")) {
    	  viewPage="/_main_login/index.jsp";
      }
      System.out.println(viewPage);
      RequestDispatcher dp = request.getRequestDispatcher(viewPage);
      request.setAttribute("check", check);
      dp.forward(request, response);
      
   }

}
