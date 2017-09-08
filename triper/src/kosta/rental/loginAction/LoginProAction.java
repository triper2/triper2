package kosta.rental.loginAction;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import kosta.rental.loginModel.RentalDAO;

@WebServlet("*.do")
public class LoginProAction extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public LoginProAction() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      System.out.println("get");
      actionDo(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      System.out.println("post");
      actionDo(request, response);

   }

   private void actionDo(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      String viewPage = null;
      String uri = request.getRequestURI();
      String conPath = request.getContextPath();
      String com = uri.substring(conPath.length());
      int check = 0;
      if (com.equals("/_main_login/loginPro.do")) {
    	  String id = request.getParameter("id");
         String pwd = request.getParameter("password");
         RentalDAO dao = RentalDAO.getInstance();
         try {
            check = dao.userCheck(id, pwd);
         } catch (Exception e) {
            e.printStackTrace();
         }
         if(check==1) {
        	 request.getSession().setAttribute("id", id);
         }
         request.setAttribute("check", check);
         viewPage = "/_main_login/loginPro.jsp";
      } else if (com.equals("/_main_login/loginForm.do")) {
         viewPage = "/_main_login/index.jsp";
      }
      System.out.println(viewPage);
      RequestDispatcher dp = request.getRequestDispatcher(viewPage);
      
      dp.forward(request, response);
   }
}