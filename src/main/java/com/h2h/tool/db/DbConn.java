package com.h2h.tool.db;

import java.sql.*;

public class DbConn {
	//定义一个连接对象
	private Connection conn= null;
	private String driver = "com.mysql.jdbc.Driver";
	//定义连接数据库的url资源
	private String url = "jdbc:mysql://127.0.0.1:3306/test";
	//定义连接数据库的用户名和密码
	private String userName = "root";
	private String passWord = "root";
//	private Connection conn= null;
//	private String driver = "oracle.jdbc.driver.OracleDriver";
//	//定义连接数据库的url资源
//	private String url = "jdbc:oracle:thin:@192.168.80.111:1521:orcl";
//	//定义连接数据库的用户名和密码
//	private String userName = "root";
//	private String passWord = "root";
	
	//加载数据库连接驱动
	public Connection getConnection(){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userName, passWord);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//关闭数据库
	public void closeALL(Connection conn, Statement st, ResultSet rs, PreparedStatement pst) {
	    try {
	      if (rs != null) {
	        rs.close();
	      }
	      if (st != null) {
	        st.close();
	      }
	      if (conn != null) {
	        conn.close();
	      }
	      if (pst != null)
	        pst.close();
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	
	
}
