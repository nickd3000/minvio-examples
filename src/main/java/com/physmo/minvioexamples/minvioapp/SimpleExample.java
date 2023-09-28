package com.physmo.minvioexamples.minvioapp;

import com.physmo.minvio.BasicDisplayAwt;
import com.physmo.minvio.DrawingContext;
import com.physmo.minvio.MinvioApp;

import java.awt.Color;

class SimpleExample extends MinvioApp {

    public static void main(String... args) {
        MinvioApp app = new SimpleExample();
        // Start the app running with a window size of 200x200 pixels, at 60 frames per second.
        app.start(new BasicDisplayAwt(200, 200), "Simple Example", 60);
    }

    @Override
    public void draw(DrawingContext dc, double delta) {

        dc.cls(Color.LIGHT_GRAY);
        dc.setDrawColor(Color.WHITE);
        dc.drawFilledRect(75, 75, 50, 50);
        dc.setDrawColor(Color.BLUE);
        dc.drawCircle(100, 100, 70);
        dc.drawText("X:" + getMouseX() + " Y:" + getMouseY(), 10, 190);
        dc.drawText("Tick :" + getFps(), 10, 160);
    }
}
