package core;

import static core.StateProcessor.deviceState;
import enums.AlarmState;
import enums.DeviceState;
import enums.SignalState;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Michał Szura
 */
public class Clock {

    static Calendar timeA = Calendar.getInstance();
    static Calendar timeB = Calendar.getInstance();
    static Calendar stopper = Calendar.getInstance();
    static Calendar alarmTime = Calendar.getInstance();
    static AlarmState alarmState = AlarmState.OFF;
    static SignalState signalState = SignalState.OFF;
    static boolean timerModeIs24h = true;
    private static boolean stop = false;
    private static boolean stopStopper = false;

    public static void start() {
        stop = false;
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                incrementSecond();
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
        stop = false;
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
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
                timeA = Calendar.getInstance();
                break;
            case TIME_B:
                timeB = Calendar.getInstance();
                break;
        }
    }

    public static void resetStopper() {
        stopStopper = false;
        stopper.set(Calendar.HOUR, 0);
        stopper.set(Calendar.MINUTE, 0);
        stopper.set(Calendar.SECOND, 0);
        stopper.set(Calendar.MILLISECOND, 0);
    }

    private static void incrementSecond() {
        switch (StateProcessor.getDeviceState()) {
            case TIME_A:
                timeA.add(Calendar.SECOND, 1);
                break;
            case TIME_B:
                timeB.add(Calendar.SECOND, 1);
                break;
        }
    }

    private static void incrementStopper() {
        stopper.add(Calendar.MILLISECOND, 1);
    }

    public static Calendar getTime() {
        switch (StateProcessor.getDeviceState()) {
            case TIME_A:
                if (timerModeIs24h) {
                    //return sdf.format(timeA.getTime());
                    return timeA;
                } else {
                    //return sdf12.format(timeA.getTime());
                    return timeA;
                }
            case TIME_B:
                //return sdf.format(timeB.getTime());
                return timeB;
            case ALARM:
                //return sdf.format(alarmTime.getTime());
                return alarmTime;
            case DATE:
                //return sdfCal.format(timeA.getTime());
                return timeA;
            case STOPPER:
                //return sdf.format(stopper.getTime());
                return stopper;
        }
        return Calendar.getInstance();
    }

    public static Calendar getDate() {
        //return sdfCal.format(timeA.getTime());
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
