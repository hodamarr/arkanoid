package levels;

import backgrounds.Backgroundtwo;
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


public class Two implements LevelInformation {
    private int paddleSpeed = 5;
    private int paddleWidth = 600;
    private String levelName = "404/420 BAD TRIP";
    private int numBlockToRemove = 15;
    private int numberOfBalls = 10;

    @Override
    public int numberOfBalls() {
        return this.numberOfBalls;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List l = new ArrayList();
        int i = 0;
        while (i < this.numberOfBalls) {
            Velocity v = new Velocity(0, -4);
            l.add(v.fromAngleAndSpeed(250 - 15 * i, -4));
            i++;
        }
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
        Backgroundtwo b = new Backgroundtwo(Color.white);
        return b;
    }

    @Override
    public List<Block> blocks() {
        List l = new ArrayList();
        Random r = new Random();
        int num = this.numBlockToRemove;
        int x = 10;
        for (int i = 0; i < num; i++) {
            int a = r.nextInt();
            Block b = new Block(new shapes.Point(x, 290), 52, 20, new Color(a));
            l.add(b);
            x = x + 52;

        }
        return l;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return numBlockToRemove;
    }
}
