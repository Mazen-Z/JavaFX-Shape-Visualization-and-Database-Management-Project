package com.example.jdbc;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import javafx.scene.shape.ArcType;


public class MyArc extends MyShape {
    private final MyOval b;
    private double sa;
    private final double sh;

    public MyArc(double ang, double shift, Color colors, MyOval bases) {
        super(bases.getCenter().getX(), bases.getCenter().getY(), colors);
        sh = shift;
        b = bases;
        sa = ang;
        while (sa < 0) sa += 360;
    }

    @Override
    public MyRectangle getMyBoundingRectangle() {
        return null;
    }

    @Override
    public ArrayList<MyPoint> getMyArea() {

        return null;
    }

    @Override
    public String toString() {
        return String.format("      Arc      \n"+super.getColor(),"Center ", b.getCenter().getX() - b.getWidth()/2, b.getCenter().getY() - b.getHeight()/2,"Start Angle ",sa,"End Angle ",sa + sh);
    }

    @Override
    public void draw(GraphicsContext gg) {
        final double centerX = b.getCenter().getX() - b.getWidth()/2;
        final double centerY = b.getCenter().getY() - b.getHeight()/2;
        gg.setFill(super.getColor()); gg.setStroke(super.getColor());
        gg.strokeArc(centerX, centerY, b.getWidth(),b.getHeight(),sa,sh,ArcType.ROUND);
        gg.fillArc(centerX, centerY, b.getWidth(),b.getHeight(),sa,sh,ArcType.ROUND);

    }
}
