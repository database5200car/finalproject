package favorite;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession; 
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import friend.Friend;

public class FavoriteDao {
	
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
	
	public void createfav(Favorite favorite){
		String sql = "insert into favorite (favoriteid,userfavfk) values (?,?)";
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1,favorite.getFavoriteid());
			statement.setString(2, favorite.getUserfavfk());
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConnection(connection);
		}
	}
	
	public void createmake(make mk){
		String sql1 = "insert into make (model,make) values (?,?)";
		Connection connection = getConnection();
		try {
			PreparedStatement statement1 = connection.prepareStatement(sql1);
			statement1.setString(1,mk.getModel());
			statement1.setString(2, mk.getMake());
			statement1.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConnection(connection);
		}
	}
	
	public void createmodel(model ml){
		String sql2 = "insert into model (carid,model) values (?,?)";
		Connection connection = getConnection();
		try {
			PreparedStatement statement2 = connection.prepareStatement(sql2);
			statement2.setInt(1,ml.getCarid());
			statement2.setString(2, ml.getModel());
			statement2.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConnection(connection);
		}
	}
	
	public void createyr(year yr){
		String sql3 = "insert into year (carid,year) values (?,?)";
		Connection connection = getConnection();
		try {
			PreparedStatement statement3 = connection.prepareStatement(sql3);
			statement3.setInt(1,yr.getCarid());
			statement3.setInt(2, yr.getYear());
			statement3.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConnection(connection);
		}
	}

	public List<dummyobj> selectallfavorite(String username){
		String sql = "select * from favorite where userfavfk=?";
		String sql1 = "select * from make where model=?";
		String sql2 = "select * from model where carid=?";
		String sql3 = "select * from year where carid=?";
		Connection connection = getConnection();
		List<dummyobj> ds=new ArrayList<dummyobj>();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				int carid = results.getInt("favoriteid");
				dummyobj dummy=selectallfavoriteone(carid, username);
				ds.add(dummy);
			}	return ds;		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("select all friend");
		return null;
	}
	
	public dummyobj selectallfavoriteone(int carid, String username){
		String sql2 = "select * from make where model=?";
		String sql1 = "select * from model where carid=?";
		String sql3 = "select * from year where carid=?";
		Connection connection = getConnection();
		String make=null;
		String model=null;
		int year=0;
		
		try {
			PreparedStatement statement1 = connection.prepareStatement(sql1);
			statement1.setInt(1, carid);
			ResultSet results1 = statement1.executeQuery();
			if(results1.next()) {
				model = results1.getString("model");
				PreparedStatement statement2 = connection.prepareStatement(sql2);
				statement2.setString(1, model);
				ResultSet results2 = statement2.executeQuery();
				if(results2.next()) {
					make = results2.getString("make");
				}
			}
			PreparedStatement statement3 = connection.prepareStatement(sql3);
			statement3.setInt(1, carid);
			ResultSet results3 = statement3.executeQuery();
			if(results3.next()) {
				year = results3.getInt("year");
			}
			Favorite favorite= new Favorite(carid,username);
			make mk=new make(model,make);
			model ml=new model(carid,model);
			year yr=new year(carid,year);
			dummyobj dummy=new dummyobj(favorite,mk,ml,yr);
			return dummy;		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}