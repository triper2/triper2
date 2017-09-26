package event.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.ir.debug.JSONWriter;
import review.bbs.BbsDAO;
import review.bbs.BbsVO;

public class EboardCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int pageNumber = 1;
		String ebTitle = null;
		EboardDAO ebdao = new EboardDAO();
		if (request.getParameter("pageNumber") != null) {
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		}

		if (ebTitle == null) {
			ArrayList<EboardDTO> list;
			try {
				list = ebdao.getList(pageNumber);
				request.setAttribute("ebdao", ebdao);
				request.setAttribute("list", list);
				request.setAttribute("pageNumber", pageNumber);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (request.getParameter("ebTitle") != null) {
			ebTitle = request.getParameter("ebTitle");
			ArrayList<EboardDTO> list;
			try {
				list = ebdao.getList(pageNumber);
				request.setAttribute("ebdao", ebdao);
				request.setAttribute("list", list);
				request.setAttribute("pageNumber", pageNumber);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
