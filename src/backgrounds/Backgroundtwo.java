package backgrounds;

import biuoop.DrawSurface;
import game.Sprite;

import java.awt.Color;

/**
 * @author Hod Amar <hod110@gmail.com>
 * */

public class Backgroundtwo extends Background implements Sprite {

    /**
     * constructor.
     * @param color background color
     */

    public Backgroundtwo(Color color) {
        super(color);
    }

    @Override
    public void drawOn(DrawSurface d) {
        Color c = Color.white;
        d.setColor(c);
        d.fillRectangle((int) super.getUpperLeft().getX(), (int) super.getUpperLeft().getY(),
                (int) super.getWidth(), (int) super.getHeight());

        /// mushroom 1
        int y = 225;
        int r = 80;
        int x = 400;
        int g = 40;
        d.setColor(Color.black);
        d.drawCircle(400, y, r);
        d.setColor(new Color(255, 139, 139));
        d.fillCircle(400, y, r - 1);
        d.setColor(Color.black);
        d.drawCircle(426, 198, 10);
        d.drawCircle(356, 170, 8);
        d.drawCircle(402, 210, 7);
        d.setColor(Color.white);
        d.fillCircle(426, 198, 10);
        d.fillCircle(356, 170, 8);
        d.fillCircle(402, 210, 7);
        d.setColor(c);
        d.fillRectangle(x - r, y, 2 * r + 5, r + 5);
        d.setColor(Color.lightGray);
        d.fillRectangle(x - (g / 2), y, g, g);

        /// mushroom 2
        y = 380;
        r = 60;
        x = 120;
        g = 30;
        d.setColor(Color.black);
        d.drawCircle(x, y, r);
        d.setColor(new Color(255, 139, 139));
        d.fillCircle(x, y, r - 1);
        d.setColor(Color.black);
        d.drawCircle(100, 335, 8);
        d.drawCircle(135, 348, 6);
        d.drawCircle(120, 364, 7);
        d.setColor(Color.white);
        d.fillCircle(100, 335, 8);
        d.fillCircle(135, 348, 6);
        d.fillCircle(120, 364, 7);
        d.setColor(c);
        d.fillRectangle(x - r, y, 2 * r + 5, r + 5);
        d.setColor(Color.lightGray);
        d.fillRectangle(x - (g / 2), y, g, g);

        /// mushroom 3
        y = 460;
        r = 90;
        x = 500;
        g = 50;
        d.setColor(Color.black);
        d.drawCircle(x, y, r);
        d.setColor(new Color(255, 139, 139));
        d.fillCircle(x, y, r - 1);
        d.setColor(Color.black);
        d.drawCircle(x - 50, y - 25, 8);
        d.drawCircle(x + 50, y - 19, 6);
        d.drawCircle(x + 65, y - 32, 7);
        d.setColor(Color.white);
        d.fillCircle(x - 50, y - 25, 8);
        d.fillCircle(x + 50, y - 19, 6);
        d.fillCircle(x + 65, y - 32, 7);
        d.setColor(c);
        d.fillRectangle(x - r, y, 2 * r + 5, r + 5);
        d.setColor(Color.lightGray);
        d.fillRectangle(x - (g / 2), y, g, g);

        /// mushroom 4
        y = 103;
        r = 70;
        x = 100;
        g = 30;
        d.setColor(Color.black);
        d.drawCircle(x, y, r);
        d.setColor(new Color(255, 139, 139));
        d.fillCircle(x, y, r - 1);
        d.setColor(Color.black);
        d.drawCircle(x - 5, y - 30, 8);
        d.drawCircle(x + 18, y - 16, 6);
        d.drawCircle(x - 15, y - 6, 7);
        d.setColor(Color.white);
        d.fillCircle(x - 5, y - 30, 8);
        d.fillCircle(x + 18, y - 16, 6);
        d.fillCircle(x - 15, y - 6, 7);
        d.setColor(c);
        d.fillRectangle(x - r, y, 2 * r + 5, r + 5);
        d.setColor(Color.lightGray);
        d.fillRectangle(x - (g / 2), y, g, g);


        y = 200;
        r = 30;
        x = 600;
        g = 10;
        d.setColor(Color.black);
        d.drawCircle(x, y, r);
        d.setColor(new Color(255, 139, 139));
        d.fillCircle(x, y, r - 1);
        d.setColor(Color.black);
        d.drawCircle(x - 5, y - 25, 3);
        d.drawCircle(x + 18, y - 16, 4);
        d.drawCircle(x - 15, y - 6, 5);
        d.setColor(Color.white);
        d.fillCircle(x - 5, y - 25, 3);
        d.fillCircle(x + 18, y - 16, 4);
        d.fillCircle(x - 15, y - 6, 5);
        d.setColor(c);
        d.fillRectangle(x - r, y, 2 * r + 5, r + 5);
        d.setColor(Color.lightGray);
        d.fillRectangle(x - (g / 2), y, g, g);
    }
}