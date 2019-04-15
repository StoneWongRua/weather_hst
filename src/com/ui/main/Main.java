package com.ui.main;

import java.sql.ResultSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.UnsupportedLookAndFeelException;

import com.ui.frame.MainFrame;
import com.weather.dao.CityDao;
import com.weather.dao.DbHelper;
import com.weather.util.WeatherUtil;

public class Main {

/*	public static void main(String[] args) throws Exception {
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
			new MainFrame().setVisible(true);
			//List hourly_weather = WeatherUtil.getHourlyWeathers("广州");
			//System.out.println("test hour : " +hourly_weather);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
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
	}*/

	
		

}
