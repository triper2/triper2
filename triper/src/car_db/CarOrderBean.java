package car_db;

//차량 렌트에 대한 정보를 저장하는 빈
public class CarOrderBean {

	private int orderid;
	private int product_carno;
	private int reserved_product_count ; // carqty수량
	private String reserved_carbegindate ;//carbegindate 빌린날
	private String reserved_carbegintime;
	private String reserved_carenddate;
	private String reserved_carendtime;
	private int reserved_option_usein;
	private int reserved_option_carwifi;
	private int reserved_option_carnavi;
	private int reserved_option_carbabyseat;
	private String memberphone;
	private String memberpass;
	private int totalprice;
	private int calDateDays;
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getCalDateDays() {
		return calDateDays;
	}
	public void setCalDateDays(int calDateDays) {
		this.calDateDays = calDateDays;
	}
	public int getProduct_carno() {
		return product_carno;
	}
	public void setProduct_carno(int product_carno) {
		this.product_carno = product_carno;
	}
	public int getReserved_product_count() {
		return reserved_product_count;
	}
	public void setReserved_product_count(int reserved_product_count) {
		this.reserved_product_count = reserved_product_count;
	}
	public String getReserved_carbegindate() {
		return reserved_carbegindate;
	}
	public void setReserved_carbegindate(String reserved_carbegindate) {
		this.reserved_carbegindate = reserved_carbegindate;
	}
	public String getReserved_carbegintime() {
		return reserved_carbegintime;
	}
	public void setReserved_carbegintime(String reserved_carbegintime) {
		this.reserved_carbegintime = reserved_carbegintime;
	}
	public String getReserved_carenddate() {
		return reserved_carenddate;
	}
	public void setReserved_carenddate(String reserved_carenddate) {
		this.reserved_carenddate = reserved_carenddate;
	}
	public String getReserved_carendtime() {
		return reserved_carendtime;
	}
	public void setReserved_carendtime(String reserved_carendtime) {
		this.reserved_carendtime = reserved_carendtime;
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
	public int getReserved_option_carbabyseat() {
		return reserved_option_carbabyseat;
	}
	public void setReserved_option_carbabyseat(int reserved_option_carbabyseat) {
		this.reserved_option_carbabyseat = reserved_option_carbabyseat;
	}
	public String getMemberphone() {
		return memberphone;
	}
	public void setMemberphone(String memberphone) {
		this.memberphone = memberphone;
	}
	public String getMemberpass() {
		return memberpass;
	}
	public void setMemberpass(String memberpass) {
		this.memberpass = memberpass;
	}
	
	
}
