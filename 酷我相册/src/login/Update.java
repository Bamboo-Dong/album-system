/*
 * 
 */

package login;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class Tb_userinfo1
 */
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Tb_Userinfo user=null;
		Connection conn = null;
		String sql;
		String url = "jdbc:mysql://localhost:3306/kuwoalbum?"
				+"user=kuwo&password=1234";//定义连接所需的字符串。问题：为什么端口号必须是3306？一开始我使用的是8080，会出现MySQLFail的异常。
		
		user = new Tb_Userinfo();
		PrintWriter output = res.getWriter();
		user.setAccount(req.getParameter("account"));
		user.setPassword(req.getParameter("password"));
		res.setContentType("text/html");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);
			sql="update tb_userinfo set password=? where account=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,user.getPassword());
			ps.setString(2,user.getAccount());
			ps.executeUpdate();
			req.getRequestDispatcher("password-succeed.jsp").forward(req, res);
		}catch(ClassNotFoundException e){
			output.println("<h3>NotFoundDrive!</h3>");
			e.printStackTrace();
		}catch(SQLException e){
			output.println("<h3>MySQLfail!</h3>");
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (conn != null){
				try{
					conn.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}