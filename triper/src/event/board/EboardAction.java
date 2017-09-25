package event.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.rental.loginModel.RentalDTO;

@WebServlet("*.eb")
public class EboardAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EboardAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			actionDo(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			actionDo(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		String uri = request.getRequestURI(); // http://localhost:8080/triper/_event_board/loginPro.eb
		String conPath = request.getContextPath(); // http://localhost:8080/triper
													// 여기까지 길이 구하기
													// /_event_board/loginPro.eb
		String com = uri.substring(conPath.length()); // 길이값 빼고(이후의)
														// /_event_board/loginPro.eb
		String member_id = null;
		String ebTitle = request.getParameter("ebTitle");
		String ebContent = request.getParameter("ebContent");
		PrintWriter script = response.getWriter();

		if (com.equals("/_event_board/writeAction.eb")) { /////////////////////////////////// writeAction.eb
			try {
				RentalDTO dto = (RentalDTO) request.getSession().getAttribute("dto");
				member_id = dto.getMember_id();
			} catch (Exception e) {
				member_id = null;
			}
			System.out.println(member_id);
			EboardDTO ebdto = new EboardDTO();
			if (member_id == null) {
				try {
					script.println("<script>");
					script.println("alert('로그인 하세요.')");
					script.println("location.href='../_main_login/loginForm.jsp'");
					script.println("</script>");
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				if (ebTitle.equals("") || ebContent.equals("")) {
					try {
						script.println("<script>");
						script.println("alert('입력 안 된 사항이 있습니다.')");
						script.println("history.back()");
						script.println("</script>");
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					EboardDAO ebdao = new EboardDAO();
					int result = ebdao.write(ebTitle, member_id, ebContent);
					if (result == -1) {
						script.println("<script>");
						script.println("alert('글쓰기 실패')");
						script.println("history.back()");
						script.println("</script>");
					} else {
						script.println("<script>");
						script.println("location.href='eblist.jsp'");
						script.println("</script>");
					}
				}
			}
		} else if (com.equals("/_event_board/updateAction.eb")) { /////////////////////////////////// updateAction.eb
			try {
				RentalDTO dto = (RentalDTO) request.getSession().getAttribute("dto");
				member_id = dto.getMember_id();
			} catch (Exception e) {
				member_id = null;
			}
			if (member_id == null) {
				script.println("<script>");
				script.println("alert('로그인 하세요.9999')");
				script.println("location.href='../_main_login/loginForm.jsp'");
				script.println("</script>");
			}
			int ebNum = 0;
			if (request.getParameter("ebNum") != null) {
				ebNum = Integer.parseInt(request.getParameter("ebNum"));
			}
			if (ebNum == 0) {
				script.println("<script>");
				script.println("alert('유효하지 않은 글입니다.8888')");
				script.println("location.href='eblist.jsp'");
				script.println("</script>");
			}
			EboardDTO ebdto = new EboardDAO().getEboardDTO(ebNum);
			System.out.println(ebdto.getMember_id());
			// System.out.println(ebdto.getMember_id());

			if (!member_id.equals(ebdto.getMember_id())) {
				script.println("<script>");
				script.println("alert('권한이 없습니다.11111')");
				script.println("location.href='eblist.jsp'");
				script.println("</script>");
			} else {
				if (request.getParameter("ebTitle") == null || request.getParameter("ebContent") == null
						|| request.getParameter("ebTitle") == " " || request.getParameter("ebContent") == " ") {
					script.println("<script>");
					script.println("alert('입력 안 된 사항이 있습니다.22222')");
					script.println("history.back()");
					script.println("</script>");
				} else {
					EboardDAO ebdao = new EboardDAO();
					int result = ebdao.update(ebNum, ebTitle, ebContent);
					if (result == -1) {
						script.println("<script>");
						script.println("alert('글 수정 실패3333')");
						script.println("history.back()");
						script.println("</script>");
					} else {
						script.println("<script>");
						script.println("alert('4444')");
						script.println("location.href='eblist.jsp'");
						script.println("</script>");
					}
				}
			}
		} else if (com.equals("/_event_board/deleteAction.eb")) { /////////////////////////////////// deleteAction.eb
			try {
				RentalDTO dto = (RentalDTO) request.getSession().getAttribute("dto");
				member_id = dto.getMember_id();
			} catch (Exception e) {
				member_id = null;
			}
			if (member_id == null) {
				script.println("<script>");
				script.println("alert('로그인 하세요.')");
				script.println("location.href='../_main_login/loginForm.jsp'");
				script.println("</script>");
			}
			int ebNum = 0;
			if (request.getParameter("ebNum") != null) {
				ebNum = Integer.parseInt(request.getParameter("ebNum"));
			}
			if (ebNum == 0) {
				script.println("<script>");
				script.println("alert('유효하지 않은 글입니다.')");
				script.println("location.href='eblist.jsp'");
				script.println("</script>");
			}
			EboardDTO ebdto = new EboardDAO().getEboardDTO(ebNum);
			if (!member_id.equals(ebdto.getMember_id())) {
				script.println("<script>");
				script.println("alert('권한이 없습니다.')");
				script.println("location.href='eblist.jsp'");
				script.println("</script>");
			} else {
				EboardDAO ebdao = new EboardDAO();
				int result = ebdao.delete(ebNum);
				if (result == -1) {
					script.println("<script>");
					script.println("alert('글 삭제 실패')");
					script.println("history.back()");
					script.println("</script>");
				} else {
					script.println("<script>");
					script.println("location.href='eblist.jsp'");
					script.println("</script>");
				}
			}
		} else if (com.equals("/_event_board/view.eb")) { /////////////////////////////////// mypage.eb
			RentalDTO dto = (RentalDTO) request.getSession().getAttribute("dto");
			// String member_id = dto.getMember_id();

			int ebNum = 0;
			if (request.getParameter("ebNum") != null) {
				ebNum = Integer.parseInt(request.getParameter("ebNum"));
			}
			if (ebNum == 0) {
				script.println("<script>");
				script.println("alert('유효하지 않은 글입니다.')");
				script.println("location.href='eblist.jsp'");
				script.println("</script>");
			}
			EboardDTO ebdto = new EboardDAO().getEboardDTO(ebNum);
		}
	}
}