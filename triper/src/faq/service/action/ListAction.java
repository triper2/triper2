package faq.service.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import faq.service.controller.Action;
import faq.service.dao.AlbumDao;
import faq.service.domain.AlbumPage;
import faq.service.domain.Album;


public class ListAction implements Action{
    public String execute(HttpServletRequest request,HttpServletResponse response) throws Throwable {
    
    request.setCharacterEncoding("utf-8");

    String keyField =request.getParameter("keyField");
    String keyWord =request.getParameter("keyWord");
    if(keyField==null){
        keyField="";
    }
    if(keyWord==null){
        keyWord="";
    }    
    
    String pageNum =request.getParameter("pageNum");
    
    if(pageNum ==null){
        pageNum = "1";
    }    
    
    
    int pageSize = 20;
    int currentPage = Integer.parseInt(pageNum);
    int startRow =(currentPage-1)*pageSize +1;
    int endRow =currentPage * pageSize;
    int service_readcount = 0;
    int number = 0;
    
    List<Album> albumList =null;
    AlbumDao manager = AlbumDao.getInstance();
    service_readcount =manager.getArticleCount(keyField,keyWord);
    
    if(service_readcount>0){
        albumList = manager.getArticles(startRow, endRow, keyField, keyWord);
    }
    //가짜 글번호
    number=service_readcount-(currentPage-1)*pageSize;

    AlbumPage page= new AlbumPage();
    page.setService_readcount(service_readcount);
    page.setCurrentPage(currentPage);
    page.setNumber(number);
    page.setPageSize(pageSize);    
    page.setKeyField(keyField);    
    page.setKeyWord(keyWord);    
    
    request.setAttribute("page", page);
    request.setAttribute("albumList", albumList);

    return "/_faq/service/list.jsp";
    }
}