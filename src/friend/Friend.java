package friend;

public class Friend {
	private String usernamefr;
	private String comment;
	private int year;
	private String usernamefk;
	public String getUsernamefr() {
		return usernamefr;
	}
	public void setUsernamefr(String usernamefr) {
		this.usernamefr = usernamefr;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}


	public String getUsernamefk() {
		return usernamefk;
	}
	public void setUsernamefk(String usernamefk) {
		this.usernamefk = usernamefk;
	}
	public Friend(String usernamefr, String comment, int year, String usernamefk) {
		super();
		this.usernamefr = usernamefr;
		this.comment = comment;
		this.year = year;
		this.usernamefk = usernamefk;
	}
	public Friend(String comment, int year) {
		super();
		this.comment = comment;
		this.year = year;
	}	
}



