package com.example.jdbc;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.ArrayList;

public class MyOval extends MyShape {
    private final MyPoint center;
    private double width;
    private double height;

    MyOval(double x, double y, double width, double height, Color color){
// (x,y) is top left corner
        super(x,y,color);
        this.width = width;
        this.height = height;
        this.center = new MyPoint(x + width/2,y + height/2);
    }

    public double getArea(){

        return Math.PI * width * height * 0.5;
    }
    public double getPerimeter(){

        return 2 * Math.PI * Math.sqrt((width + height)/2);
    }
    public double getWidth(){
        return width;
    }
    public double getHeight(){
        return height;
    }
    public void setAxes(double width, double height){
        this.width = width;
        this.height = height;
    }
    public void setCenter(double x, double y){
        this.center.setX(x);
        this.center.setY(y);
    }

    public MyPoint getCenter() {
        return center;
    }
    public double getRadius(double angle){
        double w = width/2; double h = height/2;
        double t = Math.pow(Math.sin(Math.toRadians(angle)) * Math.pow(h, 2),2);
        t += Math.pow(Math.cos(Math.toRadians(angle)) * Math.pow(h, 2), 2);
        return (h * w) / (Math.sqrt(t));
    }

    @Override
    public String toString() {
        return String.format("     Oval     \n"+super.getColor(),
                "Center ",center.getX(),center.getY(),"Area ",getArea(),"Perimeter ",getPerimeter(),"Width ",width,"Height ",height);
    }
    @Override
    public MyRectangle getMyBoundingRectangle(){
        return new MyRectangle(super.getX(), super.getY(), width, height, super.getColor());
    }

    @Override
    public ArrayList<MyPoint> getMyArea() {
        ArrayList<MyPoint> set = new ArrayList<>();
        double hori = width / 2;
        double vertical = height / 2;
        double dx, dy;
        for (double x = getX(); x <= getX() + width; x++) {

            for (double y = getY(); y <= getY() + height; y++) {
                dx = Math.abs(x - center.getX());
                dy = Math.abs(y - center.getY());

                if (Math.pow((dx) / hori, 2) +
                        Math.pow((dy) / vertical, 2) <= 1){
// Accounts for 4 quadrants of oval
                    set.add(new MyPoint(x, y));
                    set.add(new MyPoint(x - 2*dx,y - 2*dy));
                    set.add(new MyPoint(x - 2*dx,y));
                    set.add(new MyPoint(x,y - 2*dy));
                }
            }
        }
        return set;
    }
    @Override
    public void draw(GraphicsContext gg){
        gg.setFill(super.getColor());
        gg.setStroke(super.getColor());
        gg.strokeOval(super.getX(),super.getY(), width, height);
        gg.fillOval(super.getX(),super.getY(), width, height);
    }
}
