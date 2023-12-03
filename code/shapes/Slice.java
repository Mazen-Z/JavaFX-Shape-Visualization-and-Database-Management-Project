package com.example.jdbc;

import javafx.scene.canvas.GraphicsContext;

public class Slice {
MyPoint center;
int rad;
double start, ang, end, rstart, rang, rend;
MyColor color;
Slice (MyPoint p, int r, double start, double ang, MyColor color){
    this.center = p;
    this.rad = r;
    this.start = start;
    this.ang = ang;
    this.rang = Math.toRadians(ang);
}
public MyPoint getCenter(){
    return center;
}
public int getRad(){
    return rad;
}
public double getStart(){
    return start;
}
public double getAng(){
    return ang;
}
public double getArcLen() {
    return (double) rad * rang;
}
public String toString(){
    return "Slice:" +  "Center(" + center.getX() + ", " + center.getY() + ") Radius " + rad +
            " (Starting angle, angle): (" + start + ", " + ang + "), " +
            color.getRandom();
}
    public void draw(GraphicsContext gg){
        gg.setFill(color.getRandom());
        gg.fillArc(center.getX() - rad, center.getY() - rad, 2 * rad, 2 * rad, start, ang, null);
}
}
