package gui;
import game.Snake;

import javax.swing.*;
import java.awt.*;

public class Draw extends JLabel {

    Point p;

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, Gui.width, Gui.height);


        g.setColor(new Color(51, 204, 51));
        for (int i = 0; i < Snake.tails.size(); i++) {
            p = Snake.ptc(Snake.tails.get(i).getX(), Snake.tails.get(i).getY());
            g.fill3DRect(p.x, p.y, 32, 32, false);
        }

        g.setColor(new Color(0,153,0));
        p = Snake.ptc(Snake.head.getX(),Snake.head.getY());
        g.fill3DRect(p.x,p.y,32,32, true);

        g.setColor(new Color(204,51,0));
        p = Snake.ptc(Snake.pickup.getX(), Snake.pickup.getY());
        g.fill3DRect(p.x,p.y, 32,32, true);



        g.setColor(Color.BLACK);
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                g.drawRect(i * 32 + Gui.xoff, j * 32 + Gui.yoff, 32, 32);
            }
        }

        g.setColor(Color.BLACK);
        g.drawRect(Gui.xoff, Gui.yoff, 512, 512);

        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: "+Snake.score, 5,25);
        g.drawString("Best: "+Snake.bestscore, 655,25);

        repaint();

    }

}
