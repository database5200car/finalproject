package favorite;

public class make {
	private String model;
	private String make;
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public make(String model, String make) {
		super();
		this.model = model;
		this.make = make;
	}
	public make(String make) {
		super();
		this.make = make;
	}
	public make() {
		super();
	}
	
}
