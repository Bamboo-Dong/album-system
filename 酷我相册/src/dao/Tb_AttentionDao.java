package dao;
/*
 * 关注操作
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.jsp.jstl.sql.Result;

import util.DBenv;

public class Tb_AttentionDao {
	Connection conn = null;
	PreparedStatement pre = null;
	ResultSet res = null;
	Statement sta = null;
	Result result = null;
	
	//关注好友
	public void insert_attention(Object[] par) {
		conn = DBenv.getConn();
		String sql = "insert [tb_attention] values(?,?,?)";
		try {
			pre = conn.prepareStatement(sql);
			DBenv.bind(pre, par);
			pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBenv.closeDB(res, pre, sta, conn);
		}
	}
	
	//取消关注
	public void del_attention(Object[] par) {
		conn = DBenv.getConn();
		String sql = "delete [tb_attention] where [id]=? and [attentionaccount]=?";
		try {
			pre = conn.prepareStatement(sql);
			DBenv.bind(pre, par);
			pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBenv.closeDB(res, pre, sta, conn);
		}
	}

}
