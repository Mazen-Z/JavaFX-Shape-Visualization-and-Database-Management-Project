package com.example.jdbc;
import java.util.ArrayList;

public interface MyShapeInterface {
    public abstract MyRectangle getMyBoundingRectangle();
    public abstract ArrayList<MyPoint> getMyArea();
    public ArrayList<MyPoint> overlapMyShapes(MyShape shape);
}
