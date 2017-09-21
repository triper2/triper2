package review.bbs;

public class BbsVO {
	
	private int review_ID;
	private String review_Title;
	private String member_ID;
	private String review_Date;
	private String review_Content;
	private int review_Available;
	private String review_Image_1;
	private int review_Like;
	private int review_Hate;
	private int review_Viewcount;
	
	
	private int review_comment_id;
	private String review_comment_date;
	private String review_comment_content;
	private int review_comment_available;
	private String member_image;
	
	
	public int getReview_Like() {
		return review_Like;
	}
	public void setReview_Like(int review_Like) {
		this.review_Like = review_Like;
	}
	public int getReview_Hate() {
		return review_Hate;
	}
	public void setReview_Hate(int review_Hate) {
		this.review_Hate = review_Hate;
	}
	public int getReview_Viewcount() {
		return review_Viewcount;
	}
	public void setReview_Viewcount(int review_Viewcount) {
		this.review_Viewcount = review_Viewcount;
	}
	
	public int getReview_comment_id() {
		return review_comment_id;
	}
	public void setReview_comment_id(int review_comment_id) {
		this.review_comment_id = review_comment_id;
	}
	public String getReview_comment_date() {
		return review_comment_date;
	}
	public void setReview_comment_date(String review_comment_date) {
		this.review_comment_date = review_comment_date;
	}
	public String getReview_comment_content() {
		return review_comment_content;
	}
	public void setReview_comment_content(String review_comment_content) {
		this.review_comment_content = review_comment_content;
	}
	public int getReview_comment_available() {
		return review_comment_available;
	}
	public void setReview_comment_available(int review_comment_available) {
		this.review_comment_available = review_comment_available;
	}
	public String getMember_image() {
		return member_image;
	}
	public void setMember_image(String member_image) {
		this.member_image = member_image;
	}
	
	
	
	
	
	
	public int getReview_ID() {
		return review_ID;
	}
	public void setReview_ID(int review_ID) {
		this.review_ID = review_ID;
	}
	public String getReview_Title() {
		return review_Title;
	}
	public void setReview_Title(String review_Title) {
		this.review_Title = review_Title;
	}
	public String getMember_ID() {
		return member_ID;
	}
	public void setMember_ID(String member_ID) {
		this.member_ID = member_ID;
	}
	public String getReview_Date() {
		return review_Date;
	}
	public void setReview_Date(String review_Date) {
		this.review_Date = review_Date;
	}
	public String getReview_Content() {
		return review_Content;
	}
	public void setReview_Content(String review_Content) {
		this.review_Content = review_Content;
	}
	public int getReview_Available() {
		return review_Available;
	}
	public void setReview_Available(int review_Available) {
		this.review_Available = review_Available;
	}
	public String getReview_Image_1() {
		return review_Image_1;
	}
	public void setReview_Image_1(String review_Image_1) {
		this.review_Image_1 = review_Image_1;
	}


	
}
