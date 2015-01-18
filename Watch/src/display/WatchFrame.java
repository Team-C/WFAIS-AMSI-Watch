package display;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JFrame;

/**
 *
 * @author Bartosz Bereza
 */
public class WatchFrame extends JFrame {

    ClockPanel cPanel;
    ButtonsPanel bPanel;
    SettingsPanel sPanel;

    public WatchFrame() {
        super("Watch");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(new Color(0, 0, 0));
        this.setLayout(new GridLayout(3, 1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        sPanel = new SettingsPanel();
        cPanel = new ClockPanel();
        bPanel = new ButtonsPanel(cPanel);

        this.add(sPanel);
        this.add(cPanel);
        this.add(bPanel);

        Insets ins = this.getInsets();
        this.setSize(new Dimension(500 + ins.left + ins.right, 300 + ins.bottom + ins.top));
    }
}
