package com.physmo.minvioexamples.minvioapp;

import com.physmo.minvio.BasicDisplay;
import com.physmo.minvio.BasicDisplayAwt;
import com.physmo.minvio.DrawingContext;
import com.physmo.minvio.MinvioApp;
import com.physmo.minvio.Point;
import com.physmo.minvio.utils.BasicUtils;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class FindClosestPointInListExample extends MinvioApp {


    List<Point> points = new ArrayList<>();
    Color backgroundColor = new Color(116, 116, 116);
    Color col1 = new Color(123, 37, 37);
    Color col2 = new Color(1, 255, 208);

    public static void main(String... args) {
        MinvioApp app = new FindClosestPointInListExample();
        // Start the app running with a window size of 200x200 pixels, at 60 frames per second.
        app.start(400, 400, "Find Closest Point In List", 60);
    }


    @Override
    public void init(BasicDisplay bd) {
        for (int i = 0; i < 100; i++) {
            points.add(BasicUtils.createRandomPointInCircle(200, 200, 175));
        }
    }

    @Override
    public void draw(double delta) {
        cls(backgroundColor);

        int closestPointIndex = BasicUtils.findClosestPointInList(points, getBasicDisplay().getMousePoint(), 400);

        for (int i = 0; i < points.size(); i++) {
            if (i == closestPointIndex) setDrawColor(col2);
            else setDrawColor(col1);

            drawFilledCircle(points.get(i), 5);
        }

    }
}
