package display;

import core.Clock;
import core.StateProcessor;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.TimerTask;

/**
 *
 * @author Bartosz Bereza
 */
public class ClockPanel extends JPanel {

    static private JLabel time = new JLabel();

    private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm ss");
    private static final SimpleDateFormat sdf12 = new SimpleDateFormat("hh:mm ss a");
    private static final SimpleDateFormat sdfCal = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat sdfStopperInitial = new SimpleDateFormat("HH:mm:ss.SSS");
    private static final SimpleDateFormat sdfStopperLate = new SimpleDateFormat("HH:mm:ss");

    ClockPanel() {
        this.setLayout(new GridLayout(1, 1));
        this.setBackground(new Color(0, 200, 255, 255));

        this.add(this.time);

        this.refresh();
    }

    public static void refresh() {
        switch (StateProcessor.getDeviceState()) {
            case TIME_A:
                if (Clock.timerModeIs24h()) {
                    time.setText(sdf.format(Clock.getTime().getTime()));
                } else {
                    time.setText(sdf12.format(Clock.getTime().getTime()));
                }
            case TIME_B:
                time.setText(sdf.format(Clock.getTime().getTime()));
            case ALARM:
                time.setText(sdf.format(Clock.getTime().getTime()));
            case DATE:
                time.setText(sdfCal.format(Clock.getTime().getTime()));
            case STOPPER:
                time.setText(sdf.format(Clock.getTime().getTime()));
        }
        //time.setText(core.Clock.getTime().getTime().toString());
        //time.setText("text");
    }
}
