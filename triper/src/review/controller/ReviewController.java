package review.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.java.swing.plaf.windows.resources.windows;

import review.command.BbsCommand;
import review.command.Command;
import review.command.LikeHateCommand;
import review.command.UpdateActionCommand;
import review.command.UpdateCommand;
import review.command.ViewCommand;
import review.command.WriteCommand;
import review.command.deleteCommand;


@WebServlet("*.review")
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String viewPage = null;
		Command  command = null;
		RequestDispatcher dp = null;
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		com = com.split("/")[2];
		System.out.println(com);
		
		if(com.equals("bbs.review")){
			command = new BbsCommand();
			command.execute(request,response);
			viewPage="../_review/bbs.jsp";                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
		}
		else if(com.equals("view.review")){
			command = new ViewCommand();
			command.execute(request,response);
			viewPage="../_review/view.jsp";
		}
		else if(com.equals("write.review")){
			viewPage="../_review/write.jsp";
		}
		else if(com.equals("writeAction.review")){
			command = new WriteCommand();
			command.execute(request,response);
		}
		else if(com.equals("update.review")){
			command = new UpdateCommand();
			command.execute(request,response);
			viewPage="../_review/update.jsp";
		}
		else if(com.equals("updateAction.review")){
			command = new UpdateActionCommand();
			command.execute(request,response);
		}
		else if(com.equals("deleteAction.review")){
			command = new deleteCommand();
			command.execute(request,response);
		}
		else if(com.equals("LikeHateCommand.review")){
			System.out.println("문제1");
			command = new LikeHateCommand();
			command.execute(request,response);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
		}
				
		dp = request.getRequestDispatcher(viewPage);
		dp.forward(request, response);
		
	}

}
