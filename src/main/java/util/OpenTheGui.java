package util;

import clocks.GameClock;
import gui.Gui;

public class OpenTheGui {
    public void Open(){
        Gui g = new Gui();
        GameClock gc = new GameClock();
        g.create();
        gc.start();
        g.repaint();
    }
}
