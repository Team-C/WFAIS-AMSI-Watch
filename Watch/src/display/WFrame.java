package display;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 *
 * @author Bartosz Bereza
 */
public class WFrame extends JFrame {

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
