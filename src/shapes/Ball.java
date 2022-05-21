package shapes;

import biuoop.DrawSurface;
import game.Sprite;
import game.Velocity;
import game.GameEnvironment;
import game.GameLevel;
import game.CollisionInfo;


/**
 * @author Hod Amar <hod110@gmail.com>
 * @version 1.0
 * @since 2021-04-27
 * */

public class Ball implements Sprite {
    private Point center;
    private final int r;
    private final java.awt.Color c;
    private Velocity valocity = new Velocity(1, 1);
    private GameEnvironment gameEnvironment;


    /**
     * constructor, initialize ball.
     *
     * @param center      ball center
     * @param r           radious
     * @param color       color
     * @param environment game enviroment
     */

    public Ball(Point center, int r, java.awt.Color color, GameEnvironment environment) {
        this.center = center;
        this.r = r;
        this.c = color;
        this.gameEnvironment = environment;
    }

    /**
     * constructor, initialize ball.
     *
     * @param x     - x axes of the center shapes.Point.
     * @param y     - y axes of the center shapes.Point.
     * @param r     - ball radius.
     * @param color - ball color.
     */


    public Ball(int x, int y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.r = r;
        this.c = color;
    }

    /**
     * get x point of the center.
     *
     * @return int.
     */

    // accessors
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * get y point of the center.
     *
     * @return int.
     */

    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * get radious point of the center.
     *
     * @return int.
     */

    public int getSize() {
        return this.r;
    }

    /**
     * changing the x, y points of the ball's center.
     *
     * @param x - int.
     * @param y - int.
     */

    public void setXY(int x, int y) {
        this.center = new Point(x, y);
    }

    /**
     * get the color of the ball.
     *
     * @return color.
     */

    public java.awt.Color getColor() {
        return this.c;
    }

    /**
     * draw the ball on the given DrawSurface.
     *
     * @param surface - draw surface.
     */
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.c);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.r);
    }

    /**
     * make the ball move one step.
     */

    @Override
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * add ball to the gameLevel via sprite.
     *
     * @param gameLevel gameLevel
     */

    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }

    /**
     * set velocity by given velocity.
     *
     * @param v - velocity
     */

    public void setVelocity(Velocity v) {
        this.valocity = v;
    }

    /**
     * set velocity by given x, y.
     *
     * @param dx -changing in x axes
     * @param dy -changing in y axes
     */

    public void setVelocity(double dx, double dy) {
        this.valocity = new Velocity(dx, dy);
    }

    /**
     * get the current velocity of the ball.
     *
     * @return game.Velocity.
     */

    public Velocity getVelocity() {
        if (this.valocity == null) {
            return null;
        }
        return this.valocity;
    }

    /**
     * getter.
     *
     * @return game environment.
     */

    public GameEnvironment getGameEnvironment() {
        return gameEnvironment;
    }

    /**
     * same as the above method.
     * just with constant limit.
     */


    public void moveOneStep() {
        Line trajectory = new Line(this.center, this.getVelocity().applyToPoint(this.center));
        CollisionInfo collisionInfo = this.gameEnvironment.getClosestCollision(trajectory);
        if (collisionInfo != null) {
            if (collisionInfo.collisionPoint().distance(this.center) <= (this.getSize() * 2)) {
                this.setVelocity(collisionInfo.collisionObject().hit(this, collisionInfo.collisionPoint(),
                        this.valocity));
            }
        }
        this.center = this.getVelocity().applyToPoint(this.center);
    }

    /**
     * remove the ball from the param gameLevel.
     *
     * @param gameLevel - current gameLevel
     */

    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
    }
}

