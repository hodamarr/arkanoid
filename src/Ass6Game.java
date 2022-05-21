import game.Counter;
import game.GameFlow;
import levels.One;
import levels.Two;
import levels.Three;
import levels.Four;
import levels.LevelInformation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hod Amar <hod110@gmail.com>
 * @version 1.0
 * @since 2021-04-27
 * */

public class Ass6Game {
    /**
     * Create a game object, initialize paddle, two balls, and blocks. and runs it. ( 800 * 600).
     *
     * @param args regular main
     */
    public static void main(String[] args) {
        /// init

        One one = new One();
        Two two = new Two();
        Three three = new Three();
        Four four = new Four();
        Counter score = new Counter();
        int a;
        List<LevelInformation> level = new ArrayList<>();


        if (args.length == 8) {
            level.add(one);
            level.add(two);
            level.add(three);
            level.add(four);
        } else {
            for (int i = 0; i < args.length; i++) {
                try {
                    a = Integer.parseInt(args[i]);
                } catch (Exception exception) {
                    continue;
                }
                if (a == 1) {
                    level.add(one);
                }
                if (a == 2) {
                    level.add(two);
                }
                if (a == 3) {
                    level.add(three);
                }
                if (a == 4) {
                    level.add(four);
                }

            }

        }

        GameFlow gameFlow = new GameFlow(score);
        gameFlow.runLevels(level);
    }
}
