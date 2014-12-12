package model;

public class car {
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public car(String img, String info, String name, String year, String model) {
		super();
		this.img = img;
		this.info = info;
		this.name = name;
		this.year = year;
		this.model = model;
	}
	public car() {
		// TODO Auto-generated constructor stub
	}
	
	public int getStyle_id() {
		return style_id;
	}
	public void setStyle_id(int id) {
		this.style_id = id;
	}
	String img;
	String info;
	String name;
	String year;
	String model;
	int style_id;
	
	public Float rating;
	public int rev_count;
}
