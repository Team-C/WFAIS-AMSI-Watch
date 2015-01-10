package core;

import enums.AlarmConfigState;
import enums.DateConfigState;
import enums.DeviceState;
import enums.StopperState;
import enums.TimeAConfigState;
import enums.TimeBConfigState;

/**
 *
 * @author Michał Szura
 */
public class StateProcessor {

    static DeviceState deviceState = DeviceState.TIME_A;
    static TimeAConfig timeAConfig = new TimeAConfig();
    static TimeBConfig timeBConfig = new TimeBConfig();
    static DateConfig dateConfig = new DateConfig();
    static AlarmConfig alarmConfig = new AlarmConfig();
    static StopperConfig stopperConfig = new StopperConfig();

    public static void shortPressA() {
        switch (deviceState) {
            case TIME_A:
                if (timeAConfig.getConfigState().equals(TimeAConfigState.DEFAULT)) {
                    deviceState.nextState();
                } else {
                    if (timeAConfig.getConfigState().equals(TimeAConfigState.TIMEMODE)) {
                        timeAConfig.change24hMode();
                    } else {
                        timeAConfig.increaseTimeValue();
                    }
                }
                break;
            case TIME_B:
                if (timeBConfig.getConfigState().equals(TimeBConfigState.DEFAULT)) {
                    deviceState.nextState();
                } else {
                    timeBConfig.increaseTimeValue();
                }
                break;
            case ALARM:
                if (alarmConfig.getConfigState().equals(AlarmConfigState.DEFAULT)) {
                    deviceState.nextState();
                } else {
                    alarmConfig.increaseTimeValue();
                }
                break;
            case DATE:
                if (dateConfig.getConfigState().equals(DateConfigState.DEFAULT)) {
                    deviceState.nextState();
                } else {
                    alarmConfig.increaseTimeValue();
                }
                break;
            case STOPPER:
                deviceState.nextState();
                break;
        }
    }

    public static void shortPressB() {
        switch (deviceState) {
            case TIME_A:
                timeAConfig.cycleConfigState();
                break;
            case TIME_B:
                timeBConfig.cycleConfigState();
                break;
            case ALARM:
                alarmConfig.cycleConfigState();
                break;
            case DATE:
                dateConfig.cycleConfigState();
                break;
            case STOPPER:
                stopperConfig.cycleConfigState();
                //TODO Trigger Short Sound
                break;
        }
    }

    public static void longtPressA() {
        switch (deviceState) {
            case TIME_A:
                if (timeAConfig.getConfigState().equals(TimeAConfigState.DEFAULT)) {
                    deviceState.nextState();
                } else {
                    if (timeAConfig.getConfigState().equals(TimeAConfigState.TIMEMODE)) {
                        timeAConfig.change24hMode();
                    } else {
                        for (int i = 0; i < 5; i++) {
                            timeAConfig.increaseTimeValue();
                        }
                    }

                }
                break;
            case TIME_B:
                if (timeBConfig.getConfigState().equals(TimeBConfigState.DEFAULT)) {
                    deviceState.nextState();
                } else {
                    for (int i = 0; i < 5; i++) {
                        timeBConfig.increaseTimeValue();
                    }
                }
                break;
            case ALARM:
                if (alarmConfig.getConfigState().equals(AlarmConfigState.DEFAULT)) {
                    deviceState.nextState();
                } else {
                    for (int i = 0; i < 5; i++) {
                        alarmConfig.increaseTimeValue();
                    }
                }
                break;
            case DATE:
                if (dateConfig.getConfigState().equals(DateConfigState.DEFAULT)) {
                    deviceState.nextState();
                } else {
                    for (int i = 0; i < 5; i++) {
                        alarmConfig.increaseTimeValue();
                    }
                }
                break;
            case STOPPER:
                deviceState.nextState();
                break;
        }
    }

    public static void longPressB() {
        switch (deviceState) {
            case TIME_A:
                timeAConfig.cycleConfigState();
                break;
            case TIME_B:
                timeBConfig.cycleConfigState();
                break;
            case ALARM:
                alarmConfig.cycleConfigState();
                break;
            case DATE:
                dateConfig.cycleConfigState();
                break;
            case STOPPER:
                if (stopperConfig.getConfigState().equals(StopperState.RUNNING)) {
                    stopperConfig.cycleConfigState();
                }
                stopperConfig.reset();
                //TODO Trigger Short Sound
                break;
        }
    }

    public static Config getConfig() {
        switch (deviceState) {
            case TIME_A:
                return timeAConfig;
            case TIME_B:
                return timeBConfig;
            case ALARM:
                return alarmConfig;
            case DATE:
                return dateConfig;
            case STOPPER:
                return stopperConfig;
        }
        return null;
    }

    public static DeviceState getDeviceState() {
        return deviceState;
    }

}
