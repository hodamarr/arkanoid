package backgrounds;

import biuoop.DrawSurface;
import game.Sprite;

import java.awt.Color;

/**
 * @author Hod Amar <hod110@gmail.com>
 * */

public class RegularBackground extends Background implements Sprite {

    /**
     * constructor.
     * @param color background color
     */

    public RegularBackground(Color color) {
        super(color);
    }

    @Override
    public void drawOn(DrawSurface d) {
        super.drawOn(d);
    }
}