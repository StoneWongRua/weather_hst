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
		this.add(settingPanel,BorderLayout.NORTH);

		this.settingPanel.updateAuto_ip();		
		
	}
	

/*	public static ChartPanel creatFrame() {
		Daily_Weather daily_weather = new Daily_Weather();
		Font font = new Font("微软雅黑", 1, 15);
		StandardChartTheme mChartTheme = new StandardChartTheme("CN");
		mChartTheme.setLargeFont(font);
		mChartTheme.setExtraLargeFont(font);
		mChartTheme.setRegularFont(font);
		
		ChartFactory.setChartTheme(mChartTheme);
		CategoryDataset mDataset = GetDataset(daily_Weather);
        JFreeChart mChart = ChartFactory.createLineChart(
                "未来三天气温趋势",//图名字
                "",//横坐标
                "",//纵坐标
                mDataset,//数据集
                PlotOrientation.VERTICAL,
                true, // 显示图例
                true, // 采用标准生成器
                false);// 是否生成超链接
		
        CategoryPlot mPlot = (CategoryPlot)mChart.getPlot();
        mPlot.setBackgroundAlpha(0.1f);
        mPlot.setAxisOffset(new RectangleInsets(10D, 10D, 10D, 10D));
        mPlot.setNoDataMessage("没有相关统计数据");
        

		LineAndShapeRenderer renderer = (LineAndShapeRenderer)mPlot.getRenderer();
		renderer.setDefaultShapesVisible(true); // series 点（即数据点）可见
		renderer.setDefaultLinesVisible(true); // series 点（即数据点）间有连线可见
		renderer.setUseSeriesOffset(true); // 设置偏移量
		renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setDefaultItemLabelsVisible(true);
        
        NumberAxis rangeAxis = (NumberAxis) mPlot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());// 设置图中的刻度线的单位
        
        ChartPanel mChartFrame = new ChartPanel(mChart);
        //mChartFrame.pack();
        //mChartFrame.setVisible(true);
		return mChartFrame;
		
	}
	

	public static CategoryDataset GetDataset(Daily_Weather daily_Weather) {
		// TODO Auto-generated method stub
		
		String series1 = "最高温度";
		String series2 = "最低温度";
		
		String type1 = "今天";
		String type2 = "明天";
		String type3 = "后天";
		
		//DailyChartGrid.daily_Weather = daily_Weather;
		DefaultCategoryDataset mDataset = new DefaultCategoryDataset();
		//List<Hourly_Weather> hourly_Weathers = WeatherUtil.getHourlyWeathers("auto_ip");
		List<Daily_Weather> daily_Weathers = WeatherUtil.getDailyWeathers("auto_ip");
		
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
		linedataset.addValue(Integer.parseInt(daily_Weather.getTmp_max()), series1, type1);
		linedataset.addValue(int_2, series1, type2);
		linedataset.addValue(int_3, series1, type3);
		linedataset.addValue(int_11, series2, type1);
		linedataset.addValue(int_12, series2, type2);
		linedataset.addValue(int_13, series2, type3);
		return linedataset;
	}
*/
	/**
	 * 刷新天气信息显示面板
	 * @param now_Weather
	 * @param hourly_Weathers
	 * @param daily_Weathers
	 */
	public void setWeatherInfo(Now_Weather now_Weather, List<Hourly_Weather> hourly_Weathers, List<Daily_Weather> daily_Weathers) {
		
		this.remove(hourlyWeatherPanel);
		this.remove(dailyWeatherPanel);
		
		hourlyWeatherPanel = new JPanel();
		dailyWeatherPanel = new JPanel();
		chartPanle = new JPanel();
		
		chartPanle.setLayout(new GridLayout(1,8,5,0));
		chartPanle.setSize(new Dimension(1200, 300));
		

		TestLine test = new TestLine();
		chartPanle.add(test.creatFrame());
		
		this.add(chartPanle,BorderLayout.CENTER);
		chartPanle.updateUI();	//刷新UI
		chartPanle.repaint();	//重绘
		
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