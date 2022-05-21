package game;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;


/**
 * @author Hod Amar <hod110@gmail.com>
 * @version 1.0
 * @since 2021-06-14 */


public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper = new Sleeper();

    /**
     * constructor.
     *
     * @param gui graphic.
     */

    public AnimationRunner(GUI gui) {
        this.gui = gui;
        this.framesPerSecond = 60;
    }

    /**
     * run the animation.
     *
     * @param animation doing frames in this animation.
     */

    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (!animation.shouldStop()) {
            DrawSurface d = gui.getDrawSurface();
            long startTime = System.currentTimeMillis(); // timing
            animation.doOneFrame(d);
            gui.show(d);

            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}