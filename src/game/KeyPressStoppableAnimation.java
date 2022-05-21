package game;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * @author Hod Amar <hod110@gmail.com>
 * @version 1.0
 * @since 2021-06-14 */


public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor ks;
    private String key;
    private Animation animation;

    /**
     * constructor.
     * @param sensor keyboard
     * @param key string key
     * @param animation animation to wrap
     */

    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.ks = sensor;
        this.key = key;
        this.animation = animation;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        animation.doOneFrame(d);

    }

    @Override
    public boolean shouldStop() {
        return animation.shouldStop();
    }

}