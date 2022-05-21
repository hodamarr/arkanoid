package game;

import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hod Amar <hod110@gmail.com>
 * @version 1.0
 * @since 2021-04-27
 * */


public class SpriteCollection {
    private List<Sprite> spriteList = new ArrayList<Sprite>();

    /**
     * constructor.
     */
    public SpriteCollection() {
        this.spriteList = new ArrayList();
    }

    /**
     * add sprite s to list.
     *
     * @param s sprite
     */


    public void addSprite(Sprite s) {
        this.spriteList.add(s);
    }

    /**
     * getter.
     *
     * @return list
     */

    public List<Sprite> getSpriteList() {
        return spriteList;
    }

    /**
     * call timePassed() on all sprites.
     */

    public void notifyAllTimePassed() {
        for (int i = 0; i < spriteList.size(); i++) {
            this.spriteList.get(i).timePassed();
        }
    }

    /**
     * call drawOn(d) on all sprites.
     *
     * @param d surface for drawing.
     */
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < spriteList.size(); i++) {
            this.spriteList.get(i).drawOn(d);
        }

    }

    /**
     * remove the sprite from collection.
     *
     * @param sprite Sprite obj to remove
     */

    public void removeFromSprite(Sprite sprite) {
        if (this.spriteList.contains(sprite)) {
            this.spriteList.remove(sprite);
        }
    }

}
