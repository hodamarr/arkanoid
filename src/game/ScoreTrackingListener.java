package game;

import removers.HitListener;
import shapes.Ball;

/**
 * @author Hod Amar <hod110@gmail.com>
 * @since 2021-06-01
 * */


public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * constructor.
     *
     * @param scoreCounter game.Counter
     */

    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * when block is being hit, the hitEvent method is increasing the counter in 5 pnt.
     *
     * @param beingHit block
     * @param hitter   ball
     */

    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);

    }

}