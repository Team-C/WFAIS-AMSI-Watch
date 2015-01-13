package core;

import java.awt.EventQueue;
import java.util.Calendar;

/**
 *
 * @author Michał Szura
 */
public class Core {

    StateProcessor stateProcessor = new StateProcessor();
    Clock clock = new Clock();

    public static void main(String[] args) {
        core.Clock.resetStopper();
        core.Clock.start();
        core.Clock.timeB.add(Calendar.HOUR_OF_DAY, 5);

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new display.WatchFrame();
            }
        });
    }
}
