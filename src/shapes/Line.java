package shapes;

import java.util.List;

/**
 * @author Hod Amar <hod110@gmail.com>
 * @version 1.0
 * @since 2021-04-12
 * */

public class Line {

    private final Point s;
    private final Point e;

    /**
     * constructor, initialize the line by two points.
     *
     * @param start - the start point (x, y).
     * @param end   - the end point (x, y).
     */

    public Line(Point start, Point end) {
        this.s = start;
        this.e = end;
    }

    /**
     * constructor, initialize the line by 4 double object.
     *
     * @param x1 symbolize the x axes on start point.
     * @param y1 symbolize the y axes on start point.
     * @param x2 symbolize the x axes on end point.
     * @param y2 symbolize the y axes on end point.
     */

    public Line(double x1, double y1, double x2, double y2) {
        this.s = new Point(x1, y1);
        this.e = new Point(x2, y2);
    }

    /**
     * Return the slope of the line.
     *
     * @return double object.
     */

    public double m() {
        return ((e.getY() - s.getY()) / (e.getX() - s.getX()));
    }

    /**
     * Return the length of the line.
     *
     * @return double object.
     */

    public double length() {
        return s.distance(e);
    }

    /**
     * Returns the middle point of the line.
     *
     * @return shapes.Point object.
     */

    public Point middle() {
        return new Point((s.getX() + e.getX()) / 2, (s.getY() + e.getY()) / 2);
    }

    /**
     * Returns the start point of the line.
     * @return shapes.Point Object
     */

    public Point start() {
        return s;
    }

    /**
     * Returns the end point of the line.
     *
     * @return shapes.Point Object.
     */

    public Point end() {
        return e;

    }

    /**
     * Returns true if the lines intersect, false otherwise.
     * first- check if the slopes are equal.
     * if not- checking for the intersection point, if is exist- returning true.
     * else, returning false.
     *
     * @param other - other line (for intersection)
     * @return true or false.
     */

    public boolean isIntersecting(Line other) {
        // if the slopes are the same
        double m1 = this.m();
        double m2 = this.m();
        if (m1 == m2) {
            boolean a = isPointOnLine(this, other.s.getX(), other.s.getY());
            boolean b = isPointOnLine(this, other.e.getX(), other.e.getY());
            boolean c = isPointOnLine(other, this.s.getX(), this.s.getY());
            boolean d = isPointOnLine(other, this.e.getX(), this.e.getY());
            return !(!a && !b && !c && !d);
        }

        return (this.intersectionWith(other) != null);
    }


    /**
     * check if the given (X, Y) is on the line.
     * Checks whether the x\y of the start is greater than the x\y of the end or else, and therefore is checking if
     * the X\Y param is between them.
     *
     * @param point - the point to check if it is inside
     * @return return true if the point (X, Y) it is on the given line {(x1, y1), (x2, y2)}, else, return false.
     */


    public boolean isPointOnLine(Point point) {
        double x1 = this.s.getX(), y1 = this.s.getY(), x2 = this.e.getX(), y2 = this.e.getY();

        double xx = point.getX();
        double yy = point.getY();

        if (x1 >= x2) {
            if (xx > x1 || xx < x2) {
                return false;
            }
        } else {
            if (xx > x2 || xx < x1) {
                return false;
            }
        }
        if (y1 >= y2) {
            if (yy > y1 || yy < y2) {
                return false;
            }
        } else {
            if (yy > y2 || yy < y1) {
                return false;
            }
        }
        return true;
    }

    /**
     * check if the given point is on the line.
     *
     * @param line the line
     * @param xx   x of given point
     * @param yy   y of given point
     * @return boolean
     */

    public boolean isPointOnLine(Line line, double xx, double yy) {
        double x1 = line.s.getX(), y1 = line.s.getY(), x2 = line.e.getX(), y2 = line.e.getY();


        if (x1 >= x2) {
            if (xx > x1 || xx < x2) {
                return false;
            }
        } else {
            if (xx > x2 || xx < x1) {
                return false;
            }
        }
        if (y1 >= y2) {
            if (yy > y1 || yy < y2) {
                return false;
            }
        } else {
            if (yy > y2 || yy < y1) {
                return false;
            }
        }
        return true;


    }

    /**
     * this function returning the intersection point.
     * if its the same line - returning null
     * if there is inf points - retuning null
     *
     * @param other -line
     * @return the intersection point if the lines intersect, and null otherwise.
     */


