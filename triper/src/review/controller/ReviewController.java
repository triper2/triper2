package review.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.command.BbsCommand;
import review.command.Command;
import review.command.ViewCommand;
import review.command.WriteCommand;


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
		Command  command = null;
		System.out.println("actionDo");
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		if(com.equals("/bbs.review")){
			command = new BbsCommand();
			command.execute(request,response);
			viewPage="/review/bbs.jsp";                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		}
		else if(com.equals("/view.review")){
			command = new ViewCommand();
			command.execute(request,response);
			viewPage="/review/view.jsp";
		}
		else if(com.equals("/write.review")){
			viewPage="/review/write.jsp";
		}
		else if(com.equals("/writeAction.review")){
			command = new WriteCommand();
			command.execute(request,response);
		}
				
		RequestDispatcher  dp = request.getRequestDispatcher(viewPage);
		dp.forward(request, response);
		
	}

}
