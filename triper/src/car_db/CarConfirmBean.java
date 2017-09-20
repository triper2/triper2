package car_db;


//2개의 테이블에서 조인해서 나온 결과를 저장해주는 클래스
public class CarConfirmBean {

	private String product_carname;
	private String product_carimg;
	private int product_carprice;
	private int orderid;
	private String reserved_carbegindate;
	private int reserved_product_count;
	private int reserved_option_usein;
	private int reserved_option_carwifi;
	private int reserved_option_carnavi;
	private int reserved_option_carseat;
	private int totalprice;
	private long calDateDays;
	public long getCalDateDays() {
		return calDateDays;
	}
	public void setCalDateDays(long calDateDays) {
		this.calDateDays = calDateDays;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public String getProduct_carname() {
		return product_carname;
	}
	public void setProduct_carname(String product_carname) {
		this.product_carname = product_carname;
	}
	public String getProduct_carimg() {
		return product_carimg;
	}
	public void setProduct_carimg(String product_carimg) {
		this.product_carimg = product_carimg;
	}
	public int getProduct_carprice() {
		return product_carprice;
	}
	public void setProduct_carprice(int product_carprice) {
		this.product_carprice = product_carprice;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getReserved_carbegindate() {
		return reserved_carbegindate;
	}
	public void setReserved_carbegindate(String reserved_carbegindate) {
		this.reserved_carbegindate = reserved_carbegindate;
	}
	public int getReserved_product_count() {
		return reserved_product_count;
	}
	public void setReserved_product_count(int reserved_product_count) {
		this.reserved_product_count = reserved_product_count;
	}
	public int getReserved_option_usein() {
		return reserved_option_usein;
	}
	public void setReserved_option_usein(int reserved_option_usein) {
		this.reserved_option_usein = reserved_option_usein;
	}
	public int getReserved_option_carwifi() {
		return reserved_option_carwifi;
	}
	public void setReserved_option_carwifi(int reserved_option_carwifi) {
		this.reserved_option_carwifi = reserved_option_carwifi;
	}
	public int getReserved_option_carnavi() {
		return reserved_option_carnavi;
	}
	public void setReserved_option_carnavi(int reserved_option_carnavi) {
		this.reserved_option_carnavi = reserved_option_carnavi;
	}
	public int getReserved_option_carseat() {
		return reserved_option_carseat;
	}
	public void setReserved_option_carseat(int reserved_option_carseat) {
		this.reserved_option_carseat = reserved_option_carseat;
	}
	
	
	
	
	
	
}
