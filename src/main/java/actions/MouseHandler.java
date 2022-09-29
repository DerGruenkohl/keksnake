package actions;

import game.Dir;
import game.Snake;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class MouseHandler implements MouseInputListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)){
            if (!Snake.waitToMove && Snake.head.getDir() == Dir.UP) {
                Snake.head.setDir(Dir.LEFT);
                Snake.waitToMove = true;
            }
            if (!Snake.waitToMove && Snake.head.getDir() == Dir.LEFT) {
                Snake.head.setDir(Dir.DOWN);
                Snake.waitToMove = true;
            }
            if (!Snake.waitToMove && Snake.head.getDir() == Dir.DOWN) {
                Snake.head.setDir(Dir.RIGHT);
                Snake.waitToMove = true;
            }
            if (!Snake.waitToMove && Snake.head.getDir() == Dir.RIGHT) {
                Snake.head.setDir(Dir.UP);
                Snake.waitToMove = true;
            }

        }
        if (SwingUtilities.isRightMouseButton(e)) {
                if (!Snake.waitToMove && Snake.head.getDir() == Dir.UP) {
                    Snake.head.setDir(Dir.RIGHT);
                    Snake.waitToMove = true;
                }
                if (!Snake.waitToMove && Snake.head.getDir() == Dir.LEFT) {
                    Snake.head.setDir(Dir.UP);
                    Snake.waitToMove = true;
                }
                if (!Snake.waitToMove && Snake.head.getDir() == Dir.DOWN) {
                    Snake.head.setDir(Dir.LEFT);
                    Snake.waitToMove = true;
                }
                if (!Snake.waitToMove && Snake.head.getDir() == Dir.RIGHT) {
                    Snake.head.setDir(Dir.DOWN);
                    Snake.waitToMove = true;
                }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
