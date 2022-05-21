package game;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;


/**
 * @author Hod Amar <hod110@gmail.com>
 * @version 1.0
 * @since 2021-06-14 */


public class WinnerLoser implements Animation {
    private String s;
    private Counter c;
    private KeyboardSensor ks;
    private boolean shouldstop;

    /**
     * constructor.
     * @param s string
     * @param counter counter
     * @param ks keyboard
     */


    public WinnerLoser(String s, Counter counter, KeyboardSensor ks) {
        this.s = s;
        this.c = counter;
        this.ks = ks;
        this.shouldstop = false;


    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(100, 300, s + " Your Score is " + this.c.getValue(), 30);
        if (ks.isPressed(ks.SPACE_KEY)) {
            this.shouldstop = true;
        }

    }

    @Override
    public boolean shouldStop() {
        return this.shouldstop;
    }
}
