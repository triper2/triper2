/*package event.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import event.board.FileUtil;
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String uri = request.getRequestURI(); // http://localhost:8080/triper/_event_board/loginPro.eb
		String conPath = request.getContextPath(); // http://localhost:8080/triper 여기까지 길이 구하기 /_event_board/loginPro.eb
		String com = uri.substring(conPath.length()); // 길이값 빼고(이후의) /_event_board/loginPro.eb
		String member_id = null;
		String ebImg = request.getParameter("ebImg");;
		String ebTitle = request.getParameter("ebTitle");
		String ebContent = request.getParameter("ebContent");
		PrintWriter script = response.getWriter();
		System.out.println(ebTitle);
		System.out.println(ebContent);
		
		if (com.equals("/_event_board/writeAction.eb")) { /////////////////////////////////// writeAction.eb
			try {
				RentalDTO dto = (RentalDTO) request.getSession().getAttribute("dto");
				member_id = dto.getMember_id();
			} catch (Exception e) {
				member_id = null;
			}
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
						script.println("alert('입력 안된 사항이 있습니다.')");
						script.println("history.back()");
						script.println("</script>");
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {				
					EboardDAO ebdao = new EboardDAO();
					//EboardDTO ebdto = new EboardDTO();
					int result = ebdao.write(ebTitle, ebContent, member_id, ebImg);
					if (result == -1) {
						try {
						script.println("<script>");
						script.println("alert('글쓰기 실패')");
						script.println("history.back()");
						script.println("</script>");
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						try {
						script.println("<script>");
						script.println("location.href='eblist.jsp'");
						script.println("</script>");
						} catch (Exception e) {
							e.printStackTrace();
						}
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
				try {
				script.println("<script>");
				script.println("alert('로그인 하세요.')");
				script.println("location.href='../_main_login/loginForm.jsp'");
				script.println("</script>");
				} catch (Exception e) {
					e.printStackTrace();
				}
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
				try {
				script.println("<script>");
				script.println("alert('권한이 없습니다.')");
				script.println("location.href='eblist.jsp'");
				script.println("</script>");
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				if (request.getParameter("ebTitle") == null || request.getParameter("ebContent") == null
						|| request.getParameter("ebTitle").equals("") || request.getParameter("ebContent").equals("")) {
					try {
					script.println("<script>");
					script.println("alert('입력 안 된 사항이 있습니다.')");
					script.println("history.back()");
					script.println("</script>");
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					//MultipartRequest multi = FileUtil.createFile(request);
					EboardDAO ebdao = new EboardDAO();
					String ebImg = multi.getFilesystemName("ebImg");
					ebdto.setMember_id(multi.getParameter("member_id"));
					ebdto.setEbTitle(multi.getParameter("ebTitle"));
					ebdto.setEbContent(multi.getParameter("ebContent"));
					ebdto.setEbImg(multi.getParameter("ebImg"));
					ebdto.setEbImg(ebImg);
					int result = ebdao.update(ebdto);
					if (result == -1) {
						try {
						script.println("<script>");
						script.println("alert('글 수정 실패')");
						script.println("history.back()");
						script.println("</script>");
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						try {
						script.println("<script>");
						//script.println("alert('글 수정 완료')");
						script.println("location.href='eblist.jsp'");
						script.println("</script>");
						} catch (Exception e) {
							e.printStackTrace();
						}
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
				try {
				script.println("<script>");
				script.println("alert('로그인 하세요.')");
				script.println("location.href='../_main_login/loginForm.jsp'");
				script.println("</script>");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			int ebNum = 0;
			if (request.getParameter("ebNum") != null) {
				ebNum = Integer.parseInt(request.getParameter("ebNum"));
			}
			if (ebNum == 0) {
				try {
				script.println("<script>");
				script.println("alert('유효하지 않은 글입니다.')");
				script.println("location.href='eblist.jsp'");
				script.println("</script>");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			EboardDTO ebdto = new EboardDAO().getEboardDTO(ebNum);
			if (!member_id.equals(ebdto.getMember_id())) {
				try {
				script.println("<script>");
				script.println("alert('권한이 없습니다.')");
				script.println("location.href='eblist.jsp'");
				script.println("</script>");
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				EboardDAO ebdao = new EboardDAO();
				int result = ebdao.delete(ebNum);
				if (result == -1) {
					try {
					script.println("<script>");
					script.println("alert('글 삭제 실패')");
					script.println("history.back()");
					script.println("</script>");
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					try {
					script.println("<script>");
					script.println("location.href='eblist.jsp'");
					script.println("</script>");
					} catch (Exception e) {
						e.printStackTrace();
					}
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
				try {
				script.println("<script>");
				script.println("alert('유효하지 않은 글입니다.')");
				script.println("location.href='eblist.jsp'");
				script.println("</script>");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			EboardDTO ebdto = new EboardDAO().getEboardDTO(ebNum);
		}
	}
}*/