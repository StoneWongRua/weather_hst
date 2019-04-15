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

import com.weather.model.Hourly_Weather;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class LineUtil {
	private static final String WEATHER_URL = "https://api.seniverse.com/v3/weather/hourly.json?key=your_api_key&location=beijing&language=zh-Hans&unit=c&start=0&hours=24";
	//"http://t.weather.sojson.com/api/weather/city/";
	
	//返回json字符串数据
	public static String getJsonStr(String url){
		String jsonStr = "";
		try{
		URL realUrl = new URL(url);
		URLConnection connection = realUrl.openConnection();
		connection.connect();
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
		
		String line;
		while((line = reader.readLine()) != null){
			jsonStr += line;
		}
		System.out.println(jsonStr);
		reader.close();
		}catch (Exception e) {  
            System.out.println("发送GET请求出现异常！" + e);  
            //e.printStackTrace();  
			System.out.println("发送GET请求出现异常！请检查网络！");
			return "error";
        }  
		return jsonStr;
	}
	
	//逐小时天气预报，返回List<Hourly_Weather>
	public static List<Hourly_Weather> getHourlyWeathers(String location){
		List<Hourly_Weather> hourly_Weathers = new ArrayList<>();
		StringBuilder parameters = new StringBuilder();
		try {
			parameters.append(URLEncoder.encode(location, "UTF-8").toString());
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String jsonStr = getJsonStr( WEATHER_URL + parameters);
		System.out.println("autoTest: " + parameters);
		String regex = "\\[\\{\"cloud.*?\\]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(jsonStr);
		
		String resultStr = null;
		while(matcher.find()) {
			resultStr = matcher.group(0);
		}
		
		if(resultStr != null) {
			//System.out.println(resultStr);
			JSONArray jsonArray = JSONArray.fromObject(resultStr);
			//json字符串转换成对象数组
			for(int i = 0; i < jsonArray.size(); i++) {
				JSONObject jObject = jsonArray.getJSONObject(i);
				Hourly_Weather hourly_Weather = (Hourly_Weather) JSONObject.toBean(jObject,Hourly_Weather.class);
				//hourly_Weather.setLocationAndUpdateTime(getLocationAndUpdateTime(jsonStr));
				hourly_Weathers.add(hourly_Weather);
				System.out.println(hourly_Weathers);
			}
		}
		return hourly_Weathers;
	}

}
