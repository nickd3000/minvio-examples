package com.physmo.minvioexamples.gui;

import com.physmo.minvio.BasicDisplay;
import com.physmo.minvio.BasicDisplayAwt;
import com.physmo.minvio.DrawingContext;
import com.physmo.minvio.MinvioApp;
import com.physmo.minvio.Rect;
import com.physmo.minvio.utils.gui.GuiButton;
import com.physmo.minvio.utils.gui.GuiContext;
import com.physmo.minvio.utils.gui.GuiPanel;

public class PanelWithButtons extends MinvioApp {

    GuiContext guiContext;
    int counter = 0;

    public static void main(String... args) {
        MinvioApp app = new PanelWithButtons();

        app.start(300, 300, "PanelWithButtons", 60);
    }

    @Override
    public void init(BasicDisplay bd) {
        // Create the GUI context that will manage everything GUI related.
        guiContext = new GuiContext(getBasicDisplay());

        // Create a GUI Panel
        GuiPanel guiPanel = new GuiPanel(new Rect(0, 0, 300, 300));

        // Create the first button, add an action then add it as a child of the panel.
        GuiButton guiButton1 = new GuiButton(new Rect(10, 10, 50, 50));
        guiButton1.setAction(() -> counter--);
        guiPanel.add(guiButton1);

        // Create the second button, add an action then add it as a child of the panel.
        GuiButton guiButton2 = new GuiButton(new Rect(70, 10, 50, 50));
        guiButton2.setAction(() -> counter++);
        guiPanel.add(guiButton2);

        // Finally add the panel to the GUI context.
        guiContext.add(guiPanel);

    }

    @Override
    public void draw(double delta) {
        guiContext.tick();
        guiContext.drawAll(getDrawingContext());
        drawText("val:"+this.counter,10,90);
    }


}
