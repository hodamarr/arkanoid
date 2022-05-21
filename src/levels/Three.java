package levels;

import backgrounds.RegularBackground;
import game.Block;
import game.Sprite;
import game.Velocity;
import shapes.Point;
import shapes.Rectangle;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Hod Amar <hod110@gmail.com>
 * @version 1.0
 * @since 2021-06-14 */


public class Three implements LevelInformation {
    private int paddleSpeed = 7;
    private int paddleWidth = 120;
    private String levelName = "Green Screen";
    private int numBlockToRemove = 30;
    private int numberOfBalls = 2;

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
            l.add(v.fromAngleAndSpeed(-60 + 45 * (i + 1), 4));
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
        RegularBackground b = new RegularBackground(new Color(71, 181, 71));
        return b;
    }

    @Override
    public List<Block> blocks() {
        List b = new ArrayList();
        Random r = new Random();
        int color = r.nextInt();
        int l = 8;
        double x = 230;
        double y = 110;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < l; j++) {
                Block block = new Block(new Rectangle(new Point(x, y), 70, 30, new Color(color)));
                b.add(block);
                x += 70;
            }
            color = r.nextInt();
            l = l - 1;
            x = 230 + (70 * (i + 1));
            y += 30;
        }
        return b;
    }


    @Override
    public int numberOfBlocksToRemove() {
        return numBlockToRemove;
    }
}
