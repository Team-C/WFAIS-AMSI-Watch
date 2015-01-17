package display;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.GridLayout;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

/**
 *
 * @author Bartosz Bereza
 */
public class ButtonsPanel extends JPanel {
    
    ButtonA ButtonA;
    ButtonB ButtonB;

    ButtonsPanel(ClockPanel cPanel) {
        this.setLayout(new GridLayout(1,2));
        this.setBackground(new Color(0, 255, 200, 255));
        
        ButtonA = new ButtonA("A", cPanel);
        ButtonB = new ButtonB("B", cPanel);
        
        this.add(ButtonA);
        this.add(ButtonB);
    }
}
