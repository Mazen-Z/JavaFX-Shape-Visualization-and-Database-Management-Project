package com.example.jdbc;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.ArrayList;

public class MyRectangle extends MyShape {
    private double width;
    private double height;

    // (x,y) Top Left Corner
    MyRectangle(double x, double y, double width, double height, Color color){
        super(x,y,color);
        this.width = width;
        this.height = height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }
    private double getArea() {
        return width * height;
    }

    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }
    public void setWidth(int widths) {
        this.width = width;
    }
    public void setHeight(int heights) {
        this.height = height;
    }
    @Override
    public ArrayList<MyPoint> getMyArea() {
        ArrayList<MyPoint> set = new ArrayList<>();
// Picks up points from every column and row within rectangle, starting from top left to bottom right
        for(double x = super.getX(); x <= super.getX() + width; x++){
            for(double y = super.getY(); y <= super.getY() + height; y++){
                set.add(new MyPoint(x,y));
            }
        }
        return set;
    }
    @Override
    public void draw(GraphicsContext gg) {
        gg.setFill(super.getColor());
        gg.setStroke(super.getColor());
        gg.strokeRect(super.getX(), super.getY(), width, height);
        gg.fillRect(super.getX(), super.getY(), width, height);
    }
    @Override
    public MyRectangle getMyBoundingRectangle(){
        return this;
    }


    @Override
    public String toString() {
        return String.format("      (Rectangle)     \n"+super.getColor(),
                "Corner Point ",super.getX(),super.getY(),"Area ",getArea(),"Perimeter ",getPerimeter(),"Width ",width,"Height ",height);
    }
}

