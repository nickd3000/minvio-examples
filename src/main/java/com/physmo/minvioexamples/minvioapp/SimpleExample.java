package com.physmo.minvioexamples.minvioapp;

import com.physmo.minvio.MinvioApp;

import java.awt.Color;

class SimpleExample extends MinvioApp {

    public static void main(String... args) {
        MinvioApp app = new SimpleExample();
        app.start(200, 200, "Simple Example", 60);
    }

    @Override
    public void draw(double delta) {
        cls(Color.LIGHT_GRAY);
        setDrawColor(Color.WHITE);
        drawFilledRect(75, 75, 50, 50);
        setDrawColor(Color.BLUE);
        drawCircle(100, 100, 70);
        drawText("X:" + getMouseX() + " Y:" + getMouseY(), 10, 190);
        drawText("Tick :" + getFps(), 10, 160);
    }
}
