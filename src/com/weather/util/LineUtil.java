package com.weather.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.weather.model.Daily_Weather;
import com.weather.model.Hourly_Weather;
import com.weather.model.Now_Weather;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class LineUtil {
	public static CategoryDataset GetDataset(Daily_Weather daily_Weather, String location) {
		// TODO Auto-generated method stub
		
		String series1 = "最高温度";
		String series2 = "最低温度";
		
		String type1 = "今天";
		String type2 = "明天";
		String type3 = "后天";
		
		DefaultCategoryDataset mDataset = new DefaultCategoryDataset();
		Now_Weather now_Weather = WeatherUtil.getNowWeather(location);
		System.out.println("testtesttesttest !!!!!!!!!!!wwww !!!!!!!!!!" + location);
		//List<Hourly_Weather> hourly_Weathers = WeatherUtil.getHourlyWeathers("auto_ip");
		List<Daily_Weather> daily_Weathers = WeatherUtil.getDailyWeathers(location);
		System.out.println("test daily weather 1 :" + daily_Weathers.get(1).getTmp_max());
		String max_1 = daily_Weathers.get(0).getTmp_max();
		String max_2 = daily_Weathers.get(1).getTmp_max();
		String max_3 = daily_Weathers.get(2).getTmp_max();
		int int_1 = Integer.parseInt(max_1);
		int int_2 = Integer.parseInt(max_2);
		int int_3 = Integer.parseInt(max_3);
		int int_11 = Integer.parseInt(daily_Weathers.get(0).getTmp_min());
		int int_12 = Integer.parseInt(daily_Weathers.get(1).getTmp_min());
		int int_13 = Integer.parseInt(daily_Weathers.get(2).getTmp_min());
		System.out.println("int_1:" + int_1);
		System.out.println("int_2:" + int_2);
		System.out.println("int_3:" + int_3);
		
		DefaultCategoryDataset linedataset = new DefaultCategoryDataset();
		linedataset.addValue(int_1, series1, type1);
		linedataset.addValue(int_2, series1, type2);
		linedataset.addValue(int_3, series1, type3);
		linedataset.addValue(int_11, series2, type1);
		linedataset.addValue(int_12, series2, type2);
		linedataset.addValue(int_13, series2, type3);
		//linedataset.addValue(2.0, series3, type1);
		//linedataset.addValue(9.2, series3, type2);
		//linedataset.addValue(8.9, series3, type3);
		
        //System.out.println(mDataset.getValue("today", "今天"));
        
		//System.out.println(daily_Weather.getTmp_max());
		//mDataset.addValue(1, daily_Weather.getTmp_max(), daily_Weather.getTmp_min());
		//mDataset.addValue(1, "First", "2013");
		return linedataset;
	}
}
