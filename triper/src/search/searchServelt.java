package search;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.searchServelt")
public class searchServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchServelt() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			actionDo(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			actionDo(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String viewPage = null;
		RequestDispatcher dp = null;
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		String table = null;
		String column = null;
		String input = null;
		com = com.split("/")[2];
		
		List<SearchVo> searchlist = null;
		System.out.println(request.getParameter("input"));
		SearchDao dao = SearchDao.getInstance();
		SearchVo vo = new SearchVo();
		table = request.getParameter("table");
		column = request.getParameter("column");
		input = request.getParameter("input");
		System.out.println("input2" + input);
		searchlist = dao.SearchList(table, column, input);
		
		
		request.setAttribute("table", table);
		request.setAttribute("column", column);
		request.setAttribute("input", input);
		request.setAttribute("vo", vo);
		//request.setAttribute("searchlist", searchlist);
		
		
		
	/*	if(com.equals("bbs.review")){
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
		}*/
				
		//dp = request.getRequestDispatcher(viewPage);
		//dp.forward(request, response);
		
	}

}
