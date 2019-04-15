package com.test.main;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.SignatureException;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.weather.dao.CityDao;
import com.weather.dao.DbHelper;
import com.weather.util.LineUtil;

public class TestMain {
/*    private String TIANQI_DAILY_WEATHER_URL = "https://api.seniverse.com/v3/weather/daily.json";
    private static String TIANQI_HOURLY_WEATHER_URL = "https://api.seniverse.com/v3/weather/hourly.json";

    private static String TIANQI_API_SECRET_KEY = "SC21Vv4TLY2SiVF54"; //

    private static String TIANQI_API_USER_ID = "PkrAQsX1aJrCjqp6i"; //
	
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
	
	


    *//**
     * Generate HmacSHA1 signature with given data string and key
     * @param data
     * @param key
     * @return
     * @throws SignatureException
     *//*
    private static String generateSignature(String data, String key) throws SignatureException {
        String result;
        try {
            // get an hmac_sha1 key from the raw key bytes
            SecretKeySpec signingKey = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA1");
            // get an hmac_sha1 Mac instance and initialize with the signing key
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);
            // compute the hmac on input data bytes
            byte[] rawHmac = mac.doFinal(data.getBytes("UTF-8"));
            result = new sun.misc.BASE64Encoder().encode(rawHmac);
        }
        catch (Exception e) {
            throw new SignatureException("Failed to generate HMAC : " + e.getMessage());
        }
        return result;
    }
    
    public String generateGetDiaryWeatherURL(
            String location,
            String language,
            String unit,
            String start,
            String days
    )  throws SignatureException, UnsupportedEncodingException {
        String timestamp = String.valueOf(new Date().getTime());
        String params = "ts=" + timestamp + "&ttl=30&uid=" + TIANQI_API_USER_ID;
        String signature = URLEncoder.encode(generateSignature(params, TIANQI_API_SECRET_KEY), "UTF-8");
        return TIANQI_DAILY_WEATHER_URL + "?" + params + "&sig=" + signature + "&location=" + location + "&language=" + language + "&unit=" + unit + "&start=" + start + "&days=" + days;
    }
    
    //24小时逐小时天气预报
    public static String generateGetHourlyWeather(
            String location,
            String language,
            String unit,
            String start,
            String hours
    	    )  throws SignatureException, UnsupportedEncodingException {
        String timestamp = String.valueOf(new Date().getTime());
        String params = "key=" + TIANQI_API_SECRET_KEY;
        String signature = URLEncoder.encode(generateSignature(params, TIANQI_API_SECRET_KEY), "UTF-8");
		return TIANQI_HOURLY_WEATHER_URL + "?" + params + "&location=" + location + "&language=" + language + "&unit=" + unit + "&start=" + start + "&days=" + hours;
    }
    
    
	public static void main(String argvs[]) throws Exception {
		CityDao cityDao = new CityDao();
		TestMain demo = new TestMain();
		DbHelper dbHelper = cityDao.createDbHelper();
		dbHelper.createConnection();
		String hourly;
		String url = demo.generateGetDiaryWeatherURL(                    
					"beijing",   //城市信息
                    "zh-Hans",   //语言信息
                    "c",            //c 表示摄氏度， f表示华氏度
                    "0",           //0 表示今天，1表示明天，-1表示昨天（收费）
                    "2");
		String hour = demo.generateGetHourlyWeather("guangzhou", "zh-Hans", "c", "0", "24");
		String daily = LineUtil.getJsonStr(url);
		hourly = LineUtil.getJsonStr(hour);
		System.out.println(hourly);
		//List hourly_weather = WeatherUtil.getHourlyWeathers("广州");
		//System.out.println(hourly_weather);
	}*/
	
	
}
