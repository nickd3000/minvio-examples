package com.physmo.minvioexamples.minvioapp;

import com.physmo.minvio.BasicDisplayAwt;
import com.physmo.minvio.DrawingContext;
import com.physmo.minvio.MinvioApp;
import com.physmo.minvio.Utils;

import java.awt.Color;

/***
 * minvio provides support for generating unique colors, useful for quickly
 * creating distinct colours when the specific color isn't important.
 */
class DistinctColorExample extends MinvioApp {

    public static void main(String... args) {
        MinvioApp app = new DistinctColorExample();
        app.start(new BasicDisplayAwt(400, 400), "Distinct Color Example", 30);
    }

    @Override
    public void draw(DrawingContext dc, double delta) {
        int numRows;
        int space;
        int halfSpace;

        dc.cls(Color.GRAY);
        numRows = 5 + (getMouseX() / 20);
        if (numRows < 1) numRows = 1;
        space = 400 / numRows;
        halfSpace = space / 2;
        double saturation = ((double) getMouseY() / (double) getHeight());

        for (int y = 0; y < numRows; y++) {
            for (int x = 0; x < numRows; x++) {
                dc.setDrawColor(Utils.getDistinctColor(x + (y * numRows), saturation));
                dc.drawFilledCircle(halfSpace + x * space, halfSpace + y * space, halfSpace);
            }
        }
    }
}
