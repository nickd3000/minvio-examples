package com.physmo.minvioexamples.minvioapp;

import com.physmo.minvio.BasicDisplayAwt;
import com.physmo.minvio.DrawingContext;
import com.physmo.minvio.MinvioApp;
import com.physmo.minvio.utils.LookupTable;

import java.awt.Color;

public class LookupTableExample extends MinvioApp {

    int x = 0;

    public static void main(String... args) {
        MinvioApp app = new LookupTableExample();
        app.start(new BasicDisplayAwt(400, 400), "Lookup Table Example", 30);
    }

    @Override
    public void draw(DrawingContext dc, double delta) {
        LookupTable lookupTable = new LookupTable(0.0, 400.0, 100, operand -> (Math.sin(operand / 100) + 1.0) * 50.0);

        for (int x = 0; x < 400; x++) {
            dc.setDrawColor(Color.black);
            dc.drawPoint(x, (int) (lookupTable.getValue(x)));
            dc.setDrawColor(Color.blue);
            dc.drawPoint(x, (int) ((Math.sin((double) x / 100) + 1.0) * 50.0));
        }
    }
}