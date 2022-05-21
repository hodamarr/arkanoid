package game;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import levels.LevelInformation;
import removers.BallRemover;
import removers.BlockRemover;
import removers.HitListener;
import shapes.Ball;
import shapes.Point;
import shapes.Rectangle;

import java.awt.Color;
import java.util.List;


/**
 * @author Hod Amar <hod110@gmail.com>
 * */

public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private Counter blockCounter;
    private Counter ballCounter;
    private Counter scoreCounter;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;
    private LevelInformation level;


    /**
     * constructor.
     * @param l level
     * @param scoreCounter counter
     * @param ar animationrunner
     * @param g GUI
     * @param keyboardSensor keyboard
     */


    public GameLevel(LevelInformation l, Counter scoreCounter, AnimationRunner ar, GUI g,
                     KeyboardSensor keyboardSensor) {
        this.level = l;
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.gui = g;
        this.blockCounter = new Counter();
        this.blockCounter.increase(this.level.numberOfBlocksToRemove());
        this.ballCounter = new Counter();
        this.ballCounter.increase(this.level.numberOfBalls());
        this.scoreCounter = scoreCounter;
        this.runner = ar;
        this.keyboard = keyboardSensor;
    }

    /**
     * add collidable object to this enviroment.
     *
     * @param c collidable object
     */

    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /**
     * add sprite object to this list.
     *
     * @param s sprite object
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * Initialize a new game: create the Blocks, shapes.Ball and game.Paddle and add them to the game.
     */

    public void initialize() {
        /// background
        Sprite b = this.level.getBackground();
        b.addToGame(this);

        /// make frame
        Block[] frame = makeFrame();
        for (int i = 0; i < frame.length; i++) {
            frame[i].addToGame(this);
        }

        /// score indicator
        ScoreIndicator scoreindicator = new ScoreIndicator(scoreCounter);
        HitListener score = new ScoreTrackingListener(scoreCounter);
        HitListener blockRemover = new BlockRemover(this, this.blockCounter);
        scoreindicator.addToGame(this);

        /// level game
        String levelname = this.level.levelName();

        /// initial balls
        int ballNum = this.level.numberOfBalls();
        List<Velocity> velocityList = this.level.initialBallVelocities();
        for (int i = 0; i < ballNum; i++) {
            Ball ball = new Ball(new Point(385, 540), 5, Color.black, this.environment);
            ball.setVelocity(velocityList.get(i));
            ball.addToGame(this);
        }

        /// initial paddle
        int paddleSpeed = this.level.paddleSpeed();
       int paddleWidth = this.level.paddleWidth();
        Paddle paddle = new Paddle(this.gui, paddleWidth, paddleSpeed);
        paddle.addToGame(this);


        /// initial blocks
        List<Block> blockList = this.level.blocks();
        int blockNum = this.level.numberOfBlocksToRemove();
        for (int i = 0; i < blockNum; i++) {
            Block block = blockList.get(i);
            block.addHitListener(blockRemover);
            block.addHitListener(score);
            block.addToGame(this);

        }


    }

    /**
     * draw on surface the name of the level.
     * @param d surface
     */

    public void draw(DrawSurface d) {
        String s = level.levelName();
        d.setColor(Color.black);
        d.drawText(400, 27, "Level Name: " + s, 15);
    }


    /**
     * make the frame by (800, 600).
     * the width of the frame is 10.
     *
     * @return array of blocks frame.
     */

    public Block[] makeFrame() {
        Block[] blocks = new Block[4];
        Color frameColor = new Color(100, 100, 100);
        blocks[0] = new Block(new Rectangle((new Point(0, 0)), 10, 600, frameColor));
        blocks[1] = new Block(new Rectangle((new Point(790, 0)), 10, 600, frameColor));
        blocks[2] = new Block(new Rectangle((new Point(0, 600)), 790, 10, frameColor));
        blocks[2].addHitListener(new BallRemover(this, this.ballCounter));
        blocks[3] = new Block(new Rectangle((new Point(0, 0)), 790, 10, frameColor));
        return blocks;
    }

    /**
     * Run the game -- start the animation loop.
     */


    public void run() {
        this.running = true;
        this.runner.run(new CountdownAnimation(2, 3, this.sprites));
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner.run(this);
    }


    /**
     * remove collidable from the list.
     *
     * @param c collidable
     */

    public void removeCollidable(Collidable c) {
        environment.removeFromEnv(c);

    }

    /**
     * remove sprite from the list.
     *
     * @param s sprite
     */

    public void removeSprite(Sprite s) {
        sprites.removeFromSprite(s);
    }


    @Override
    public void doOneFrame(DrawSurface d) {

        // the logic from the previous run method goes here.
        // the `return` or `break` statements should be replaced with
        // this.running = false;

        this.sprites.drawAllOn(d);
        draw(d);

        if (this.ballCounter.getValue() <= 0) {
            this.running = false;
        }
        if (this.blockCounter.getValue() <= 0) {
            this.scoreCounter.increase(100);
            this.running = false;
        }
        if (this.keyboard.isPressed("p")) {
            Animation pause = new KeyPressStoppableAnimation(this.keyboard, "p", new PauseScreen(this.keyboard));
            this.runner.run(pause);
        }


        this.sprites.notifyAllTimePassed();
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * getter.
     * @return ball counter.
     */

    public Counter getBallCounter() {
        return ballCounter;
    }

    /**
     * getter.
     * @return block counter.
     */

    public Counter getBlockCounter() {
        return blockCounter;
    }

}