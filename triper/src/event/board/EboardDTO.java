package event.board;

public class EboardDTO {

	private int ebNum;
	private String ebTitle;
	private String member_id;
	private String ebDate;
	private String ebContent;
	public int getEbNum() {
		return ebNum;
	}
	public void setEbNum(int ebNum) {
		this.ebNum = ebNum;
	}
	public String getEbTitle() {
		return ebTitle;
	}
	public void setEbTitle(String ebTitle) {
		this.ebTitle = ebTitle;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getEbDate() {
		return ebDate;
	}
	public void setEbDate(String ebDate) {
		this.ebDate = ebDate;
	}
	public String getEbContent() {
		return ebContent;
	}
	public void setEbContent(String ebContent) {
		this.ebContent = ebContent;
	}
	public int getEbAvailable() {
		return ebAvailable;
	}
	public void setEbAvailable(int ebAvailable) {
		this.ebAvailable = ebAvailable;
	}
	private int ebAvailable;
	
	
}
