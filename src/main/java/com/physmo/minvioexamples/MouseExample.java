package com.physmo.minvioexamples;

import com.physmo.minvio.BasicDisplay;
import com.physmo.minvio.BasicDisplayAwt;
import com.physmo.minvio.DrawingContext;
import com.physmo.minvio.Utils;
import com.physmo.minvio.utils.BasicUtils;

import java.awt.Color;

// TODO: mouse clicks... is this supported yet?
class MouseExample {


    public static void main(String... args) {
        int width = 400;
        int height = 400;
        BasicDisplay bd = new BasicDisplayAwt(width, height);
        DrawingContext dc = bd.getDrawingContext();

        bd.setTitle("Mouse Example");

        // Clear the screen to dark gray.
        dc.cls(Color.black);
        dc.setDrawColor(Color.BLUE);

        int prevX = bd.getMouseX();
        int prevY = bd.getMouseY();
        int count = 0;

        // Loop forever.
        while (true) {

            bd.repaint(30);
            int dst;
            dst = BasicUtils.distance(prevX, prevY, bd.getMouseX(), bd.getMouseY());

            // Draw the point.
            dc.drawFilledCircle(bd.getMouseX(), bd.getMouseY(), dst / 2);

            // Chose a random distinct colour every so often.
            count++;
            dc.setDrawColor(Utils.getDistinctColor(count, 0.7));

            prevX = bd.getMouseX();
            prevY = bd.getMouseY();

            // Fade
            dc.cls(new Color(0, 0, 0, 10));

            // Clear on mouse click.
            if (bd.getMouseButtonLeft()) {
                dc.cls(Color.black);
            }

        }
    }


}
