package com.physmo.minvioexamples;

import com.physmo.minvio.BasicDisplay;
import com.physmo.minvio.BasicDisplayAwt;
import com.physmo.minvio.MinvioApp;
import com.physmo.minvio.utils.RollingAverage;

import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MinvioAppTimingTest extends MinvioApp {

    private final int rollingListSize = 20;
    NumberFormat formatter = new DecimalFormat("#0.0000000");

    RollingAverage updateRollingAverage = new RollingAverage(rollingListSize);
    RollingAverage drawRollingAverage = new RollingAverage(rollingListSize);

    double rotationSpeed = 0.5;
    double angles[] = {0, 0};


    public static void main(String... args) {
        MinvioApp app = new MinvioAppTimingTest();
        app.start(new BasicDisplayAwt(600, 400), "MinvioAppTimingTest", 30);
    }

    @Override
    public void init(BasicDisplay bd) {
        setFpsTarget(30);
    }

    @Override
    public void update(BasicDisplay bd, double delta) {
        angles[0] += rotationSpeed * delta;
        updateRollingAverage.add(delta);
    }

    @Override
    public void draw(BasicDisplay bd, double delta) {

        angles[1] += rotationSpeed * delta;
        drawRollingAverage.add(delta);

        bd.cls(Color.BLUE);
        bd.setDrawColor(Color.YELLOW);
        bd.drawText("Update delta average (In seconds) " + formatter.format(updateRollingAverage.getAverage()), 20, 30);
        bd.drawText("Draw delta average (In seconds)   " + formatter.format(drawRollingAverage.getAverage()), 20, 60);

        for (int i = 0; i < 2; i++) {
            double radius = 80 + (i * 20);
            int x = (int) (150 + Math.sin(angles[i]) * radius);
            int y = (int) (150 + Math.cos(angles[i]) * radius);
            bd.drawFilledCircle(x, y, 10);
        }
    }

}
