package favorite;

public class model {
	private int carid;
	private String model;
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public model(int carid, String model) {
		super();
		this.carid = carid;
		this.model = model;
	}
	public model(String model) {
		super();
		this.model = model;
	}
	public model() {
		super();
	}
	
}
