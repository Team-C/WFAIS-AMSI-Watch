package display;

import javax.swing.JFrame;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Color;

/**
 *
 * @author Bartosz Bereza
 */
//klasa publiczna stworzona tylko na potrzebę odpalania okna
public class WatchFrameTmpMain extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WatchFrame();
            }
        });
    }
}
