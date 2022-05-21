package removers;

import game.Block;
import game.Counter;
import game.GameLevel;
import shapes.Ball;

/**
 * @author Hod Amar <hod110@gmail.com>
 * @since 2021-06-01
 * */

public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;

    /**
     * constructor.
     *
     * @param gameLevel          gameLevel
     * @param removedBlocks counter
     */

    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;
    }

    /**
     * get notify when a block being hit.
     * this method remove it from gameLevel.
     * decreasing counter
     *
     * @param beingHit - block that being hit
     * @param hitter    - ball
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(this.gameLevel);
        beingHit.removeHitListener(this);

        remainingBlocks.decrease(1);
    }
}