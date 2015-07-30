package dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.Tb_Userinfo;

/**
 * Servlet implementation class Regist
 */
public class Regist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Regist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Tb_Userinfo user=null;
		Connection conn = null;
		String sql;
		String url = "jdbc:mysql://localhost:3306/kuwoalbum?"
				+"user=kuwo&password=1234";//定义连接所需的字符串。问题：为什么端口号必须是3306？一开始我使用的是8080，会出现MySQLFail的异常。
		
		user = new Tb_Userinfo();
		PrintWriter output = res.getWriter();
		user.setAccount(req.getParameter("username"));
		user.setPassword(req.getParameter("password"));
		user.setName(req.getParameter("name"));
		user.setQq(req.getParameter("email"));
		res.setContentType("text/html");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);
			sql="insert into tb_userinfo values(?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,user.getAccount());
			ps.setString(2,user.getPassword());
			ps.setString(3,user.getName());
			ps.setString(4,user.getQq());
			ps.executeUpdate();
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
			req.getSession().setAttribute("account", user.getAccount());
			req.getRequestDispatcher("index.jsp").forward(req, res);
		}
	}

}
