package search;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  
//요청 파라미터로 명령어를 전달하는 방식의 슈퍼 인터페이스
public interface SearchAction {
    public String execute(HttpServletRequest request,HttpServletResponse response)throws Throwable;
}