package game;


import shapes.Ball;
import shapes.Point;
import shapes.Rectangle;

/**
 * @author Hod Amar <hod110@gmail.com>
 * @version 1.0
 * @since 2021-04-27
 * */

public interface Collidable {

   /**
    * Return the "collision shape" of the object.
    *
    * @return rectangle
    */
   Rectangle getCollisionRectangle();

   /**
    * Notify the object that we collided with it at collisionPoint with
    * a given velocity.
    * The return is the new velocity expected after the hit (based on
    * the force the object inflicted on us).
    *
    * @param collisionPoint  shapes.Point collision
    * @param currentVelocity game.Velocity
    * @param hitter          ball.
    * @return game.Velocity
    */
   Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}