package removers;

import game.Block;
import game.Counter;
import game.GameLevel;
import shapes.Ball;

/**
 * @author Hod Amar <hod110@gmail.com>
 * @since 2021-06-01
 * */


public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter c;

    /**
     * constructor.
     *
     * @param gameLevel    currnent gameLevel
     * @param counter ball remover counter that gameLevel holds also.
     */

    public BallRemover(GameLevel gameLevel, Counter counter) {
        this.gameLevel = gameLevel;
        this.c = counter;
    }


    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.gameLevel);
        c.decrease(1);
    }
}