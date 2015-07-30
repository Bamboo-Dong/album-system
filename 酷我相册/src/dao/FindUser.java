package dao;

import java.sql.*;

import model.Tb_Userinfo;

public class FindUser {
	static Connection conn;
	static Statement st;
	
	static private Tb_Userinfo aUser;
	
	static private String url = "jdbc:mysql://127.0.0.1/information";
	static private String forName = "com.mysql.jdbc.Driver";
	
	public static Connection initialize() {
		try{
			Class.forName(forName);
			conn = DriverManager.getConnection(url,"root","");
			st = conn.createStatement();
			
		}
		catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		catch (SQLException e) {
			System.out.println(e);
		}
		return conn;
	}

	public static Tb_Userinfo find(String key) throws Exception {
		String sql = "select account,name,password from register"
				+ "where account ='"+ key +"'";
	
		try {
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()){
				aUser.setAccount(rs.getString("account"));
				aUser.setName(rs.getString("name"));
				aUser.setQq(rs.getString("password"));
			
				aUser = new Tb_Userinfo();
			}
			rs.close();
		}
		catch (SQLException e) {
			System.out.println(e);
		}
		return aUser;
	}
}
	







