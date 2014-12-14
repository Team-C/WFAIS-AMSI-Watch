package display;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Color;

/**
 *
 * @author Bartosz Bereza
 */
public class ClockPanel extends JPanel {

    ClockPanel() {
        this.setSize(new Dimension(500, 300));        
        this.setBackground(Color.red);
        
        this.add(new JLabel());
        
        
    }
}
