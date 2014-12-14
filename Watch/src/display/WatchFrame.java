package display;

import javax.swing.JFrame;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Color;

/**
 *
 * @author Bartosz Bereza
 */
class WFrame extends JFrame {
    
    ClockPanel cPanel;
    ButtonsPanel bPanel;

    WFrame() {
        super("Watch");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(new GridLayout(2, 1));
        this.setBackground(new Color(0, 0, 0));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        cPanel = new ClockPanel();
        bPanel = new ButtonsPanel();
        
        this.add(cPanel);
        this.add(bPanel);
    }
}

//klasa publiczna stworzona tylko na potrzebę odpalania okna
public class WatchFrame extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WFrame();
            }
        });
    }
}
