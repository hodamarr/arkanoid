package game;

import biuoop.DrawSurface;
/**
 * @author Hod Amar <hod110@gmail.com>
 * @version 1.0
 * @since 2021-04-27
 * */

public interface Sprite {
   /**
    * draw the sprite to the screen.
    *
    * @param d surface
    */

   void drawOn(DrawSurface d);

   /**
    * notify the sprite that time has passed.
    */
   void timePassed();

   /**
    * add sprite to game.
    * @param game game
    */
   void addToGame(GameLevel game);

   /**
    * remove sprite from game.
    * @param game game
    */
   void removeFromGame(GameLevel game);
}
