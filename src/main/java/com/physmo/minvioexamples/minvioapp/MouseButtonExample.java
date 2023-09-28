package com.physmo.minvioexamples.minvioapp;

import com.physmo.minvio.BasicDisplayAwt;
import com.physmo.minvio.DrawingContext;
import com.physmo.minvio.MinvioApp;

import java.awt.Color;

class MouseButtonExample extends MinvioApp {

    // Define colours for indicators.
    Color colOn = new Color(0x3C9ABB, false);
    Color colOff = new Color(0x652727, false);

    public static void main(String... args) {
        MinvioApp app = new MouseButtonExample();
        app.start(new BasicDisplayAwt(400, 400), "Mouse Button Example", 60);
    }

    @Override
    public void draw(DrawingContext dc, double delta) {
        dc.cls(Color.lightGray);

        // Draw rectangles representing mouse buttons.
        int span = dc.getWidth() / 3;
        int pad = (getMouseX() * 50 / dc.getWidth());
        for (int i = 0; i < 3; i++) {

            if (i == 0 && getBasicDisplay().getMouseButtonLeft()) dc.setDrawColor(colOn);
            else if (i == 1 && getBasicDisplay().getMouseButtonMiddle()) dc.setDrawColor(colOn);
            else if (i == 2 && getBasicDisplay().getMouseButtonRight()) dc.setDrawColor(colOn);
            else dc.setDrawColor(colOff);

            dc.drawFilledRect((i * span) + pad, pad, (span) - (pad * 2), (dc.getHeight()) - pad * 2);
        }

        // Draw the message.
        dc.setFont(15);
        dc.setDrawColor(Color.black);
        dc.drawText("Click Left, Middle and Right mouse button.", 40, dc.getHeight() - 30);
    }
}
