package com.test.main;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.weather.model.Daily_Weather;
import com.weather.model.Now_Weather;
import com.weather.util.WeatherUtil;

public class TestLine {
	
	private static Daily_Weather daily_Weather;
	

	
	public static ChartPanel creatFrame() {
		Daily_Weather daily_weather = new Daily_Weather();
		Font font = new Font("微软雅黑", 1, 15);
		StandardChartTheme mChartTheme = new StandardChartTheme("CN");
		mChartTheme.setLargeFont(font);
		mChartTheme.setExtraLargeFont(font);
		mChartTheme.setRegularFont(font);
		
		ChartFactory.setChartTheme(mChartTheme);
		CategoryDataset mDataset = GetDataset(daily_Weather);
        JFreeChart mChart = ChartFactory.createLineChart(
                "未来三天天气趋势",//图名字
                "",//横坐标
                "",//纵坐标
                mDataset,//数据集
                PlotOrientation.VERTICAL,
                true, // 显示图例
                true, // 采用标准生成器
                false);// 是否生成超链接
		
        CategoryPlot mPlot = (CategoryPlot)mChart.getPlot();
        mPlot.setBackgroundPaint(Color.BLACK);
        //mPlot.setRangeGridlinePaint(Color.BLUE);//背景底部横虚线
        //mPlot.setOutlinePaint(Color.RED);//边界线
        mPlot.setBackgroundAlpha(0);
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
		
		DefaultCategoryDataset mDataset = new DefaultCategoryDataset();
		Now_Weather now_Weather = WeatherUtil.getNowWeather("auto_ip");
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
