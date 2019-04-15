package com.test.main;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestDraw {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int frameWidth = 800;  //frame宽度
        int frameHeight = 800; //frame高度
        int[] highTemperature = {28,27,32,30,31,27,27,27,28,28}; // 最高气温列表
        int[] lowTemperature = {19,19,19,18,20,18,16,15,16,19};  // 最低气温列表
        /*
         * JFrame 界面设置
         */
        JFrame windowmenu=new JFrame("温度显示界面");
        windowmenu.setVisible(true);
        windowmenu.setSize(frameWidth,frameHeight);    
        Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
        Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
        int screenWidth = screenSize.width; //获取屏幕的宽
        int screenHeight = screenSize.height; //获取屏幕的高
        windowmenu.setLocation(screenWidth/2-frameWidth/2, screenHeight/2-frameHeight/2);//设置窗口居中显示 
        windowmenu.setResizable(false);
        windowmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        /*
         * Panel1 格式设置
         */
        textLabel label10 = new textLabel("当天最高温度",Color.BLACK,40);
        textLabel label11 = new textLabel("°C",Color.BLACK,40);
        numLabel label13 = new numLabel(String.valueOf(highTemperature[highTemperature.length-1]),Color.RED,50);
        JPanel mypanel1 = new JPanel();
        mypanel1.setLayout(new GridLayout(1,3,1,1));
        mypanel1.add(label10);
        mypanel1.add(label13);
        mypanel1.add(label11);    
        /*
         * Panel2 格式设置
         */
        textLabel label20 = new textLabel("当天最低温度",Color.BLACK,40);
        textLabel label21 = new textLabel("°C",Color.BLACK,40);
        numLabel label23 = new numLabel(String.valueOf(lowTemperature[lowTemperature.length-1]),Color.BLUE,50);
        JPanel mypanel2 = new JPanel();
        mypanel2.setLayout(new GridLayout(1,2,1,1));
        mypanel2.add(label20);
        mypanel2.add(label23);
        mypanel2.add(label21);
        /*
         * Panel3格式设置
         * 将Panel1和Panel2放在一起构成Panel3
         */
        JPanel mypanel3 = new JPanel();
        mypanel3.setLayout(new GridLayout(2,1,1,1));
        mypanel3.add(mypanel1);
        mypanel3.add(mypanel2);    
        /*
         * Panel4格式设置
         * 在Panel4中放置历史温度曲线
         */
        JPanel mypanel4 = new JPanel();
        mypanel4.setLayout(new GridLayout(1,1,1,1));
        DrawPicture picture = new DrawPicture(frameWidth,frameHeight,highTemperature,lowTemperature);
        // 将Fram的尺寸作为picture尺寸的参考
        mypanel4.add(picture);
        /*
         *温度显示布局
         */
        windowmenu.setLayout(new GridLayout(0,1,5,5));
        windowmenu.add(mypanel3);
        windowmenu.add(mypanel4);
    }
}