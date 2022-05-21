package removers;

/**
 * @author Hod Amar <hod110@gmail.com>
 * @since 2021-06-01
 * */

public interface HitNotifier {
    /**
     * Add hl as a listener to hit events.
     *
     * @param hl listener
     */

    void addHitListener(HitListener hl);

    /**
     * Remove hl from the list of listeners to hit events.
     *
     * @param hl listener
     */
    void removeHitListener(HitListener hl);
}