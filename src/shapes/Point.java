package shapes;

import static java.lang.Math.pow;

/**
 * @author Hod Amar <hod110@gmail.com>
 * @version 1.0
 * @since 2021-04-12
 * */

public class Point {
    private final double x;
    private final double y;


    /***
     * constructor, initialize the shapes.Point.
     * @param x - the point x on axes.
     * @param y - the point y on axes.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /***
     * calculate the distance between the object to param other.
     * by the formula - sqrt((x2-x1)^2 + (y2-y1)^2).
     * - the other point.
     * @param other shapes.Point
     * @return the distance of this point to the other point in double type.
     */

    public double distance(Point other) {
        return Math.sqrt(pow((other.x - this.x), 2) + pow((other.y - this.y), 2));
    }

    /***
     * check if 2 point are equals.
     * @param other -other point.
     * @return true is the points are equal, false otherwise.
     */

    public boolean equals(Point other) {
        return other.x == this.x && other.y == this.y;
    }

    /***
     * get the x value of the point.
     * @return in double type.
     */
    public double getX() {
        return this.x;
    }

    /***
     * get the Y value of the point.
     * @return in double type.
     */

    public double getY() {
        return this.y;
    }

}