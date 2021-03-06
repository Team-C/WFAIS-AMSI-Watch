package core;

import enums.AlarmConfigState;
import enums.AlarmState;
import enums.DeviceState;
import enums.SignalState;
import enums.TimeAConfigState;
import enums.TimeBConfigState;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import sound.ToneGenerator;

/**
 *
 * @author Michał Szura
 */
public class Clock {

    static Calendar timeA = Calendar.getInstance(Locale.GERMANY);
    static Calendar timeB = Calendar.getInstance(Locale.CHINA);
    static Calendar stopper = Calendar.getInstance();
    static Calendar alarmTime = Calendar.getInstance();
    static AlarmState alarmState = AlarmState.OFF;
    static SignalState signalState = SignalState.OFF;
    static boolean timerModeIs24h = true;
    private static boolean stop = false;
    private static boolean stopStopper = false;
    static int alarmTimer = 0;
    static int bells = 0;

    public static void start() {
        stop = false;
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                incrementSecond();
                if ((alarmState.equals(AlarmState.SET)) && (alarmTime.before(timeA)) && (AlarmConfig.configState.equals(AlarmConfigState.DEFAULT))) {
                    alarmState = AlarmState.ON;
                    sound.ToneGenerator.genAlarmTone();
                }
                if ((alarmState.equals(AlarmState.ON)) && (alarmTimer >= 60)) {
                    alarmState = AlarmState.OFF;
                    alarmTimer = 0;
                    sound.ToneGenerator.stopAlarm();
                }
                if ((alarmState.equals(AlarmState.ON)) && (alarmTimer < 60)) {
                    alarmTimer++;
                }
                if ((signalState.equals(SignalState.SET)) && (timeA.get(Calendar.MINUTE) == 0) && (timeA.get(Calendar.SECOND) == 0)) {
                    Timer timer = new Timer();
                    bells = timeA.get(Calendar.HOUR);
                    timer.scheduleAtFixedRate(new TimerTask() {
                        public void run() {
                            bells--;
                            sound.ToneGenerator.genButtonBTone();
                            if (bells <= 0) {
                                cancel();
                            }
                        }
                    }, 0, 1000);
                }
                if (!StateProcessor.getDeviceState().equals(DeviceState.STOPPER)) {
                    display.ClockPanel.refresh();
                }
                if (stop) {
                    cancel();
                }
            }
        }, 0, 1000);
    }

    public static void startStopper() {
        stopStopper = false;
        Timer timer2 = new Timer();
        timer2.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                incrementStopper();
                if (StateProcessor.getDeviceState().equals(DeviceState.STOPPER)) {
                    display.ClockPanel.refresh();
                }
                if (stopStopper) {
                    cancel();
                }
            }
        }, 0, 1);
    }

    public static void stop() {
        stop = true;
    }

    public static void stopStopper() {
        stopStopper = true;
    }

    public static void reset() {
        stop = false;
        switch (StateProcessor.getDeviceState()) {
            case TIME_A:
                timeA = Calendar.getInstance(Locale.GERMANY);
                break;
            case TIME_B:
                timeB = Calendar.getInstance(Locale.CHINA);
                break;
        }
    }

    public static void resetStopper() {
        stopStopper = true;
        stopper.set(Calendar.HOUR_OF_DAY, 0);
        stopper.set(Calendar.MINUTE, 0);
        stopper.set(Calendar.SECOND, 0);
        stopper.set(Calendar.MILLISECOND, 0);
    }

    private static void incrementSecond() {
        if (StateProcessor.getConfig() instanceof TimeAConfig && !TimeAConfig.configState.equals(TimeAConfigState.DEFAULT)) {
            //IF EDITING
        } else {
            timeA.add(Calendar.SECOND, 1);
        }
        if (StateProcessor.getConfig() instanceof TimeBConfig && !TimeBConfig.configState.equals(TimeBConfigState.DEFAULT)) {
            //IF EDITING
        } else {
            timeB.add(Calendar.SECOND, 1);
        }
    }

    private static void incrementStopper() {
        stopper.add(Calendar.MILLISECOND, 1);
    }

    public static Calendar getTime() {
        switch (StateProcessor.getDeviceState()) {
            case TIME_A:
                if (timerModeIs24h) {
                    return timeA;
                } else {
                    return timeA;
                }
            case TIME_B:
                return timeB;
            case ALARM:
                return alarmTime;
            case DATE:
                return timeA;
            case STOPPER:
                return stopper;
        }
        return Calendar.getInstance();
    }

    public static Calendar getDate() {
        return timeA;
    }

    public static boolean isAlarmOn() {
        if (alarmState.equals(AlarmState.valueOf("SET"))) {
            return true;
        }
        if (alarmState.equals(AlarmState.valueOf("ON"))) {
            return true;
        }
        return false;
    }

    public static boolean isSignalOn() {
        if (signalState.equals(SignalState.valueOf("SET"))) {
            return true;
        }
        return false;
    }

    public static boolean timerModeIs24h() {
        return timerModeIs24h;
    }

}
