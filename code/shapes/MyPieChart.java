package com.example.jdbc;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class MyPieChart {
    private final double centerX, centerY, rad;
    double rang;
    int colorS;
    private final int event, total;
    private HashMap<Character, Integer> prob;

    public MyPieChart(double x, double y, double radius, int events, HashMap<Character, Integer> prob) {
        centerX = x; centerY = y; rad = radius; event = events; this.prob = prob; int z = 0;
        for (double i : prob.values()) {
            z += i;
        }
        total = z;


    }



    public void draw(GraphicsContext gg) {

        double degrees = 0, remainingLetters = total, shift, max, textX, textY, probability, radius, midAngles;
        MyOval PIE = new MyOval(centerX - rad, centerY - rad, rad * 2, rad * 2, MyColor.GRAY.getC());
        PIE.draw(gg);

        MyArc partition;
        for (int i = 0; i < event; i++) {
            max = 0;
            Character uno = 'a';
            for (Map.Entry<Character, Integer> probs : prob.entrySet()) {
                if (probs.getValue() > max) {
                    max = probs.getValue();
                    uno = probs.getKey();
                }
            }
            if (uno != 'a') prob.remove(uno);
            remainingLetters -= max; probability = max / total; shift = 360 * probability;
            partition = new MyArc(degrees, shift, MyColor.getRandom(), PIE);
            midAngles = degrees + shift / 2; radius = PIE.getRadius(midAngles);
            partition.draw(gg); textX = (radius * 11 / 10) * Math.cos(Math.toRadians(midAngles));
            textY = (radius * 11 / 10) * Math.sin(Math.toRadians(midAngles));
            if (midAngles > 100 && midAngles < 260) {
                textX -= radius / 6;
            }
            degrees += shift;
            gg.fillText((String.format("%c, %.4f", uno, probability)), centerX + textX, centerY - textY);
            gg.setFill(MyColor.BLACK.getC());
            if (i + 1 == event) {
                midAngles = (360 - degrees) / 2; radius = PIE.getRadius(midAngles);
                textX = (radius * 11 / 10) * Math.cos(Math.toRadians(midAngles));
                textY = (radius * 11 / 10) * Math.sin(Math.toRadians(midAngles));
                if (midAngles > 100 && midAngles < 260) {
                    textX -= radius - radius * Math.abs((180 - midAngles) / 180);
                }
                gg.fillText((String.format("The other letters: %.4f", remainingLetters / total)), centerX + textX, centerY + textY);
                break;
            }
        }
        drawLabels(gg);
    }


    public void drawLabels(GraphicsContext gg) {
        int index = 0;
        rang = 0;
        double x, y;
        for (Map.Entry<Character, Integer> m : prob.entrySet()) {
            // Calculate the position of the label
            x = centerX + rad * Math.cos(Math.toRadians(rang + 360 * m.getValue() / total / 2));
            y = centerY + rad * Math.sin(Math.toRadians(rang + 360 * m.getValue() / total / 2));

            // Draw the label
            gg.setFill(Color.BLACK);
            gg.fillText(getLabel(index), x, y);

            rang += 360 * m.getValue() / total;
            index++;
        }
    }

    private String getLabel(int index) {
        // Define the labels for each slice of the pie chart
        String[] labels = {"A", "B", "C", "D", "F", "W"};

        // Return the label for the current slice
        return labels[index % labels.length];
    }
}

