package levels;

import game.Block;
import game.Sprite;
import game.Velocity;

import java.util.List;
/**
 * @author Hod Amar <hod110@gmail.com>
 * @version 1.0
 * @since 2021-06-14 */


public interface LevelInformation {

    /**
     * int number.
     * @return number of ball in the level
     */
    int numberOfBalls();

    /**
     * The initial velocity of each ball.
     * initialBallVelocities().size() == numberOfBalls().
     * @return list of velocities.
     */
    List<Velocity> initialBallVelocities();

    /**
     * paddle speed.
     * @return int
     */

    int paddleSpeed();

    /**
     * paddle width.
     * @return int
     */

    int paddleWidth();

    /**
     * the level name will be displayed at the top of the screen.
     * @return string
     */
    String levelName();

    /**
     * Returns a sprite with the background of the level.
     * @return Sprite
     */
    Sprite getBackground();

    /**
     * The Blocks that make up this level, each block contains
     * its size, color and location.
     * @return list of ready blocks
     */
    List<Block> blocks();

    /**
     *  Number of blocks that should be removed.
     * @return int
     */


    int numberOfBlocksToRemove();
}