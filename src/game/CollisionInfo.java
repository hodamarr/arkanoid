package game;

import shapes.Point;

/**
 * @author Hod Amar <hod110@gmail.com>
 * @version 1.0
 * @since 2021-04-27
 * */

public class CollisionInfo {
    private Point pnt;
    private Collidable objct;
    // the point at which the collision occurs.

    /**
     * constructor for class that hold all the collision info together.
     *
     * @param collisionPoint  point
     * @param collisionObject collidable object
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.objct = collisionObject;
        this.pnt = collisionPoint;
    }

    /**
     * geter.
     *
     * @return point
     */

    public Point collisionPoint() {
        return this.pnt;
    }

    /**
     * getter.
     *
     * @return object
     */

    // the collidable object involved in the collision.
    public Collidable collisionObject() {
        return this.objct;
    }

}