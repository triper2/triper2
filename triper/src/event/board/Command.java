package event.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 요청 파라미터로 명령어를 전달하는 방식의 수퍼 인터페이스
public interface Command {
	
	void execute(HttpServletRequest request, HttpServletResponse response);
}
