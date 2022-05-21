package levels;

import backgrounds.RegularBackground;
import game.Block;
import game.Sprite;
import game.Velocity;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Hod Amar <hod110@gmail.com>
 * @version 1.0
 * @since 2021-06-14 */


public class Four implements LevelInformation {
    private int paddleSpeed = 8;
    private int paddleWidth = 100;
    private String levelName = "Final Four";
    private int numBlockToRemove = 52;
    private int numberOfBalls = 3;

    @Override
    public int numberOfBalls() {
        return numberOfBalls;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List l = new ArrayList();
        Velocity v = new Velocity(0, 4);
        l.add(v.fromAngleAndSpeed(120 - 55, 4));
        l.add(v.fromAngleAndSpeed(0 - 55, 4));
        l.add(v.fromAngleAndSpeed(60 - 55, 4));
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
        return new RegularBackground(new Color(153, 204, 255));
    }

    @Override
    public List<Block> blocks() {
        List l = new ArrayList();
        Random r = new Random();
        int num = 13;
        int lineOfBlocks = 4;
        int x = 10;
        int y = 140;
        for (int i = 0; i < lineOfBlocks; i++) {
            for (int j = 0; j < num; j++) {
                int a = r.nextInt();
                Block b = new Block(new shapes.Point(x, y), 60, 30, new Color(a));
                l.add(b);
                x = x + 60;
            }
            x = 10;
            y = y + 30;

        }
        return l;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return numBlockToRemove;
    }
}
