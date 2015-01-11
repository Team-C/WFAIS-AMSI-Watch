package core;

import display.WatchFrame;
import java.awt.EventQueue;

/**
 *
 * @author Michał Szura
 */
public class Core {

    public static void main(String[] args) {
        core.Clock.start();

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new display.WatchFrame();
            }
        });
    }
}
