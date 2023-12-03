package com.example.jdbc;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class HistogramAlphaBet {
    private Map<Character, Integer> freq;
    private Map<Character, Double> prob;
    private int total;
    private MyPieChart pieChart;

    public HistogramAlphaBet(Map<Character, Integer> number) {
        freq = new HashMap<>();
        prob = new HashMap<>();

        // Calculate the frequencies and probabilities of the alphabet characters
        total = number.values().stream().mapToInt(Integer::intValue).sum();
        for (char c = 'A'; c <= 'Z'; c++) {
            if (number.containsKey(c)) {
                freq.put(c, number.get(c));
                prob.put(c, number.get(c) / (double) total);
            }
        }

        // Create the pie chart with the calculated frequencies and probabilities
        pieChart = new MyPieChart(250.0, 250.0, 200.0, total, (HashMap<Character, Integer>) freq);
    }

    public void draw(GraphicsContext gc) {
        pieChart.draw(gc);
    }

    private class MyPieChart {
        private final double centerX, centerY, rad;
        private double rang;
        private final int event, total;
        private HashMap<Character, Integer> prob;

        public MyPieChart(double x, double y, double radius, int events, HashMap<Character, Integer> prob) {
            centerX = x;
            centerY = y;
            rad = radius;
            event = events;
            this.prob = prob;
            int z = 0;
            for (double i : prob.values()) {
                z += i;
            }
            total = z;
        }

        public void draw(GraphicsContext gc) {
            rang = 0;

            // Sort the alphabet characters in alphabetical order
            prob = prob.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .collect(HashMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), Map::putAll);

            // Draw the pie chart with the calculated frequencies and probabilities
            for (Map.Entry<Character, Integer> m : prob.entrySet()) {
                gc.setFill(getRandomColor());
                gc.fillArc(centerX - rad, centerY - rad, 2 * rad, 2 * rad, rang, 360 * m.getValue() / total, ArcType.ROUND);
                rang += 360 * m.getValue() / total;

                gc.setFill(Color.BLACK);
                gc.fillText(m.getKey() + ": " + m.getValue(), centerX + rad + 20, centerY + rang - 180);
            }
        }

        private Color getRandomColor() {
            Random rand = new Random();
            int red = rand.nextInt(256);
            int green = rand.nextInt(256);
            int blue = rand.nextInt(256);
            return Color.rgb(red, green, blue);
        }
    }
}





