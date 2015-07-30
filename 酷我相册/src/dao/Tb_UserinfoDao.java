package dao;
/*
 * ÓÃ»§²Ù×÷
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.jsp.jstl.sql.Result;

import util.DBenv;


public class Tb_UserinfoDao {
	Connection conn=null;
	PreparedStatement pre=null;
	ResultSet res=null;
	Statement sta=null;
	Result result=null;
	public void insert_user(Object[] par){
		conn=DBenv.getConn();
		String sql="insert [tb_userinfo] values(?,?,?,?)";
		try {
			pre=conn.prepareStatement(sql);
			DBenv.bind(pre, par);
			pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBenv.closeDB(res, pre, sta, conn);
		}
	}
	
}
