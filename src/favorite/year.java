package favorite;

public class year {
	private int carid;
	private int year;
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public year(int carid, int year) {
		super();
		this.carid = carid;
		this.year = year;
	}
	public year(int year) {
		super();
		this.year = year;
	}
	public year() {
		super();
	}
	
}
