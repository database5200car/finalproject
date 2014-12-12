package favorite;

public class Favorite {
	private int favoriteid;
	private String userfavfk;
	public int getFavoriteid() {
		return favoriteid;
	}
	public void setFavoriteid(int favoriteid) {
		this.favoriteid = favoriteid;
	}
	public String getUserfavfk() {
		return userfavfk;
	}
	public void setUserfavfk(String userfavfk) {
		this.userfavfk = userfavfk;
	}
	public Favorite(int favoriteid, String userfavfk) {
		super();
		this.favoriteid = favoriteid;
		this.userfavfk = userfavfk;
	}
	public Favorite(String userfavfk) {
		super();
		this.userfavfk = userfavfk;
	}
	public Favorite() {
		super();
	}

}
