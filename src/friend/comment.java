package friend;

public class comment {
	private int commentid;
	private String description;
	public int getCommentid() {
		return commentid;
	}
	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public comment(int commentid, String description) {
		super();
		this.commentid = commentid;
		this.description = description;
	}
	public comment(String description) {
		super();
		this.description = description;
	}
	public comment() {
		super();
	}
	
}
