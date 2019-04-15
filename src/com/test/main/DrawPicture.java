package com.test.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

/*
 * 绘制温度历史曲线类
 */
public class DrawPicture extends JPanel{
    private int width; //JFrame面板宽度
    private int height; //JFrame面板高度
    private int offSet = 50; //位置偏置
    private int[] highTemperature;// {28,27,32,30,31,27,27,27,28,28};
    private int[] lowTemperature;// {19,19,19,18,20,18,16,15,16,19};
    public DrawPicture(){
        
    }
    public DrawPicture(int w,int h,int[] hT, int[] lT){
        this.width = w;
        this.height = h;
        this.highTemperature = hT;
        this.lowTemperature = lT;
    }
    public void paint(Graphics g) {
    super.paint(g);
    g.setColor(Color.BLACK);
    g.setFont(new Font(null,Font.BOLD,30));
    
    g.drawLine(offSet, height/2-offSet, width-offSet, height/2-offSet); // x轴
    g.drawLine(offSet, height/2-offSet, offSet, 0); //y轴
    g.drawString("历史温度曲线", width/2-2*offSet, height/2-2*offSet);
    for(int i=0;i<9;i++){
        g.setColor(Color.RED);
        g.setFont(new Font(null,Font.BOLD,30));
        g.drawLine(i*70+50,300-highTemperature[i]*8,(i+1)*70+50,300-highTemperature[i+1]*8);
    }
    for(int i=0;i<9;i++){
        g.setColor(Color.BLUE);
        g.setFont(new Font(null,Font.BOLD,30));
        g.drawLine(i*70+50,300-lowTemperature[i]*8,(i+1)*70+50,300-lowTemperature[i+1]*8);
    }
    }
}

