package event.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.eb")
public class EboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EboardController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

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
		
		if(com.equals("eblist.eb")){
			command = new EboardCommand();
			command.execute(request,response);
			viewPage="../_event_board/eblist.jsp";                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
		}
		else if(com.equals("view.eb")){
			command = new ViewCommand();
			command.execute(request,response);
			viewPage="../_event_board/view.jsp";
		}
		else if(com.equals("write.eb")){
			viewPage="../_event_board/write.jsp";
		}
		else if(com.equals("writeAction.eb")){
			command = new WriteCommand();
			command.execute(request,response);
		}
		else if(com.equals("update.eb")){
			command = new UpdateCommand();
			command.execute(request,response);
			viewPage="../_event_board/update.jsp";
		}
		else if(com.equals("updateAction.eb")){
			command = new UpdateActionCommand();
			command.execute(request,response);
		}
		else if(com.equals("deleteAction.eb")){
			command = new deleteCommand();
			command.execute(request,response);
		}
						
		dp = request.getRequestDispatcher(viewPage);
		dp.forward(request, response);
		
	}

}
