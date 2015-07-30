package util;

import java.sql.*;

public class DataBaseConnection {
    private final String DBDRIVER="com.mysql.jdbc.Driver";
    private final String DBURL="jdbc:mysql://localhost/kuwophoto?useUnicode=false&characterEncoding=gb2312";
    private final String DBUSER="root";
    private final String DBPASSWORD="root";
    private Connection conn =null;
    /** Creates a new instance of DatabaseConnection */
    public DataBaseConnection() {
        try{
        	Class.forName(DBDRIVER);
        	this.conn=DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
        }
       catch(Exception e){
       }
   }
    //ȡ�����ݿ�����
    public Connection getConnection(){
    	return this.conn;
    }
    //�ر����ݿ�����
    public void close()
    {
    	try{
    		this.conn.close();
    	}
    	catch(Exception e){
    	}
    }   
}