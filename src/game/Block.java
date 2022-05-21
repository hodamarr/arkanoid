package game;

import biuoop.DrawSurface;
import removers.BallRemover;
import removers.HitListener;
import removers.HitNotifier;
import shapes.Ball;
import shapes.Line;
import shapes.Rectangle;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hod Amar <hod110@gmail.com>
 * @version 1.0
 * @since 2021-04-27
 * */

public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rectangle;
    private List<HitListener> hitListeners;

    /**
     * constructor.
     *
     * @param uppperLeft -upperleft point of line
     * @param width      width of block
     * @param height     height of block
     * @param c          color
     */
    public Block(shapes.Point uppperLeft, double width, double height, Color c) {
        this.hitListeners = new ArrayList<HitListener>();
        this.rectangle = new shapes.Rectangle(uppperLeft, width, height, c);
    }

    /**
     * constructor.
     *
     * @param rectangle - for ready rectangle
     */

    public Block(shapes.Rectangle rectangle) {
        this.rectangle = rectangle;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * getter.
     *
     * @return rectangle
     */

    @Override
    public shapes.Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * hit method get the collision point and the current velocity and change the velocity by the collision.
     *
     * @param collisionPoint  where object collide
     * @param currentVelocity the velocity of the object
     * @return new velocity.
     */

    @Override
    public Velocity hit(Ball hitter, shapes.Point collisionPoint, Velocity currentVelocity) {
        Line[] rectangleLines = rectangle.rectanglesLines();
        Velocity v = currentVelocity;

        /// top
        if (rectangleLines[0].isPointOnLine(collisionPoint) || rectangleLines[2].isPointOnLine(collisionPoint)) {
            v.setDy(-1 * v.getDy());
        }

        /// left
        if (rectangleLines[3].isPointOnLine(collisionPoint) || rectangleLines[1].isPointOnLine(collisionPoint)) {
            v.setDx(-1 * v.getDx());
        }
        this.notifyHit(hitter);
        return v;
    }

    /**
     * get surface and draw the block on it.
     *
     * @param d surface.
     */

    @Override
    public void drawOn(DrawSurface d) {
        this.rectangle.drawOn(d);
        d.setColor(this.rectangle.getColor());
        this.rectangle.drawOn(d);
    }

    /**
     * only for the interface.
     */

    @Override
    public void timePassed() {
    }

    /**
     * add the block to the gameLevel.
     *
     * @param gameLevel gameLevel
     */

    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
        gameLevel.addCollidable(this);
    }

    /**
     * removing block from gameLevel- by sprite and collidable as well.
     *
     * @param gameLevel -gameLevel
     */

    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeCollidable(this);
        gameLevel.removeSprite(this);
    }

    /**
     * add ballremover to hitlisteners list.
     *
     * @param hl ballremover.
     */

    public void addHitListener(BallRemover hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * notify all listeners when ball is hitting them.
     *
     * @param hitter ball.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

}