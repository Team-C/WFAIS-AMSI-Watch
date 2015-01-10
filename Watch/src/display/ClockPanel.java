package display;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import java.util.Calendar;
import java.util.TimerTask;

/**
 *
 * @author Bartosz Bereza
 */
public class ClockPanel extends JPanel {

    static private JLabel time = new JLabel();

    ClockPanel() {
        this.setLayout(new GridLayout(1, 1));
        this.setBackground(new Color(0, 200, 255, 255));

        this.add(this.time);
        
        //this.refresh();
    }

    public void refresh() {
        time.setText(core.Clock.getTime().getTime().toString());
        //time.setText("text");
    }
}
