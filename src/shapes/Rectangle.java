package shapes;

import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hod Amar <hod110@gmail.com>
 * @version 1.0
 * @since 2021-04-27
 * */


public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;
    private Color color;


    /**
     * Create a new rectangle with location and width/height.
     *
     * @param upperLeft point
     * @param width     rectangle width
     * @param height    rectangle height
     * @param color     color of it
     */
    public Rectangle(Point upperLeft, double width, double height, Color color) {
        this.height = height;
        this.width = width;
        this.upperLeft = upperLeft;
        this.color = color;
    }

    /**
     * getter.
     *
     * @return color
     */

    public Color getColor() {
        return color;
    }

    /**
     * making an array of the rectangle line.
     *
     * @return shapes.Line array
     */

    public Line[] rectanglesLines() {
        Point upperRight = new Point(upperLeft.getX() + this.width, upperLeft.getY());
        Point lowerLeft = new Point(upperLeft.getX(), upperLeft.getY() + this.height);
        Point lowerRight = new Point(upperLeft.getX() + this.width, upperLeft.getY() + this.height);

        Line[] rectangleLines = new Line[4];

        // top
        rectangleLines[0] = new Line(this.upperLeft, upperRight);
        // left
        rectangleLines[1] = new Line(this.upperLeft, lowerLeft);
        // bottom
        rectangleLines[2] = new Line(lowerLeft, lowerRight);
        // right
        rectangleLines[3] = new Line(lowerRight, upperRight);

        return rectangleLines;
    }

    /**
     * Return a (possibly empty) List of intersection points with the specified line.
     *
     * @param line line
     * @return list of intersection points.
     */


    public java.util.List<Point> intersectionPoints(Line line) {
        /// array of the rectangle lines.
        Line[] rectangleLines = rectanglesLines();
        List intersectionPoints = new ArrayList();

        for (int i = 0; i < rectangleLines.length; i++) {
            Point intersection = rectangleLines[i].intersectionWith(line);
            if (intersection != null) {
                intersectionPoints.add(intersection);
            }
        }
        return intersectionPoints;
    }

    /**
     * getter.
     *
     * @return width
     */

    // Return the width and height of the rectangle
    public double getWidth() {
        return this.width;
    }

    /**
     * getter.
     *
     * @return height
     */

    public double getHeight() {
        return this.height;
    }

    /**
     * getter.
     *
     * @return upper left point.
     */

    // Returns the upper-left point of the rectangle.
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * draw the rectangle on the given surface.
     *
     * @param surface the given surface.
     */

    public void drawOn(DrawSurface surface) {
        surface.fillRectangle((int) this.upperLeft.getX(), (int) this.upperLeft.getY(),
                (int) this.width, (int) this.height);
        surface.setColor(Color.BLACK);
        surface.drawRectangle((int) this.upperLeft.getX(), (int) this.upperLeft.getY(),
                (int) this.width, (int) this.height);
    }
}
