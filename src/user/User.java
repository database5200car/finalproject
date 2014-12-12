package user;



import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

import friend.Friend;

@Entity
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
public class User {
	@Id
	@XmlAttribute
private String username;
	@XmlAttribute
private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User(String password) {
		super();
		this.password = password;
	}
	public User() {
		super();
	}

}
	

