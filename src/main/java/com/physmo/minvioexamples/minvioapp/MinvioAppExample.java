package com.physmo.minvioexamples.minvioapp;

import com.physmo.minvio.BasicDisplayAwt;
import com.physmo.minvio.DrawingContext;
import com.physmo.minvio.MinvioApp;

import java.awt.Color;

public class MinvioAppExample extends MinvioApp {

    int x = 0;

    public static void main(String... args) {
        MinvioApp app = new MinvioAppExample();
        app.start(new BasicDisplayAwt(600, 300), "Minvio App Example", 30);
    }

    @Override
    public void draw(DrawingContext dc, double delta) {
        x++;
        if (x > 200) x = 0;
        dc.cls(new Color(207, 198, 179));
        dc.setDrawColor(new Color(17, 52, 69, 215));
        dc.drawText("Hello, World", x, 100);
    }
}
