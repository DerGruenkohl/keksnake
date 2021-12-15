package actions;

import game.Dir;
import game.Snake;
import util.VoiceListener;

public class voiceHandler{
    public void VoiceAction() {
        VoiceListener voiceListener = new VoiceListener();
        String event = voiceListener.Voice();
        if (event.equalsIgnoreCase("UP")){
            if (!(Snake.head.getDir() == Dir.DOWN) && !Snake.waitToMove) {
                Snake.head.setDir(Dir.UP);
                Snake.waitToMove = true;
            }
        }
        if (event.equalsIgnoreCase("DOWN")) {
            if (!(Snake.head.getDir() == Dir.RIGHT) && !Snake.waitToMove) {
                Snake.head.setDir(Dir.LEFT);
                Snake.waitToMove = true;
            }
        }
        if (event.equalsIgnoreCase("LEFT")){
            if (!(Snake.head.getDir() == Dir.UP) && !Snake.waitToMove) {
                Snake.head.setDir(Dir.DOWN);
                Snake.waitToMove = true;
            }
        }
        if (event.equalsIgnoreCase("DOWN")){
            if (!(Snake.head.getDir() == Dir.LEFT) && !Snake.waitToMove) {
                Snake.head.setDir(Dir.RIGHT);
                Snake.waitToMove = true;
            }

        }

    }
}
