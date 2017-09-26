package event.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class deleteCommand implements Command {
	HttpSession session = null;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String member_ID = "123";
		int ebNum = 0;

		/*
		 * if (session.getAttribute("member_ID") != null) { member_ID = (String)
		 * session.getAttribute("member_ID"); }
		 */
		if (request.getParameter("ebNum") != null) {
			ebNum = Integer.parseInt(request.getParameter("ebNum"));
		}
		if (member_ID == null) {
			PrintWriter script;
			try {
				script = response.getWriter();
				script.println("<script>");
				script.println("alert('로그인을 하세요')");
				script.println("location.href = '../_main_login/loginForm.jsp'");// 로그인 페이지
				script.println("</script>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			EboardDAO ebdao = new EboardDAO();
			int result;
			try {
				result = ebdao.delete(ebNum);
				if (result == -1) {
					PrintWriter script;
					try {
						script = response.getWriter();
						script.println("<script>");
						script.println("alert('글 삭제에 실패했습니다')");
						script.println("history.back()");
						script.println("</script>");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else {

					PrintWriter script;
					try {
						script = response.getWriter();
						script.println("<script>");
						script.println("location.href = 'eblist.eb'");
						script.println("</script>");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		EboardDTO ebdto;
		try {
			ebdto = new EboardDAO().getEboardDTO(ebNum);

			if (!member_ID.equals(ebdto.getMember_id())) {
				PrintWriter script;
				try {
					script = response.getWriter();
					script.println("<script>");
					script.println("alert('권한이 없습니다.')");
					script.println("location.href='eblist.eb'");
					script.println("</script>");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
