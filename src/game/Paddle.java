package game;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import shapes.Ball;
import shapes.Line;
import shapes.Point;
import shapes.Rectangle;

import java.awt.Color;

/**
 * @author Hod Amar <hod110@gmail.com>
 * @version 1.0
 * @since 2021-04-12 */

public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Block paddle;
    private Line s;
    private Color c = new Color(100, 100, 100);
    private int speed;
    private int width;


    /**
     * constructor.
     *
     * @param gui   grapic
     * @param width paddle width
     * @param speed paddle speed
     */

    public Paddle(GUI gui, int width, int speed) {
        int paddleX = 390 - (width / 2);
        this.paddle = new Block(new Point(paddleX, 580), width, 10, c);
        this.keyboard = gui.getKeyboardSensor();
        this.speed = speed;
        this.width = width;
    }


    /**
     * moving the paddle left by keyboard.
     */


    public void moveLeft() {
        if (this.paddle.getCollisionRectangle().getUpperLeft().getX() > 10) {
            Point p = new Point(this.paddle.getCollisionRectangle().getUpperLeft().getX() - speed, 580);
            this.paddle = new Block(new Rectangle(p, width, 10, c));
        }
    }

    /**
     * moving the paddle right by keyboard.
     */

    public void moveRight() {
        if (this.paddle.getCollisionRectangle().getUpperLeft().getX() < 790 - width) {
            Point p = new Point(this.paddle.getCollisionRectangle().getUpperLeft().getX() + speed, 580);
            this.paddle = new Block(new Rectangle(p, width, 10, c));
        }
    }

    /**
     * draw the paddle on the given surface.
     *
     * @param d surface
     */

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.c);
        this.paddle.drawOn(d);
    }


    /**
     * get the keyboard press.
     */

    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        } else if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
    }

    /**
     * returning the upperline of the paddle.
     *
     * @return shapes.Line.
     */

    public Line getUpperLine() {
        double x1 = this.paddle.getCollisionRectangle().getUpperLeft().getX();
        double x2 = this.paddle.getCollisionRectangle().getUpperLeft().getX()
                + this.paddle.getCollisionRectangle().getWidth();
        return new Line(x1, 580, x2, 580);
    }

    /**
     * getter.
     *
     * @return rectangle
     */

    public Rectangle getCollisionRectangle() {
        return this.paddle.getCollisionRectangle();
    }

    /**
     * hit method get the collision point on the paddle and return the valocity by angle.
     *
     * @param collisionPoint  point
     * @param currentVelocity game.Velocity
     * @param hitter          ball
     * @return game.Velocity
     */

    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Velocity v = currentVelocity;
        Line top = getUpperLine();
        double hit = collisionPoint.getX() - top.start().getX();
        int angle = angle(hit);
        double currentx = currentVelocity.getDx();
        double currenty = currentVelocity.getDy();
        double current = Math.sqrt((Math.pow(currentx, 2) + Math.pow(currenty, 2)));
        v = v.fromAngleAndSpeed(angle, current);
        return v;
    }

    /**
     * this method get the hit area and return the angle that the paddle should throw the object.
     *
     * @param hit double
     * @return int angle of the new Velcoity
     */


    public int angle(double hit) {
        int angle = 0;
        if (hit >= 0 && hit <= (this.width / 5)) {
            angle = 300;
        } else if (hit > (this.width / 5) && hit <= (this.width / 5) * 2) {
            angle = 330;
        } else if (hit > (this.width / 5) * 2 && hit <= (this.width / 5) * 3) {
            angle = 0;
        } else if (hit > (this.width / 5) * 3 && hit <= (this.width / 5) * 4) {
            angle = 30;
        } else if (hit > (this.width / 5) * 4 && hit <= (this.width / 5) * 5) {
            angle = 60;
        }
        return angle;
    }

    /**
     * add the paddle to game by adding to collidable.
     *
     * @param g the game that hold this collidable.
     */

    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    @Override
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }

}