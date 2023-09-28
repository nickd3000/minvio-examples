package com.physmo.minvioexamples.minvioapp;

import com.physmo.minvio.BasicDisplay;
import com.physmo.minvio.BasicDisplayAwt;
import com.physmo.minvio.DrawingContext;
import com.physmo.minvio.MinvioApp;
import com.physmo.minvio.Point;
import com.physmo.minvio.utils.AnchorManager;

import java.awt.Color;
import java.util.List;


public class AnchorExample extends MinvioApp {

    AnchorManager anchorManager;
    Color background = new Color(218, 132, 78);

    public static void main(String[] args) {
        MinvioApp app = new AnchorExample();
        app.start(new BasicDisplayAwt(250, 250), "Anchor Example", 60);
    }

    @Override
    public void init(BasicDisplay bd) {
        anchorManager = new AnchorManager(6);
        anchorManager.add(20, 20);
        anchorManager.add(20, 180);
        anchorManager.add(180, 180);
        anchorManager.add(180, 20);

        // Optional custom anchor-drawing delegate.
        anchorManager.setAnchorDrawDelegate((bd1, point, radius, mouseOver, grabbed) -> {

            if (grabbed) {
                bd.getDrawingContext().setDrawColor(new Color(175, 236, 80));
                bd.getDrawingContext().drawFilledCircle(point, radius);
                bd.getDrawingContext().setDrawColor(new Color(1, 1, 1));
                bd.getDrawingContext().drawCircle(point, radius);
            } else if (mouseOver) {
                bd.getDrawingContext().setDrawColor(new Color(1, 1, 1));
                bd.getDrawingContext().drawFilledCircle(point, radius);
                bd.getDrawingContext().setDrawColor(new Color(236, 175, 80));
                bd.getDrawingContext().drawCircle(point, radius);
                bd.getDrawingContext().drawCircle(point, radius + 0.5);
            } else {
                bd.getDrawingContext().setDrawColor(new Color(1, 1, 1));
                bd.getDrawingContext().drawFilledCircle(point, radius);
            }

        });
    }

    @Override
    public void draw(DrawingContext dc, double delta) {
        dc.cls(background);
        anchorManager.update(getBasicDisplay());


        dc.setDrawColor(new Color(225, 209, 118));

        List<Point> anchors = anchorManager.getAnchors();
        for (int i = 0; i < anchors.size() - 1; i++) {
            dc.drawLine(anchors.get(i), anchors.get(i + 1));
        }

        anchorManager.draw(dc);
    }
}
