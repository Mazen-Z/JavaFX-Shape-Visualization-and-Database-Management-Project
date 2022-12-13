package com.example.jdbc;
import javafx.scene.paint.Color;

public enum MyColor{
    BLACK(0,0,0,255),
    RED(255,0,0,255),
    BLUE(0,0,255,255),
    GREEN(0,128,0,255),
    GRAY(128,128,128,255),
    PURPLE(128,0,128,255),
    YELLOW(255,255,0,255),
    ORANGE(255,165,0, 255);

    private int r,g,b,a; // Value for red, green, blue, and opacity

    /* Random color picker from color library */
    public static Color getRandom() {
        int r, g, b;
        r = (int)((Math.random() * (255)));
        g = (int)((Math.random() * (255)));
        b = (int)((Math.random() * (255)));
        return Color.rgb(r,g,b,1);
    }
    MyColor(int r, int g, int b, int a){
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }
    public Color getC(){
        return Color.rgb(r, g, b, (double)(a/255) );
    }

}