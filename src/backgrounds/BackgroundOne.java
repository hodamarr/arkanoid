package backgrounds;

import biuoop.DrawSurface;
import game.Sprite;

import java.awt.Color;

/**
 * @author Hod Amar <hod110@gmail.com>
 * @since 2021-06-01
 * */

public class BackgroundOne extends Background implements Sprite {

    /**
     * constructor.
     * @param color background color
     */

    public BackgroundOne(Color color) {
        super(color);
    }

    @Override
    public void drawOn(DrawSurface d) {
        Color c = super.getColor();
        d.setColor(c);
        d.fillRectangle((int) super.getUpperLeft().getX(), (int) super.getUpperLeft().getY(),
                (int) super.getWidth(), (int) super.getHeight());
        d.setColor(Color.blue);
        d.drawCircle(390, 225, 150);
        d.drawCircle(390, 225, 80);
        d.drawLine(390, 225 - 150, 390, 225 + 150);
        d.drawLine(390 - 150, 225, 390 + 150, 225);
    }
}
