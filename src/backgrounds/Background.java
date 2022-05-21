package backgrounds;

import biuoop.DrawSurface;
import game.GameLevel;
import game.Sprite;
import shapes.Point;

import java.awt.Color;

/**
 * @author Hod Amar <hod110@gmail.com>
 * @version 1.0
 * @since 2021-06-14 */


public abstract class Background implements Sprite {
    private Point upperLeft;
    private double width;
    private double height;
    private java.awt.Color color;

    /**
     * constructor.
     *
     * @param color background color
     */

    public Background(Color color) {
        this.upperLeft = new Point(0, 0);
        this.width = 800;
        this.height = 600;
        this.color = color;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(color);
        d.fillRectangle(0, 0, 800, 600);
    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }

    @Override
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }

    /**
     * getter.
     * @return Color;
     */
    public Color getColor() {
        return color;
    }

    /**
     * getter.
     * @return upperleft point of screen.
     */
    public Point getUpperLeft() {
        return upperLeft;
    }

    /**
     * getter.
     * @return screen height
     */
    public double getHeight() {
        return height;
    }

    /**
     * getter.
     * @return screen width
     */
    public double getWidth() {
        return width;
    }
}