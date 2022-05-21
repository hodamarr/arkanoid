package game;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * @author Hod Amar <hod110@gmail.com>
 * @version 1.0
 * @since 2021-06-14 */


public class PauseScreen implements Animation {

    private KeyboardSensor keyboardSensor;
    private boolean stop;

    /**
     * constructor.
     * @param k keyboard
     */

    public PauseScreen(KeyboardSensor k) {
        this.keyboardSensor = k;
        this.stop = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
        if (this.keyboardSensor.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }

    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}