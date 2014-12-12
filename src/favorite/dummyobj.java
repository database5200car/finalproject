package favorite;

public class dummyobj {
	private Favorite favorite;
	private make mk;
	private model ml;
	private year yr;
	public Favorite getFavorite() {
		return favorite;
	}
	public void setFavorite(Favorite favorite) {
		this.favorite = favorite;
	}
	public make getMk() {
		return mk;
	}
	public void setMk(make mk) {
		this.mk = mk;
	}
	public model getMl() {
		return ml;
	}
	public void setMl(model ml) {
		this.ml = ml;
	}
	public year getYr() {
		return yr;
	}
	public void setYr(year yr) {
		this.yr = yr;
	}
	public dummyobj(Favorite favorite, make mk, model ml, year yr) {
		super();
		this.favorite = favorite;
		this.mk = mk;
		this.ml = ml;
		this.yr = yr;
	}
	public dummyobj() {
		super();
	}
	
}
