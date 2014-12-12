package friend;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class FriendDao {

public Connection getConnection(){
		
		String connectionUrl = "jdbc:mysql://localhost:3306/finallogin";
		Connection connection=null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionUrl,"root",null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return connection;
		
	}
	
	public void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void create(Friend friend){
		String sql = "insert into friend (usernamefr, comment, year, usernamefk) values (?, ?,?,?)";
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1,friend.getUsernamefr());
			statement.setString(2,friend.getComment());
			statement.setInt(3, friend.getYear());
			statement.setString(4,friend.getUsernamefk());
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConnection(connection);
		}
	}
	
	public void update(Friend friend){
		String sql = "update friend set comment=?,year=? where usernamefr=? and usernamefk=?";
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(3,friend.getUsernamefr());
			statement.setString(1,friend.getComment());
			statement.setInt(2, friend.getYear());
			statement.setString(4,friend.getUsernamefk());
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConnection(connection);
		}
	}
	
	
	
	public Friend selectfrByUsername(String usernamefr, String username){
		String sql = "select * from friend where usernamefr=? and usernamefk=?";
		Connection connection = getConnection();

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, usernamefr);
			statement.setString(2, username);
			ResultSet results = statement.executeQuery();
			if(results.next()) {
				String comment =results.getString("comment");
				int year = results.getInt("year");
				Friend friend = new Friend(usernamefr, comment, year, username);
				return friend;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Friend> selectfrbyyear(int year, String username){
		String sql = "select * from friend where year=? and usernamefk=?";
		Connection connection = getConnection();
		List<Friend> fs=new ArrayList <Friend>();

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, year);
			statement.setString(2, username);
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				String usernamefr =results.getString("usernamefr");
				String comment =results.getString("comment");
				Friend friend = new Friend(usernamefr, comment, year, username);
				fs.add(friend);
				return fs;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Friend> selectfrbycomment(String comment, String username){
		String sql = "select * from friend where comment=? and usernamefk=?";
		Connection connection = getConnection();
		List<Friend> fs=new ArrayList <Friend>();

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, comment);
			statement.setString(2, username);
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				String usernamefr =results.getString("usernamefr");
				int year =results.getInt("year");
				Friend friend = new Friend(usernamefr, comment, year, username);
				fs.add(friend);
				return fs;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void delete(String usernamefr, String usernamefk){
		String sql = "delete from friend where usernamefr=? and usernamefk=?";
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1,usernamefr);
			statement.setString(2,usernamefk);
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConnection(connection);
		}
	}
	
	
	public List<Friend> selectallfriend(String username){
		String sql = "select * from friend where usernamefk=?";
		Connection connection = getConnection();
		List<Friend> fs=new ArrayList<Friend>();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				String comment =results.getString("comment");
				int year = results.getInt("year");
				String usernamefr =results.getString("usernamefr");
				Friend friend = new Friend(usernamefr, comment, year, username);
				fs.add(friend);
			}	return fs;		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("select all friend");
		return null;
	}
	public static void main(String[] args) {
	}

}
