package levels;

import backgrounds.BackgroundOne;
import game.Block;
import game.Sprite;

import game.Velocity;
import shapes.Point;
import shapes.Rectangle;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hod Amar <hod110@gmail.com>
 * @version 1.0
 * @since 2021-06-14 */


public class One implements LevelInformation {
    private int paddleSpeed = 5;
    private int paddleWidth = 120;
    private String levelName = "One Shot";
    private int numBlockToRemove = 1;

    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List l = new ArrayList();
        Velocity v = new Velocity(0, -5);
        v.fromAngleAndSpeed(0, 5);
        l.add(v);
        return l;
    }

    @Override
    public int paddleSpeed() {
        return paddleSpeed;
    }

    @Override
    public int paddleWidth() {
        return paddleWidth;
    }

    @Override
    public String levelName() {
        return levelName;
    }

    @Override
    public Sprite getBackground() {
        BackgroundOne background = new BackgroundOne(Color.lightGray);
        return background;
    }

    @Override
    public List<Block> blocks() {
        List list = new ArrayList();
        Block block = new Block(new Rectangle(new Point(365, 200), 50, 50, Color.black));
        list.add(block);
        return list;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return numBlockToRemove;
    }
}
