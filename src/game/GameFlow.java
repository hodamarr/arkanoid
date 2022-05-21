package game;

import biuoop.GUI;
import biuoop.KeyboardSensor;
import levels.LevelInformation;

import java.util.List;

/**
 * @author Hod Amar <hod110@gmail.com>
 * @version 1.0
 * @since 2021-06-14 */

public class GameFlow {
    private Counter counterScore;

    /**
     * constructor.
     * @param score game score
     */

    public GameFlow(Counter score) {
        this.counterScore = score;
    }

    /**
     * run all the levels in loop.
     * hold the game over screen and winning screen.
     * initialize the fields as well.
     * @param levels levels
     */

    public void runLevels(List<LevelInformation> levels) {
        GameLevel level;
        GUI g = new GUI("Arkanoid", 800, 600);
        AnimationRunner ar = new AnimationRunner(g);
        KeyboardSensor ks = g.getKeyboardSensor();
        for (LevelInformation levelInfo : levels) {
            level = new GameLevel(levelInfo, this.counterScore, ar, g, ks);
            level.initialize();

            while (level.getBlockCounter().getValue() > 0) {
                level.run();

                if (level.getBallCounter().getValue() <= 0) {
                    break;
                }

            }

            if (level.getBallCounter().getValue() <= 0) {
                Animation wl = new WinnerLoser("Loser!!", counterScore, ks);
                Animation wl1 = new KeyPressStoppableAnimation(ks, "space", wl);
                ar.run(wl1);
                if (wl.shouldStop()) {
                    g.close();
                }

            }

        }
        Animation wl = new WinnerLoser("Winner!!", counterScore, ks);
        Animation wl1 = new KeyPressStoppableAnimation(ks, "space", wl);
        ar.run(wl1);
        if (wl.shouldStop()) {
            g.close();
        }
    }
}