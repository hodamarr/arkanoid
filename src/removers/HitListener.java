package removers;

import game.Block;
import shapes.Ball;

/**
 * @author Hod Amar <hod110@gmail.com>
 * @since 2021-06-01
 * */


public interface HitListener {

    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the shapes.Ball that's doing the hitting.
     * @param beingHit block
     * @param hitter ball
     */
    void hitEvent(Block beingHit, Ball hitter);
}