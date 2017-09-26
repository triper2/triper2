package event.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.rental.loginModel.RentalDTO;


public class WriteCommand implements Command {
	HttpSession session = null;
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
				
		String member_id = null;
		String ebTitle =request.getParameter("ebTitle");
		String ebContent = request.getParameter("ebContent");
			
		try {
			RentalDTO dto = (RentalDTO)request.getSession().getAttribute("dto");
			member_id = dto.getMember_id();
		} catch (Exception e) {
			member_id = null;
		}
		
		if (member_id == null) {
			PrintWriter script;
			try {
				script = response.getWriter();
				script.println("<script>");
				script.println("alert('로그인을 하세요')");
				script.println("location.href = '../_main_login/loginForm.jsp'");
				script.println("</script>");
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			if (ebTitle.equals("")|| ebContent.equals("")) {
				PrintWriter script;
				try {
					script = response.getWriter();
					script.println("<script>");
					script.println("alert('입력이 안 된 사항이 있습니다.')");
					script.println("history.back()");
					script.println("</script>");
				} catch (IOException e) {
					e.printStackTrace();
				}

			} else {
				EboardDAO EboardDAO = new EboardDAO();
				int result=-1;
				try {
					result = EboardDAO.write(ebTitle, ebContent, member_id);
				} catch (Exception e1) {
					result=-1;
				}
				if (result == -1) {
					PrintWriter script;
					try {
						script = response.getWriter();
						script.println("<script>");
						script.println("alert('글쓰기에 실패했습니다')");
						script.println("history.back()");
						script.println("</script>");
					} catch (IOException e) {
						e.printStackTrace();
					}

				} else {
					PrintWriter script;
					try {
						script = response.getWriter();
						script.println("<script>");
						script.println("location.href = 'eblist.eb?pageNumber=1'");// 로그인 페이지
						script.println("</script>");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}	
	}
}
