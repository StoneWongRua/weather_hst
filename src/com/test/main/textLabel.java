package com.test.main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class textLabel extends JLabel {
    private String str; //字符串
    private Color color; //标签颜色
    private int fontSize; //字体大小
    public textLabel(){
    }
    public textLabel(String s, Color c, int f){
        this.str = s;
        this.color = c;
        this.fontSize = f;
        setText(str);
        setFont(new Font(null,Font.PLAIN,fontSize));
        setBackground(Color.BLACK);
        setForeground(color);
    }
}