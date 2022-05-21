package game;

import shapes.Point;

/**
 * @author Hod Amar <hod110@gmail.com>
 * @version 1.0
 * @since 2021-04-27 */


public class Velocity {
    private double dx;
    private double dy;

    /**
     * constructor, initialize the velocity.
     *
     * @param dx - is the change in x axes.
     * @param dy - is the change in y axes.
     */

    public Velocity(double dx, double dy) {
        this.dy = dy;
        this.dx = dx;
    }

    /**
     * getter.
     *
     * @return speed.
     */

    public double getSpeed() {
        return Math.sqrt(this.dx * this.dx + this.dy * this.dy);
    }

    /**
     * fromAngleAndSpeed gets angle and speed and return the velocity by x, y axes.
     * by physics formula.
     *
     * @param angle - in Degress.
     * @param speed - speed.
     * @return game.Velocity type.
     */

    public Velocity fromAngleAndSpeed(double angle, double speed) {
        angle = angle - 90;
        double dxnew = speed * Math.cos(Math.toRadians(angle));
        double dynew = speed * Math.sin(Math.toRadians(angle));
        return new Velocity(dxnew, dynew);
    }

    /***
     * Get Dx.
     * @return the change in x axes - double type.
     */

    public double getDx() {
        return dx;
    }

    /***
     * Get Dy.
     * @return the change in y axes - double type.
     */

    public double getDy() {
        return dy;
    }


    /***
     * Take a point with position (x,y) and return a new point with position (x+dx, y+dy).
     * @param p - the point that the method will change.
     * @return new shapes.Point object.
     */

    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }


    /**
     * setter.
     *
     * @param x dx velocity
     */
    public void setDx(double x) {
        this.dx = x;
    }

    /**
     * setter.
     *
     * @param d dy velocity
     */
    public void setDy(double d) {
        this.dy = d;
    }
}
