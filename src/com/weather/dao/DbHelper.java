package com.weather.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class DbHelper {
	
	private String driverName;
	private String url;
	private String user;
	private String password;
	
	private static Connection con = null;
	
	private static final String URL="jdbc:mysql://localhost:3306/tong_music?useSSL=false";
	private static final String NAME="root";
	private static final String PASSWORD="root";
	
	public DbHelper(String driverName,String url,String user,String password){
		this.driverName = driverName;
		this.url = url;
		this.user = user;
		this.password = password;
	}
	
	/**
	 * 创建数据库对象
	 * @throws Exception
	 */
	public void createConnection() throws Exception{
		Class.forName(this.driverName);
		this.con = DriverManager.getConnection(this.url,this.user,this.password);
	}
	
	/**
	 * 关闭连接
	 * @throws Exception
	 */
	public void closeConnection() throws Exception {
		if(con==null) return;
		if(con.isClosed()) return;
		this.con.close();
	}
	
	/**
	 * 执行一条没有返回值的sql语句
	 * @param sql
	 * @param param
	 */
	public void execute(String sql,Map<String,Object> param) throws Exception {
		if(this.con==null || this.con.isClosed()){
			throw new Exception("请首先调用createConnection方法创建连接");
		}
		
		PreparedStatement psmt = this.con.prepareStatement(sql);
		
		if(param != null){
			int index = 1;
			for(String key:param.keySet()){
				Object value = param.get(key);
				//System.out.println(index+","+key+"="+value);
				
				psmt.setObject(index, value);

				index++;
			}
		}
		
		psmt.executeUpdate();
	}
	
	/**
	 * 执行一条有返回值的select语句
	 * @return 返回结果集
	 * @param sql sql语句
	 * @param param 哈希图，带入sql语句的参数
	 */
	public ResultSet query(String sql,Map<String,Object> param) throws Exception {
		if(this.con==null || this.con.isClosed()){
			throw new Exception("请首先调用createConnection方法创建连接");
		}
		
		PreparedStatement psmt = this.con.prepareStatement(sql);
		
		if(param != null){
			int index = 1;
			for(String key:param.keySet()){
				Object value = param.get(key);
				psmt.setObject(index, value);
				index++;
			}
		}
		
		ResultSet rs = psmt.executeQuery();
		
		return rs;
	}
	
	/**
	 * 创建一个表
	 */
	public void createTable(String sql,Map<String, Object> param) throws Exception{
		if(this.con==null || this.con.isClosed()){
			throw new Exception("请首先调用createConnection方法创建连接");
			}
		
		PreparedStatement psmt = this.con.prepareStatement(sql);
		if(param != null) {
			int index = 1;
			for(String key:param.keySet()) {
				Object value = param.get(key);
				psmt.setObject(index, value);
				index++;
			}
		}
		
		psmt.executeUpdate();
	}

	public ResultSet query_hst(String sql, String provinceName) throws SQLException, Exception {
		// TODO Auto-generated method stub
		if(this.con==null || this.con.isClosed()){
			throw new Exception("请首先调用createConnection方法创建连接");
		}
		
		PreparedStatement psmt = this.con.prepareStatement(sql);
		

		psmt.setObject(1, provinceName);
		
		ResultSet rs = psmt.executeQuery();
		
		return rs;
	}
	
	//获取数据库连接
	public static Connection getConnection(){
		try {
			con = DriverManager.getConnection(URL, NAME, PASSWORD);
			System.out.println("数据库连接成功XD");
			return con;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库连接失败.");
			e.printStackTrace();
			return null;
		}
	} 
}