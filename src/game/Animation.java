package game;

import biuoop.DrawSurface;

/**
 * @author Hod Amar <hod110@gmail.com>
 * @version 1.0
 * @since 2021-06-14 */


public interface Animation {

    /**
     * one frame of Animation on surface.
     *
     * @param d surface.
     */

    void doOneFrame(DrawSurface d);

    /**
     * returning if the animation should stop.
     *
     * @return true / false
     */
    boolean shouldStop();

}