package com.ui.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.test.main.TestLine;
import com.ui.panel.DailyWeatherGrid;
import com.ui.panel.SettingPanel;
import com.weather.model.Daily_Weather;
import com.weather.model.Hourly_Weather;
import com.weather.model.Now_Weather;

/**
 * 主界面
 * @author tong
 *
 */
public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private SettingPanel settingPanel;
	private JPanel hourlyWeatherPanel;
	private JPanel dailyWeatherPanel;
	private JPanel chartPanle;
	private final JLabel DATA_SOURCE_LABEL = new JLabel("数据来源于和风天气");
	String series1 = "最高温度";
	String series2 = "最低温度";
	
	String type1 = "今天";
	String type2 = "明天";
	String type3 = "后天";
	
	private static Daily_Weather daily_Weather;
	
	public MainFrame() {
		// TODO Auto-generated constructor stub
		this.setTitle("天气预报");
		this.setSize(1000, 600);
		this.setIconImage(new ImageIcon("image/icon.png").getImage());
		//居中显示
		this.setLocationRelativeTo(null);
		//点击关闭按钮关闭
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		
		this.setLayout(new BorderLayout(5, 10));
		
		settingPanel = new SettingPanel(this);
		hourlyWeatherPanel = new JPanel();
		dailyWeatherPanel = new JPanel();
		chartPanle = new JPanel();
		this.add(settingPanel,BorderLayout.NORTH);

		this.settingPanel.updateAuto_ip();		
		
	}
	


	/**
	 * 刷新天气信息显示面板
	 * @param now_Weather
	 * @param hourly_Weathers
	 * @param daily_Weathers
	 */
	public void setWeatherInfo(Now_Weather now_Weather, List<Hourly_Weather> hourly_Weathers, List<Daily_Weather> daily_Weathers, String location) {
		
		this.remove(hourlyWeatherPanel);
		this.remove(dailyWeatherPanel);
		this.remove(chartPanle);
		
		hourlyWeatherPanel = new JPanel();
		dailyWeatherPanel = new JPanel();
		chartPanle = new JPanel();
		
		chartPanle.setLayout(new GridLayout(1,8,5,0));
		chartPanle.setSize(new Dimension(1200, 300));
		

		TestLine test = new TestLine();
		
		
		
		this.add(chartPanle,BorderLayout.CENTER);
		chartPanle.updateUI();	//刷新UI
		chartPanle.repaint();	//重绘
		
		//String location = settingPanel.updateWeatherInfo();
		System.out.println("testtesttesttest ++++++++ !!!!!!!!!!" + location);
		chartPanle.add(test.creatFrame(location));
		
		if(daily_Weathers != null) {
			dailyWeatherPanel.setLayout(new GridLayout(4, 1, 0, 5));
			dailyWeatherPanel.setPreferredSize(new Dimension(1000, 200));
			for(Daily_Weather daily_Weather : daily_Weathers) {
				dailyWeatherPanel.add(new DailyWeatherGrid(daily_Weather));
			}
			JPanel panel = new JPanel();
			panel.setLayout(new FlowLayout(FlowLayout.RIGHT,10,25));
			JLabel updateTimeLabel = new JLabel("更新时间:"+now_Weather.getLocationAndUpdateTime().getLoc());
			panel.add(updateTimeLabel);
			panel.add(DATA_SOURCE_LABEL);
			dailyWeatherPanel.add(panel);
		}	
		this.add(dailyWeatherPanel, BorderLayout.SOUTH);
		dailyWeatherPanel.updateUI();
		dailyWeatherPanel.repaint();
	}
}