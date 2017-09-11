package review.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import review.bbs.BbsDAO;
import review.bbs.BbsVO;

public class UpdateActionCommand implements Command {
	HttpSession session = null;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String member_ID = request.getParameter("member_ID");
		member_ID = "123";
		/*if (session.getAttribute("member_ID") != null) {
			member_ID = (String) session.getAttribute("userID");
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

		}*/
		int review_ID = 0;
		if (request.getParameter("review_ID") != null) {
			
			review_ID = Integer.parseInt(request.getParameter("review_ID"));
		}
		
		BbsVO bbs = new BbsDAO().getBbs(review_ID);
		if (!member_ID.equals(bbs.getMember_ID())) {
			PrintWriter script;
			try {
				script = response.getWriter();
				script.println("<script>");
				script.println("alert('권한이 없습니다.')");
				script.println("location.href='bbs.jsp'");
				script.println("</script>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println("업데이트3");
			if (request.getParameter("review_Title") == null || request.getParameter("review_Content") == null
					|| request.getParameter("review_Title").equals("") || request.getParameter("review_Content").equals("")) {
				PrintWriter script;
				try {
					script = response.getWriter();
					script.println("<script>");
					script.println("alert('입력이 안 된 사항이 있습니다.')");
					script.println("history.back()");
					script.println("</script>");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				BbsDAO bbsDAO = new BbsDAO();
				int result = bbsDAO.update(review_ID, request.getParameter("review_Title"),
						request.getParameter("review_Content"));
				if (result == -1) {
					PrintWriter script;
					try {
						script = response.getWriter();
						script.println("<script>");
						script.println("alert('글 수정이 실패했습니다')");
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
		}
	}
}
