package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Tb_Userinfo;
//import chris.bean.User;

public class UserDao {
  public Tb_Userinfo query(String sqlKey, String sqlVal){
        Connection conn = null;
        Tb_Userinfo user = new Tb_Userinfo();
        boolean flag = false;
        
        try {
           String URL = "jdbc:mysql://localhost:3306/kuwophoto";
           Class.forName("com.mysql.jdbc.Driver");
           conn = DriverManager.getConnection(URL, "root", "root");
           String sqlPrefix = "SELECT * FROM user WHERE ";
           String sql = sqlPrefix + sqlKey + " = ?";
           //System.out.println("!!!!SQL:"+sqlPrefix+sqlKey+" = "+sqlVal);
           PreparedStatement ps = conn.prepareStatement(sql);
           ps.setString(1, sqlVal);
           ResultSet rs = ps.executeQuery();

           while (rs.next()) {
          	user.setAccount(rs.getString("account"));
          	user.setPassword(rs.getString("password"));
          	user.setName(rs.getString("name"));
          	user.setQq(rs.getString("qq"));
          	flag = true;
           }
        } catch (Exception e) {
           e.printStackTrace();
        } finally {
           if (conn != null) {
              try {
                 conn.close();
              } catch (Exception e) {
              }
           }
        }
        if(flag)
      	  return user;
        return null;
  }

  public boolean insert(String account, String password,String name,String qq){
        Connection conn = null;
        boolean ok = true;
        try {
           String URL = "jdbc:mysql://localhost:3306/Kuwophoto";
           Class.forName("com.mysql.jdbc.Driver");
           conn = DriverManager.getConnection(URL, "kuwo", "1234");

           /*
           String sql = "INSERT INTO user values(? , ?)";
           PreparedStatement ps = conn.prepareStatement(sql);
           ps.setString(1, username);
           ps.setString(2, password);
           */
           String sql = "insert into user values (?, ?)";
           PreparedStatement ps = conn.prepareStatement(sql);
           ps.setString(1, account);
           ps.setString(2, password);
           ps.setString(3, name);
           ps.setString(4, qq);
           //statement.executeUpdate("INSERT INTO Customers " + "VALUES (1001, 'Simpson', 'Mr.', 'Springfield', 2001)");
           ps.executeUpdate();
        } catch (Exception e) {
           e.printStackTrace();
           ok = false;
        } finally {
           if (conn != null) {
              try {
                 conn.close();
              } catch (Exception e) {
              }
           }
        }
        return ok;
  }
}