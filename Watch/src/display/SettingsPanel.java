/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package display;

import core.Clock;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Bartosz Bereza
 */
public class SettingsPanel extends JPanel {

    private static JLabel alarm = new JLabel("", SwingConstants.LEFT);
    private static JLabel signal = new JLabel("", SwingConstants.RIGHT);

    SettingsPanel() {
        this.setLayout(new GridLayout(1, 0));
        this.setBackground(new Color(0, 200, 255, 255));

        this.add(this.alarm);
        this.add(this.signal);
        alarm.setFont(new Font("TimesRoman", Font.BOLD, 20));
        signal.setFont(new Font("TimesRoman", Font.BOLD, 20));

        this.refresh();
    }
    
    public static void refresh() {

        //TODO DATE DISPLAY
        //TODO ALARM IMAGES
        //TODO EDIT STATE CHECK
        if (Clock.isAlarmOn()){
            alarm.setForeground(new Color(0, 0, 0, 255));
            alarm.setText("Alarm");
        } else {
            alarm.setForeground(new Color(0, 180, 235, 255));
            alarm.setText("Alarm");
        }
        if (Clock.isSignalOn()){
            signal.setForeground(new Color(0, 0, 0, 255));
            signal.setText("Hour Signal");
        } else {
            signal.setForeground(new Color(0, 180, 235, 255));
            signal.setText("Hour Signal");
        }
    }
}
