package game;

import biuoop.DrawSurface;
import biuoop.Sleeper;

/**
 * @author Hod Amar <hod110@gmail.com>
 * @version 1.0
 * @since 2021-06-14 */


public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gamescreen;
    private boolean flag;

    /**
     * constructor.
     * @param numOfSeconds waiting.
     * @param countFrom number to count from.
     * @param gameScreen to count on it.
     */

    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gamescreen = gameScreen;
        this.flag = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.gamescreen.drawAllOn(d);
        Sleeper sleeper = new Sleeper();
        Integer writeOnScreen = countFrom;
        d.drawText(d.getWidth() / 2, d.getHeight() / 2, writeOnScreen.toString(), 32);

        if (!flag) {
            sleeper.sleepFor((long) numOfSeconds * 1000);
        }
        flag = false;
        this.countFrom = countFrom - 1;

    }

    @Override
    public boolean shouldStop() {
        return this.countFrom == -1;
    }
}
