package com.example.jdbc;

import javafx.scene.canvas.GraphicsContext;

public class MyPoint {
    private double x;
    private double y;

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
    public double getY() {

        return y;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }


    @Override
    public String toString() {

        return String.format("      Point      \n","point ", "(",x,",",y,")");
    }
    public void draw(GraphicsContext gg){
        gg.setFill(MyColor.BLACK.getC());
    }


}