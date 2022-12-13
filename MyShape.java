package com.example.jdbc;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.HashSet;

// implements MyShapeInterface
public abstract class MyShape implements MyShapeInterface{
    private MyPoint point; // Point of shape in pixels
    private Color color;

    MyShape(double x, double y, Color col){
        this.point = new MyPoint(x,y);
        this.color = col;
    }

    public double getX(){

        return point.getX();
    }
    public double getY(){

        return point.getY();
    }
    public void setX(int x){
        this.point.setX(x);
    }
    public void setY(int y){
        this.point.setY(y);
    }
    public Color getColor(){
        return color;
    }

    @Override
    public ArrayList<MyPoint> overlapMyShapes(MyShape shape) {
        ArrayList<MyPoint> over = new ArrayList<>();
        HashSet<String> pt = new HashSet<>();
        for (MyPoint point : shape.getMyArea()){
            pt.add(point.toString());
        }
        for (MyPoint point : this.getMyArea()){
            if (pt.contains(point.toString())){
                over.add(point);
            }
        }
        return over;
    }

    public abstract String toString();
    public abstract void draw(GraphicsContext gg);
}