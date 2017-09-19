package faq.service.domain;

public class AlbumPage {
    
    private int service_readcount;
    private int pageSize;
    private int currentPage;
    private int number;
    private String keyField;
    private String keyWord;
    
    
    public int getService_readcount() {
        return service_readcount;
    }
    public void setService_readcount(int service_readcount) {
        this.service_readcount = service_readcount;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }    
    public String getKeyField() {
        return keyField;
    }
    public void setKeyField(String keyField) {
        this.keyField = keyField;
    }
    public String getKeyWord() {
        return keyWord;
    }
    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }        
}