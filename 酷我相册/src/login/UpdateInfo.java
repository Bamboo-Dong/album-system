package login;

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

/**
 * Servlet implementation class UpdateInfo
 */
public class UpdateInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Tb_Userinfo user=null;
		Connection conn = null;
		String sql;
		String url = "jdbc:mysql://localhost:3306/kuwoalbum?"
				+"user=kuwo&password=1234";//��������������ַ��������⣺Ϊʲô�˿ںű�����3306��һ��ʼ��ʹ�õ���8080�������MySQLFail���쳣��
		
		user = new Tb_Userinfo();
		PrintWriter output = res.getWriter();
		user.setAccount(req.getParameter("account"));
		user.setName(req.getParameter("name"));
		user.setQq(req.getParameter("qq"));
		res.setContentType("text/html");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);
			sql="update tb_userinfo set name=?,qq=? where account=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,user.getName());
			ps.setString(2,user.getQq());
			ps.setString(3,user.getAccount());
			ps.executeUpdate();
			req.getRequestDispatcher("create-album.jsp").forward(req, res);
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
