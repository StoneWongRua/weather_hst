package com.weather.dao;

public class BaseDao {
	
	protected String driver_name = "com.mysql.jdbc.Driver";
	protected String db_url = "jdbc:mysql://localhost:3306/tong_music?useSSL=false&useUnicode=true&characterEncoding=UTF-8";
	protected String db_user = "root";
	protected String db_pwd = "root";
	
	public DbHelper createDbHelper(){
		try {
			DbHelper dbHelper = new DbHelper(driver_name,db_url,db_user,db_pwd);
			return dbHelper;
		} catch (Exception e) {
			System.out.println("数据库连接异常");
		}
		return null;
	}
}