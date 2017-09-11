package review.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import review.bbs.BbsDAO;
import review.bbs.BbsVO;

public class deleteCommand implements Command {
	HttpSession session = null;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String member_ID = "123";
		int review_ID = 0;

	/*	if (session.getAttribute("member_ID") != null) {
			member_ID = (String) session.getAttribute("member_ID");
		}*/
		if (request.getParameter("review_ID") != null) {
			review_ID = Integer.parseInt(request.getParameter("review_ID"));
		}
		if (member_ID == null) {
			PrintWriter script;
			try {
				script = response.getWriter();
				script.println("<script>");
				script.println("alert('로그인을 하세요')");
				script.println("location.href = 'login.jsp'");// 로그인 페이지
				script.println("</script>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			BbsDAO bbsDAO = new BbsDAO();
			int result = bbsDAO.delete(review_ID);
			if (result == -1) {
				PrintWriter script;
				try {
					script = response.getWriter();
					script.println("<script>");
					script.println("alert('글 삭제에 실패했습니다')");
					script.println("history.back()");
					script.println("</script>");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {

				PrintWriter script;
				try {
					script = response.getWriter();
					script.println("<script>");
					script.println("location.href = 'bbs.review'");// 로그인 페이지
					script.println("</script>");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		BbsVO bbs = new BbsDAO().getBbs(review_ID);
		if (!member_ID.equals(bbs.getMember_ID())) {
			PrintWriter script;
			try {
				script = response.getWriter();
				script.println("<script>");
				script.println("alert('권한이 없습니다.')");
				script.println("location.href='bbs.review'");
				script.println("</script>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
