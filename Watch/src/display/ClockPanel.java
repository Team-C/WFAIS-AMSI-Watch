package display;

import core.Clock;
import core.StateProcessor;

import enums.*;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.SwingConstants;

/**
 *
 * @author Bartosz Bereza
 */
public class ClockPanel extends JPanel {

    private static JLabel time = new JLabel("", SwingConstants.CENTER);
    private static JLabel alarm = new JLabel("", SwingConstants.CENTER);

    private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm ss");
    private static final SimpleDateFormat sdf12 = new SimpleDateFormat("hh:mm ss a");
    private static final SimpleDateFormat sdfCal = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat sdfStopperInitial = new SimpleDateFormat("HH:mm:ss.SSS");
    private static final SimpleDateFormat sdfStopperLate = new SimpleDateFormat("HH:mm:ss");

    private static boolean flickerVisible = true;

    ClockPanel() {
        this.setLayout(new GridLayout(3, 1));
        this.setBackground(new Color(0, 200, 255, 255));

        this.add(this.alarm);
        this.add(this.time);
        time.setFont(new Font("TimesRoman", Font.BOLD, 60));
        alarm.setFont(new Font("TimesRoman", Font.BOLD, 20));

        this.refresh();
    }

    public static void refresh() {

        //TODO DATE DISPLAY
        //TODO ALARM IMAGES
        //TODO EDIT STATE CHECK
        switch (StateProcessor.getDeviceState()) {
            case TIME_A:
                switch ((enums.TimeAConfigState) core.StateProcessor.getConfig().getConfigState()) {
                    case SECONDS:
                        if (flickerVisible) {
                            if (Clock.timerModeIs24h()) {
                                time.setText(new SimpleDateFormat("HH:mm __").format(Clock.getTime().getTime()));
                            } else {
                                time.setText(new SimpleDateFormat("hh:mm __ a").format(Clock.getTime().getTime()));
                            }
                            flickerVisible = false;
                        } else {
                            if (Clock.timerModeIs24h()) {
                                time.setText(sdf.format(Clock.getTime().getTime()));
                            } else {
                                time.setText(sdf12.format(Clock.getTime().getTime()));
                            }
                            flickerVisible = true;
                        }
                        break;
                    case MINUTES:
                        if (flickerVisible) {
                            if (Clock.timerModeIs24h()) {
                                time.setText(new SimpleDateFormat("HH:__ ss").format(Clock.getTime().getTime()));
                            } else {
                                time.setText(new SimpleDateFormat("hh:__ ss a").format(Clock.getTime().getTime()));
                            }
                            flickerVisible = false;
                        } else {
                            if (Clock.timerModeIs24h()) {
                                time.setText(sdf.format(Clock.getTime().getTime()));
                            } else {
                                time.setText(sdf12.format(Clock.getTime().getTime()));
                            }
                            flickerVisible = true;
                        }
                        break;
                    case HOURS:
                        if (flickerVisible) {
                            if (Clock.timerModeIs24h()) {
                                time.setText(new SimpleDateFormat("__:mm ss").format(Clock.getTime().getTime()));
                            } else {
                                time.setText(new SimpleDateFormat("__:mm ss a").format(Clock.getTime().getTime()));
                            }
                            flickerVisible = false;
                        } else {
                            if (Clock.timerModeIs24h()) {
                                time.setText(sdf.format(Clock.getTime().getTime()));
                            } else {
                                time.setText(sdf12.format(Clock.getTime().getTime()));
                            }
                            flickerVisible = true;
                        }
                        break;
                    case TIMEMODE:
                        if (flickerVisible) {
                            if (Clock.timerModeIs24h()) {
                                time.setText(new SimpleDateFormat("__:__ __").format(Clock.getTime().getTime()));
                            } else {
                                time.setText(new SimpleDateFormat("__:__ __ a").format(Clock.getTime().getTime()));
                            }
                            flickerVisible = false;
                        } else {
                            if (Clock.timerModeIs24h()) {
                                time.setText(sdf.format(Clock.getTime().getTime()));
                            } else {
                                time.setText(sdf12.format(Clock.getTime().getTime()));
                            }
                            flickerVisible = true;
                        }
                        break;
                    case DEFAULT:
                        if (Clock.timerModeIs24h()) {
                            time.setText(sdf.format(Clock.getTime().getTime()));
                        } else {
                            time.setText(sdf12.format(Clock.getTime().getTime()));
                        }
                }
                break;
            case TIME_B:
                switch ((enums.TimeBConfigState) core.StateProcessor.getConfig().getConfigState()) {
                    case MINUTES:
                        if (flickerVisible) {
                            time.setText(new SimpleDateFormat("HH:__ ss").format(Clock.getTime().getTime()));
                            flickerVisible = false;
                        } else {
                            time.setText(sdf.format(Clock.getTime().getTime()));
                            flickerVisible = true;
                        }
                        break;
                    case HOURS:
                        if (flickerVisible) {
                            time.setText(new SimpleDateFormat("__:mm ss").format(Clock.getTime().getTime()));
                            flickerVisible = false;
                        } else {
                            time.setText(sdf.format(Clock.getTime().getTime()));
                            flickerVisible = true;
                        }
                        break;
                    case DEFAULT:
                        time.setText(sdf.format(Clock.getTime().getTime()));
                }
                break;
            case ALARM:
                switch ((enums.AlarmConfigState) core.StateProcessor.getConfig().getConfigState()) {
                    case SOUND:
                        break;
                    case MINUTES:
                        System.out.println("lel");
                        if (flickerVisible) {
                            System.out.println("lel3");
                            time.setText(new SimpleDateFormat("HH:__ ss").format(Clock.getTime().getTime()));
                            flickerVisible = false;
                        } else {
                            System.out.println("lel2");
                            time.setText(sdf.format(Clock.getTime().getTime()));
                            flickerVisible = true;
                        }
                        break;
                    case HOURS:
                        if (flickerVisible) {
                            time.setText(new SimpleDateFormat("__:mm ss").format(Clock.getTime().getTime()));
                            flickerVisible = false;
                        } else {
                            time.setText(sdf.format(Clock.getTime().getTime()));
                            flickerVisible = true;
                        }
                        break;
                    case DEFAULT:
                        time.setText(sdf.format(Clock.getTime().getTime()));
                }
                time.setText(sdf.format(Clock.getTime().getTime()));
                break;
            case DATE:
                switch ((enums.DateConfigState) core.StateProcessor.getConfig().getConfigState()) {
                    case DAY:
                        break;
                    case MONTH:
                        break;
                    case DEFAULT:
                        time.setText(sdfCal.format(Clock.getTime().getTime()));
                }
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
