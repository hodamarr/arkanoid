package game;

/**
 * @author Hod Amar <hod110@gmail.com>
 * @since 2021-06-01
 * */

public class Counter {
    private int count;

    /**
     * add number to current count.
     *
     * @param number int
     */

    public void increase(int number) {
        this.count = count + number;
    }

    /**
     * subtract number from current count.
     *
     * @param number int
     */

    public void decrease(int number) {
        this.count = count - number;
    }

    /**
     * getter.
     *
     * @return current count.
     */
    public int getValue() {
        return this.count;

    }
}

