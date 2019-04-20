package com.test.main;

import java.awt.Color;
import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.category.CategoryDataset;

import com.weather.model.Daily_Weather;
import com.weather.util.LineUtil;

public class TestLine {
	
	private static Daily_Weather daily_Weather;
	

	
	public static ChartPanel creatFrame(String location) {
		Daily_Weather daily_weather = new Daily_Weather();
		Font font = new Font("等线", 1, 15);
		StandardChartTheme mChartTheme = new StandardChartTheme("CN");
		mChartTheme.setLargeFont(font);
		mChartTheme.setExtraLargeFont(font);
		mChartTheme.setRegularFont(font);
		
		ChartFactory.setChartTheme(mChartTheme);
		//String location = "auto_ip";
		LineUtil lineutil = new LineUtil();
		CategoryDataset mDataset = lineutil.GetDataset(daily_Weather,location);
		System.out.println("testtesttesttest ++++++++ ???????" + location);
        JFreeChart mChart = ChartFactory.createLineChart(
                "",//图名字
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
        mPlot.setAxisOffset(new RectangleInsets(20D, 20D, 20D, 20D));
        mPlot.setNoDataMessage("没有相关统计数据");
        
        ValueAxis axis = mPlot.getRangeAxis();
        axis.setAutoRange(true);
        
        mPlot.getRangeAxis().setUpperMargin(0.1);// 左边距 边框距离
        mPlot.getRangeAxis().setLowerMargin(0.1);// 右边距 边框距离
        //mPlot.getRangeAxis().setMaximumCategoryLabelLines(100);
        //mPlot.getRangeAxis().setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);
        
        

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
	

	

}
