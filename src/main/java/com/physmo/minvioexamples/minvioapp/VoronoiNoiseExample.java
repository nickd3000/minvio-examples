package com.physmo.minvioexamples.minvioapp;

import com.physmo.minvio.BasicDisplayAwt;
import com.physmo.minvio.DrawingContext;
import com.physmo.minvio.MinvioApp;
import com.physmo.minvio.Utils;
import com.physmo.minvio.utils.Gradient;
import com.physmo.minvio.utils.VoronoiNoise;

import java.awt.Color;

public class VoronoiNoiseExample extends MinvioApp {

    double time = 0;
    Gradient gradient = new Gradient(Color.BLUE, Color.YELLOW);

    public static void main(String... args) {
        MinvioApp app = new VoronoiNoiseExample();
        app.start(new BasicDisplayAwt(400, 400), "Voronoi Noise Example", 30);
    }

    @Override
    public void draw(DrawingContext dc, double delta) {
        int cellSize = 2;
        double scale = 0.025;
        time += delta * 0.5;

        for (int y = 0; y < dc.getHeight() / cellSize; y++) {
            for (int x = 0; x < dc.getWidth() / cellSize; x++) {

                double noise = VoronoiNoise.noise((x * scale), (y * scale), time);

                noise = Utils.clamp(0, 1, noise);

                dc.setDrawColor(gradient.getColor(noise));

                dc.drawFilledRect(x * cellSize, y * cellSize, cellSize, cellSize);
            }
        }

    }

}
