package util;

import clocks.GameClock;
import gui.Game.Gui;

public class OpenTheGui {
    public void Open(){
        Gui g = new Gui();
        GameClock gc = new GameClock();
        g.create();
        gc.start();
        g.repaint();
    }
}
