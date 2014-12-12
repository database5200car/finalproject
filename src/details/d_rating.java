package details;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: d_rating
 *
 */
@Entity

public class d_rating implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	

	public d_rating(String review, float value) {
		super();
		this.review = review;
		this.value = value;
	}

	private String review;
	private float value;
	
	

	private static final long serialVersionUID = 1L;

	public d_rating() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getReview() {
		return this.review;
	}

	public void setReview(String review) {
		this.review = review;
	}   
	public float getValue() {
		return this.value;
	}

	public void setValue(float value) {
		this.value = value;
	}
   
}
