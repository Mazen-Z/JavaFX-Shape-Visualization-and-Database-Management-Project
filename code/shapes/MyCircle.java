package com.example.jdbc;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyCircle extends MyOval {
    private double rad;
    public double getPerimeter(){
        return rad * Math.PI * 2;
    }
    public double getArea(){
        return Math.pow(rad, 2) * Math.PI;
    }
    public double getRadius(){
        return rad;
    }

    MyCircle(double x, double y, double rad, Color colors){
        super(x, y, rad*2, rad*2, colors);
        this.rad = rad;
    }
    @Override
    public MyRectangle getMyBoundingRectangle(){
        return new MyRectangle((int)(super.getX() - rad), (int)(super.getY() - rad), 2*rad, 2*rad, super.getColor());
    }
    @Override
    public void draw(GraphicsContext gg){
        gg.setFill(super.getColor()); gg.setStroke(super.getColor());
        gg.strokeOval(super.getX() - rad, super.getY() - rad, 2 * rad, 2 * rad);
        gg.fillOval(super.getX() - rad, super.getY() - rad, 2 * rad, 2 * rad);
    }


}
