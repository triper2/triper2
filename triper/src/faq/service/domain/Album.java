package faq.service.domain;

import java.sql.Timestamp;

public class Album {
    
    private int service_id;
    private String member_id;
    private String service_title;
    private String service_email;
    private String service_content;
    private String service_pwd;
    private Timestamp service_reg_date;
    private int service_readcount;
    private String service_ip; 
    private String service_img;
    private int service_ref;
    private int service_re_step;
    private int service_level;
    
	public int getService_id() {
		return service_id;
	}
	public void setService_id(int service_id) {
		this.service_id = service_id;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getService_title() {
		return service_title;
	}
	public void setService_title(String service_title) {
		this.service_title = service_title;
	}
	public String getService_email() {
		return service_email;
	}
	public void setService_email(String service_email) {
		this.service_email = service_email;
	}
	public String getService_content() {
		return service_content;
	}
	public void setService_content(String service_content) {
		this.service_content = service_content;
	}
	public String getService_pwd() {
		return service_pwd;
	}
	public void setService_pwd(String service_pwd) {
		this.service_pwd = service_pwd;
	}
	public Timestamp getService_reg_date() {
		return service_reg_date;
	}
	public void setService_reg_date(Timestamp service_reg_date) {
		this.service_reg_date = service_reg_date;
	}
	public int getService_readcount() {
		return service_readcount;
	}
	public void setService_readcount(int service_readcount) {
		this.service_readcount = service_readcount;
	}
	public String getService_ip() {
		return service_ip;
	}
	public void setService_ip(String service_ip) {
		this.service_ip = service_ip;
	}
	public String getService_img() {
		return service_img;
	}
	public void setService_img(String service_img) {
		this.service_img = service_img;
	}
	public int getService_ref() {
		return service_ref;
	}
	public void setService_ref(int service_ref) {
		this.service_ref = service_ref;
	}
	public int getService_re_step() {
		return service_re_step;
	}
	public void setService_re_step(int service_re_step) {
		this.service_re_step = service_re_step;
	}
	public int getService_level() {
		return service_level;
	}
	public void setService_level(int service_level) {
		this.service_level = service_level;
	}
    
    
    
}