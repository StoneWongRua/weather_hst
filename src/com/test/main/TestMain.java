package com.test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.UnsupportedLookAndFeelException;

import com.ui.frame.MainFrame;

public class TestMain {
/*	
	public Statement stmt = null;
	public ResultSet rs = null;
	private static final String URL="jdbc:mysql://localhost:3306/tong_music?useSSL=false";
	private static final String NAME="root";
	private static final String PASSWORD="root";
	private static Connection conn=null;//将加载驱动、连接数据库放入静态块中
	static{
		try {
				//加载驱动程序
				Class.forName("com.mysql.jdbc.Driver");
				
				//获得数据库的连接
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
	
	//获取数据库连接
	public static Connection getConnection(){
		try {
			conn = DriverManager.getConnection(URL, NAME, PASSWORD);
			System.out.println("数据库连接成功XD");
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库连接失败.");
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static void main(String[] args){
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
			new MainFrame().setVisible(true);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			int status = 0;
			String provinceName= "guangdong";
			String sql = null;
			//sql = "select CityChinese from city WHERE ProvinceChinese= '" + provinceName +"' and SuperiorCityChinese = CityChinese";
			//sql = "select * from city WHERE ProvinceChinese= '" + provinceName + "'";
			
			Connection testCon = getConnection();
			Statement stm = testCon.createStatement();
			sql = "select * from city WHERE ProvinceEnglish=\"guangdong\"";
			ResultSet rs = stm.executeQuery(sql);
			System.out.println(rs.next());
		      while(rs.next()){
		          //Retrieve by column name
		    	  String city = rs.getString("cityChinese");
		          //Display values
		          System.out.print(city);
		       }
		       rs.close();
		    }catch(SQLException se){
		       //Handle errors for JDBC
		       se.printStackTrace();
		    
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		CityDao cityDao = new CityDao();
		System.out.println(cityDao.getCityName("广东"));
		String sql = "select CityChinese from city WHERE ProvinceChinese=? and SuperiorCityChinese = CityChinese";
		String provinceName = "广东";
		DbHelper dbHelper = cityDao.createDbHelper();
		dbHelper.createConnection();
		System.out.println(cityDao.getCityName("广东"));
		Map<String, Object> param = new LinkedHashMap<String, Object>();
		param.put("ProvinceChinese", provinceName);
		ResultSet resultSet = dbHelper.query(sql, param);
		ResultSet rs = dbHelper.query_hst(sql, provinceName);
		System.out.println("test"  + resultSet.next());
		System.out.println("hst" + rs.next());
	}
	
	
*/
}
