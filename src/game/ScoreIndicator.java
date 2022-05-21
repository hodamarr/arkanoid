package game;

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author Hod Amar <hod110@gmail.com>
 * @since 2021-06-01
 * */


public class ScoreIndicator implements Sprite {
    private Counter c;

    /**
     * constructor.
     *
     * @param score counter.
     */
    public ScoreIndicator(Counter score) {
        this.c = score;
    }

    @Override
    public void drawOn(DrawSurface d) {

        String string = "Score: " + this.c.getValue();
        d.setColor(Color.black);
        d.drawText(200, 27, string, 15);
    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }

    @Override
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }
}
