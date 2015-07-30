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
				+"user=kuwo&password=1234";//��������������ַ��������⣺Ϊʲô�˿ںű�����3306��һ��ʼ��ʹ�õ���8080�������MySQLFail���쳣��
		
		account  = req.getParameter("account");
		password  = req.getParameter("password");
		PrintWriter output = res.getWriter();
		res.setContentType("text/html");
		try{
			Class.forName("com.mysql.jdbc.Driver");//����JDBC�����������⣺Ϊ��JDBC����Ҫ����WEB-INF/lib�£�����̨�������������ʽ�����е㲻һ����
			//.jar �ļ�һ�㶼������Ŀ��web-inf/libĿ¼�� ���������Ŀ¼�±�ʾֻ�е�ǰ��Ŀ(webӦ�ó���)���ã� 
			//�����Է���TOMCAT��common/lib,server/lib,shared/libĿ¼�£� 
			//��server/libĿ¼��ֻ�ܱ�tomcat���������ʣ� 
			//��shared/libĿ¼��ֻ�ܱ�����webӦ�ó�����ʣ� 
			//��common/libĿ¼����ɱ�tomcat������webӦ�ó�����ʣ�
			conn = DriverManager.getConnection(url);//�������ݿ�����
			sql = "select * from tb_userinfo where account=?";
			PreparedStatement pstm = conn.prepareStatement(sql);//����Statement����
			//Scanner in = new Scanner(System.in);//�����������
			//System.out.print("�������û�����");
			//account = in.next();
			//System.out.print("���������룺");
			//password = in.next();
			
			//ע�⣡����ʹ��Statement��PreparedStatementʱ��xiang5mk���ܷ��¼
			pstm.setString(1, account);
			ResultSet rs = pstm.executeQuery();//���ذ���������ѯ���������ݵ� ResultSet ������Զ����Ϊ null�����û�в�ѯ����Ϣ������һ��next()Ϊfalse��ResultSet ����
			if(rs.next()!=false){
				if(rs.getString("password").equals(password)){//�Ƚ������ַ����Ƿ���ͬ����������C����һ��ʹ��"=="
					//System.out.println("��¼�ɹ���");
					req.getSession().setAttribute("account", account);
					req.getRequestDispatcher("index.jsp").forward(req, res);
				}else{
					//System.out.println("������󣡵�¼ʧ�ܣ�");
					req.getRequestDispatcher("login-error.jsp").forward(req, res);
				}
			}else{
				//System.out.println("�û��������ڣ�");
				//req.setAttribute("info", "�û��������ڣ�");
				req.getRequestDispatcher("login-error.jsp").forward(req, res);
			}
		}catch(ClassNotFoundException e){
			//System.out.println("û���ҵ����ݿ�������");
			output.println("<h3>NotFoundDrive!</h3>");
			e.printStackTrace();
		}catch(SQLException e){
			//System.out.println("MySQL��������");
			output.println("<h3>MySQLfail!</h3>");
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//conn.close();//�ر����ݿ⡣�����⣬Ϊʲô�������ڿ���̨�����п������У���web������ȴҪ��������Ƕ���䣿
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

//��HTML��id��name��ʲô����
