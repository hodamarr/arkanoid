package game;

import shapes.Line;
import shapes.Point;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Hod Amar <hod110@gmail.com>
 * @version 1.0
 * @since 2021-04-27
 * */

public class GameEnvironment {
    private List<Collidable> co = new ArrayList<Collidable>();

    /**
     * getter.
     *
     * @return list of collidable/
     */

    public List<Collidable> getCo() {
        return co;
    }

    /**
     * add the given collidable to the environment.
     *
     * @param c collidable
     */


    public void addCollidable(Collidable c) {
        this.co.add(c);
    }

    /**
     * getClosestCollision gets trajectory line and check where is the closest collition in this line.
     * holding 2 lists - collision point and their objects.
     * then finding the closest.
     *
     * @param trajectory the line that we search a collision on
     * @return new collision info with the point and object.s
     */

    public CollisionInfo getClosestCollision(Line trajectory) {

        /// make an arrays of the intersection points and those objects.
        List<Point> closeIntersectionPnt = new ArrayList();
        List<Collidable> collidableObject = new ArrayList();
        for (int i = 0; i < co.size(); i++) {
            Collidable c = this.co.get(i);
            Point point = trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle());
            if (point != null) {
                closeIntersectionPnt.add(point);
                collidableObject.add(c);
            }
        }
        /// if there are no intersection points
        if (closeIntersectionPnt.isEmpty()) {
            return null;
        }

        /// if there are intersection points
        /// sort them and return info of the closeset collidable.
        Collidable temp = collidableObject.get(0);
        Point min = closeIntersectionPnt.get(0);
        for (int i = 0; i < closeIntersectionPnt.size(); i++) {
            if (min.distance(trajectory.start()) > closeIntersectionPnt.get(i).distance(trajectory.start())) {
                temp = collidableObject.get(i);
                min = closeIntersectionPnt.get(i);
            }
        }
        return new CollisionInfo(min, temp);
    }

    /**
     * remove collidable c from game.
     *
     * @param c - collidable.
     */

    public void removeFromEnv(Collidable c) {
        if (this.co.contains(c)) {
            this.co.remove(c);
        }
    }
}