package login;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class Tb_userinfo1
 */
public class Tb_userinfo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tb_userinfo1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Connection conn = null;
		String sql,account,password;
		String url = "jdbc:mysql://localhost:3306/kuwoalbum?"
				+"user=kuwo&password=1234";//定义连接所需的字符串。问题：为什么端口号必须是3306？一开始我使用的是8080，会出现MySQLFail的异常。
		
		account  = req.getParameter("account");
		password  = req.getParameter("password");
		PrintWriter output = res.getWriter();
		res.setContentType("text/html");
		try{
			Class.forName("com.mysql.jdbc.Driver");//加载JDBC驱动程序。问题：为何JDBC驱动要放在WEB-INF/lib下？控制台程序加载驱动方式和它有点不一样。
			//.jar 文件一般都放在项目的web-inf/lib目录下 ，放在这个目录下表示只有当前项目(web应用程序)可用； 
			//还可以放在TOMCAT的common/lib,server/lib,shared/lib目录下； 
			//在server/lib目录下只能被tomcat服务器访问； 
			//在shared/lib目录下只能被所有web应用程序访问； 
			//在common/lib目录下则可被tomcat和所有web应用程序访问；
			conn = DriverManager.getConnection(url);//创建数据库连接
			sql = "select * from tb_userinfo where account=?";
			PreparedStatement pstm = conn.prepareStatement(sql);//创建Statement对象
			//Scanner in = new Scanner(System.in);//创建输入对象
			//System.out.print("请输入用户名：");
			//account = in.next();
			//System.out.print("请输入密码：");
			//password = in.next();
			
			//注意！！！使用Statement与PreparedStatement时，xiang5mk的能否登录
			pstm.setString(1, account);
			ResultSet rs = pstm.executeQuery();//返回包含给定查询所生成数据的 ResultSet 对象；永远不能为 null，如果没有查询到信息，返回一个next()为false的ResultSet 对象
			if(rs.next()!=false){
				if(rs.getString("password").equals(password)){//比较两个字符串是否相同，不可以像C语言一般使用"=="
					//System.out.println("登录成功！");
					req.getSession().setAttribute("account", account);
					req.getRequestDispatcher("index.jsp").forward(req, res);
				}else{
					//System.out.println("密码错误！登录失败！");
					req.getRequestDispatcher("login-error.jsp").forward(req, res);
				}
			}else{
				//System.out.println("用户名不存在！");
				//req.setAttribute("info", "用户名不存在！");
				req.getRequestDispatcher("login-error.jsp").forward(req, res);
			}
		}catch(ClassNotFoundException e){
			//System.out.println("没有找到数据库驱动！");
			output.println("<h3>NotFoundDrive!</h3>");
			e.printStackTrace();
		}catch(SQLException e){
			//System.out.println("MySQL操作错误");
			output.println("<h3>MySQLfail!</h3>");
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//conn.close();//关闭数据库。有问题，为什么这个语句在控制台程序中可以运行，在web程序中却要加下面的那段语句？
			if (conn != null){
				try{
					conn.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}// TODO Auto-generated method stub
	}
	
}

//在HTML中id和name有什么区别？
