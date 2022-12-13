package com.example.jdbc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) {
        // Create a map with the grades as keys and the number of students as values
        Map<Character, Integer> grades = new HashMap<>();
        grades.put('A', 7);
        grades.put('B', 8);
        grades.put('C', 9);
        grades.put('F', 1);
        grades.put('W', 1);
        grades.put('D', 0);

        // Create the pie chart
        HistogramAlphaBet pieChart = new HistogramAlphaBet(grades);

        // Create a canvas to draw the pie chart on
        Canvas canvas = new Canvas(500, 500);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        pieChart.draw(gc);

        // Create a pane to hold the canvas
        Pane root = new Pane(canvas);

        // Show the pie chart on the screen
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pie Chart Based on Aggregate Grades Table");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

