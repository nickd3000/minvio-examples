package com.physmo.minvioexamples.gallery;

import com.physmo.minvio.BasicDisplay;
import com.physmo.minvio.BasicDisplayAwt;
import com.physmo.minvio.DrawingContext;
import com.physmo.minvio.MinvioApp;
import com.physmo.minvio.Point;
import com.physmo.minvio.Utils;
import com.physmo.minvio.utils.Gradient;

import java.awt.*;

public class Ribbons extends MinvioApp {

    Point position = new Point(200, 100);
    Point tangent = new Point(Math.sin(1), Math.cos(1));
    double moveAngle = 0;
    Gradient grad1 = new Gradient();
    double runLength = 0;
    double spinAngle = 0;
    double trend = 0.01;
    double weight = 25;
    double fadeTimer = 0;

    public static void main(String... args) {
        MinvioApp app = new Ribbons();
        app.start(400, 400, "Ropes", 30);
    }

    @Override
    public void init(BasicDisplay bd) {
        DrawingContext dc = bd.getDrawingContext();
        dc.cls(Color.darkGray);
        dc.setDrawColor(Color.BLUE);
        grad1.addColor(0, new Color(86, 84, 36));
        grad1.addColor(1, new Color(231, 208, 87));
        setupNewRibbon(dc);
    }

    public void setupNewRibbon(DrawingContext dc) {
        position = getRandomPoint(dc);
        runLength = 10 + (Math.random() * 3.0);
        moveAngle = Math.random() * Math.PI * 2.0;
        float r = (float) (0.5f + (Math.random() * 0.5f));
        float g = (float) (0.5f + (Math.random() * 0.5f));
        float b = (float) (0.5f + (Math.random() * 0.5f));
        grad1.addColor(0, new Color(r, g, b));
        grad1.addColor(1, new Color(r / 2, g / 3, b / 3));
        grad1.addColor(0.3, Utils.lerp(new Color(r, g, b), Color.WHITE, 0.7));
        trend = (Math.random() - 0.5) * 0.03;
        weight = 10 + Math.random() * 10;
    }

    public Point getRandomPoint(DrawingContext dc) {
        double ra = Math.random() * Math.PI * 2;
        Point p = new Point();
        p.x = Math.sin(ra) * dc.getWidth();
        p.y = Math.cos(ra) * dc.getHeight();
        p.x += dc.getWidth() / 2;
        p.y += dc.getHeight() / 2;
        return p;
    }

    @Override
    public void draw(double delta) {

        double speed = 2.0;

        for (int i = 0; i < 500; i++) {

            moveAngle += trend;
            tangent = new Point(Math.sin(moveAngle), Math.cos(moveAngle));

            position.x -= tangent.y * speed;
            position.y += tangent.x * speed;
            spinAngle += 0.05;
            drawRibbonSegment(getDrawingContext(), position, tangent, spinAngle);

            runLength -= 0.01;
            if (runLength < 0) {
                setupNewRibbon(getDrawingContext());

            }
        }

        fadeTimer += delta;
        if (fadeTimer > 0.1) {
            cls(new Color(0, 0, 0, 5));
            fadeTimer = 0;
        }
    }

    public void drawRibbonSegment(DrawingContext dc, Point pos, Point tangent, double angleOffset) {
        double width = 25;
        int count = 1;

        double angleSpan = (Math.PI * 2) / (double) count;
        for (int i = 0; i < count; i++) {

            double x = Math.sin(angleOffset + (i * angleSpan)) * width;
            double y = (Math.cos(angleOffset + (i * angleSpan)) + 1) / 2;

            dc.setDrawColor(grad1.getColor(y));

            double xx = tangent.x * x;
            double yy = tangent.y * x;

            if (y < 0) continue;

            dc.drawFilledCircle(pos.x + xx, pos.y + yy, weight);
        }
    }
}
