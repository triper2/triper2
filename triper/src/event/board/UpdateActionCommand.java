package event.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.rental.loginModel.RentalDTO;

public class UpdateActionCommand implements Command {
	HttpSession session = null;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String member_id = null;

		try {
			RentalDTO dto = (RentalDTO) request.getSession().getAttribute("dto");
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
				script.println("location.href = 'eblist.eb'");// 로그인 페이지
				script.println("</script>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		int ebNum = 0;
		if (request.getParameter("ebNum") != null) {
			ebNum = Integer.parseInt(request.getParameter("ebNum"));
		}

		System.out.println(ebNum);
		try {
			EboardDTO ebdto = new EboardDAO().getEboardDTO(ebNum);
			System.out.println(ebdto.getMember_id());
			if (!member_id.equals(ebdto.getMember_id())) {
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

			} else {
				if (request.getParameter("ebTitle") == null || request.getParameter("ebContent") == null
						|| request.getParameter("ebTitle").equals("") || request.getParameter("ebContent").equals("")) {
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
					EboardDAO ebdao = new EboardDAO();
					int result = ebdao.update(ebNum, request.getParameter("ebTitle"),
							request.getParameter("ebContent"));
					if (result == -1) {
						PrintWriter script;
						try {
							script = response.getWriter();
							script.println("<script>");
							script.println("alert('글 수정이 실패했습니다')");
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
							script.println("location.href = 'eblist.eb'");
							script.println("</script>");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
