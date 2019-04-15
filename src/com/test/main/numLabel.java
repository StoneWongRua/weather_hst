package com.test.main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class numLabel extends JLabel {
    private String str; // 需要显示的字符串
    private Color color; //字体颜色
    private int fontSize; //字体大小
    //private String icon;
    
    public numLabel(){
    }
    public numLabel(String s, Color c, int f){
        this.str = s;
        this.color = c;
        this.fontSize = f;
        //this.icon = "timg.jpg";
        // JLabel label = new JLabel("°C",JLabel.CENTER);
        setText(str);
        setFont(new Font(null,Font.PLAIN,fontSize));
        setBackground(Color.BLACK);
        setForeground(color);
        // setIcon(new ImageIcon(icon));
    }
}