package dao;
/*
 * ������ɾ�����
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.jsp.jstl.sql.Result;

import util.DBenv;

public class Tb_AlbumDao {
	Connection conn = null;
	PreparedStatement pre = null;
	ResultSet res = null;
	Statement sta = null;
	Result result = null;
	
	//������
	public void add_album(Object[] par){
		conn = DBenv.getConn();
		String sql = "insert into tb_album values (?,,)";
		try{
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
	//ɾ�����
	public void del_album(Object[] par) {
		conn = DBenv.getConn();
		String sql = "delete [tb_album] where [id]=?";
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
