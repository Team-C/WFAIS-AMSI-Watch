package display;

import core.Clock;
import core.StateProcessor;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.TimerTask;
import javax.swing.SwingConstants;

/**
 *
 * @author Bartosz Bereza
 */
public class ClockPanel extends JPanel {

    static private JLabel time = new JLabel("", SwingConstants.CENTER);

    private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm ss");
    private static final SimpleDateFormat sdf12 = new SimpleDateFormat("hh:mm ss a");
    private static final SimpleDateFormat sdfCal = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat sdfStopperInitial = new SimpleDateFormat("HH:mm:ss.SSS");
    private static final SimpleDateFormat sdfStopperLate = new SimpleDateFormat("HH:mm:ss");

    ClockPanel() {
        this.setLayout(new GridLayout(1, 1));
        this.setBackground(new Color(0, 200, 255, 255));

        this.add(this.time);
        time.setFont(new Font("TimesRoman", Font.BOLD, 70));

        this.refresh();
    }

    public static void refresh() {
        
        //TODO DATE DISPLAY
        //TODO ALARM IMAGES
        //TODO EDIT STATE CHECK
        
        switch (StateProcessor.getDeviceState()) {
            case TIME_A:
                if (Clock.timerModeIs24h()) {
                    time.setText(sdf.format(Clock.getTime().getTime()));
                } else {
                    time.setText(sdf12.format(Clock.getTime().getTime()));
                }
                break;
            case TIME_B:
                time.setText(sdf.format(Clock.getTime().getTime()));
                break;
            case ALARM:
                time.setText(sdf.format(Clock.getTime().getTime()));
                break;
            case DATE:
                time.setText(sdfCal.format(Clock.getTime().getTime()));
                break;
            case STOPPER:
                if (Clock.getTime().get(Calendar.HOUR) == 0 && Clock.getTime().get(Calendar.MINUTE) <= 30) {
                    time.setText(sdfStopperInitial.format(Clock.getTime().getTime()));
                } else {
                    time.setText(sdfStopperLate.format(Clock.getTime().getTime()));
                }
                break;
        }
    }
}
