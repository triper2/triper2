package car_db;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;

public class CarListBean {
	private int product_carno;
	private String product_carname;
	private String product_carcompany;
	private int product_carprice;
	private int product_carusepeople;
	private String product_carinfo;
	private String product_carimg;
	private String product_carcategory;
	private String business_id;
	public String getBusiness_id() {
		return business_id;
	}
	public void setBusiness_id(String business_id) {
		this.business_id = business_id;
	}
	public int getProduct_carno() {
		return product_carno;
	}
	public void setProduct_carno(int product_carno) {
		this.product_carno = product_carno;
	}
	public String getProduct_carname() {
		return product_carname;
	}
	public void setProduct_carname(String product_carname) {
		this.product_carname = product_carname;
	}
	public String getProduct_carcompany() {
		return product_carcompany;
	}
	public void setProduct_carcompany(String product_carcompany) {
		this.product_carcompany = product_carcompany;
	}
	public int getProduct_carprice() {
		return product_carprice;
	}
	public void setProduct_carprice(int product_carprice) {
		this.product_carprice = product_carprice;
	}
	public int getProduct_carusepeople() {
		return product_carusepeople;
	}
	public void setProduct_carusepeople(int product_carusepeople) {
		this.product_carusepeople = product_carusepeople;
	}
	public String getProduct_carinfo() {
		return product_carinfo;
	}
	public void setProduct_carinfo(String product_carinfo) {
		this.product_carinfo = product_carinfo;
	}
	public String getProduct_carimg() {
		return product_carimg;
	}
	public void setProduct_carimg(String product_img) {
		this.product_carimg = product_img;
	}
	public String getProduct_carcategory() {
		return product_carcategory;
	}
	public void setProduct_carcategory(String product_carcategory) {
		this.product_carcategory = product_carcategory;
	}
	

	
	
}
