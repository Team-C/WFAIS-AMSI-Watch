package core;

import enums.AlarmState;
import enums.SignalState;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Michał Szura
 */
public class Clock {

    static Calendar timeA = Calendar.getInstance();
    static Calendar timeB = Calendar.getInstance();
    static Calendar stopper = Calendar.getInstance();
    static Calendar alarmTime = Calendar.getInstance();
    static AlarmState alarmState; //TODO init
    static SignalState signalState; //TODO init
    static boolean timerModeIs24h = true;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm ss");
    private static final SimpleDateFormat sdf12 = new SimpleDateFormat("hh:mm ss a");
    private static final SimpleDateFormat sdfCal = new SimpleDateFormat("yyyy-MM-dd");

    public void start() {
        //TODO
    }

    public void stop() {
        //TODO
    }

    public void reset() {
        //TODO
    }

    public static String getTime() {
        //TODO States
        if (timerModeIs24h) {
            return sdf.format(timeA.getTime());
        } else {
            return sdf12.format(timeA.getTime());
        }
    }

    public static String getDate() {
        return sdfCal.format(timeA.getTime());
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

}