    public Point intersectionWith(Line other) {

        /// if other is null
        if (other == null) {
            return null;
        }

        /// line 1 is the opposite of line 2
        if (this.e.equals(other.s) && this.s.equals(other.e)) {
            return null;
        }

        // they are the same line.
        if (this.equals(other)) {
            return null;
        }

        // if the slopes are INF.
        double m2 = other.m(), m1 = this.m();
        if (m1 == Double.POSITIVE_INFINITY || m1 == Double.NEGATIVE_INFINITY) {
            m1 = 0.0;
        }
        if (m2 == Double.POSITIVE_INFINITY || m2 == Double.NEGATIVE_INFINITY) {
            m2 = 0.0;
        }

        /// if they are both zero
        if (m1 == 0.0 && m2 == 0.0) {
            Point intersectionPnt = this.slopesAreZero(other);
            if (intersectionPnt != null) {
                return intersectionPnt;
            }
            return null;
        }

        //if one of them is zero
        if (m1 == 0 || m2 == 0) {
            Point intersection;
            if (m1 == 0) {
                intersection = this.oneSlopeIsZero(other);
            } else {
                intersection = other.oneSlopeIsZero(this);
            }
            if (intersection != null) {
                return intersection;
            }
            return null;
        }

        // otherwise - check for the intersection point for infinity line.
        double x1 = this.s.getX(), y1 = this.s.getY();
        double x2 = other.s.getX(), y2 = other.s.getY();
        double intersectionX = ((-m2 * x2 + m1 * x1 + y2 - y1) / (m1 - m2));
        double intersectionY = m1 * intersectionX - m1 * x1 + y1;
        if (Double.isNaN(intersectionX) || Double.isNaN(intersectionY)) {
            return null;
        }

        // check if the point it is in the line
        boolean lineA = isPointOnLine(this, intersectionX, intersectionY);
        boolean lineB = isPointOnLine(other, intersectionX, intersectionY);
        if (lineA && lineB) {
            return new Point(intersectionX, intersectionY);
        }
        return null;
    }

    /**
     * one slop is zero
     * important - the shapes.Line that call this function is the one with the zero slope.
     * check whether this line is parallel to x axes or y
     * then generate point and check if it in the both 2 lines.
     *
     * @param other shapes.Line
     * @return null if there is no intersection line
     * else, the intersection line.
     */

    public Point oneSlopeIsZero(Line other) {
        /// the shapes.Line that call this function is the one with the zero slope.
        double x1 = other.s.getX();
        double y1 = other.s.getY();
        double m1 = other.m();
        Point pnt;
        if (this.s.getX() == this.e.getX()) {
            double x = this.s.getX();
            double y = m1 * x - m1 * x1 + y1;
            pnt = new Point(x, y);
        } else {
            double y = this.s.getY();
            double x = ((y - y1 + m1 * x1) / m1);
            pnt = new Point(x, y);
        }
        boolean a = this.isPointOnLine(pnt);
        boolean b = other.isPointOnLine(pnt);
        if (a && b) {
            return pnt;
        }
        return null;
    }

    /**
     * when the slopes both are zero.
     * check which line is parallel to x axes and other, then generate point.
     * and check if it is on the both lines.
     *
     * @param other shapes.Line
     * @return null if there is no intersection line
     * else, the intersection line.
     */


    public Point slopesAreZero(Line other) {
        double m1 = this.m();
        double m2 = other.m();

        if (this.s.getX() == this.e.getX()) {
            Point check1 = new Point(this.e.getX(), other.s.getY());
            boolean thisline1 = this.isPointOnLine(check1);
            boolean otherline1 = other.isPointOnLine(check1);
            if (thisline1 && otherline1) {
                return check1;
            }
        } else {
            Point check2 = new Point(other.s.getX(), this.s.getY());
            boolean thisline2 = this.isPointOnLine(check2);
            boolean otherline2 = other.isPointOnLine(check2);
            if (thisline2 && otherline2) {
                return check2;
            }

        }
        return null;

    }

    /**
     * check if this shapes.Line and Other are equal.
     *
     * @param other -line
     * @return true is the lines are equal, false otherwise.
     */

    // equals -- return true is the lines are equal, false otherwise
    public boolean equals(Line other) {
        if (other == null) {
            return false;
        }
        return (this.s.equals(other.s) && this.e.equals(other.e));
    }

    /**
     * If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the start of the line.
     *
     * @param rect rectangle
     * @return point.
     */


    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> intersection = rect.intersectionPoints(this);
        if (intersection.isEmpty()) {
            return null;
        }

        Point minimal = intersection.get(0);

        for (int i = 0; i < intersection.size(); i++) {
            if (minimal.distance(this.start()) > intersection.get(i).distance(this.start())) {
                minimal = intersection.get(i);
            }
        }

        return minimal;
    }

}
