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
        //TODO Alarm Check
        switch (deviceState) {
            case TIME_A:
                if (timeAConfig.getConfigState().equals(TimeAConfigState.DEFAULT)) {
                    deviceState = deviceState.nextState();
                    sound.ToneGenerator.genButtonATone();
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
                    deviceState = deviceState.nextState();
                    sound.ToneGenerator.genButtonATone();
                } else {
                    timeBConfig.increaseTimeValue();
                }
                break;
            case ALARM:
                if (alarmConfig.getConfigState().equals(AlarmConfigState.DEFAULT)) {
                    deviceState = deviceState.nextState();
                    sound.ToneGenerator.genButtonATone();
                } else {
                    alarmConfig.increaseTimeValue();
                }
                break;
            case DATE:
                if (dateConfig.getConfigState().equals(DateConfigState.DEFAULT)) {
                    deviceState = deviceState.nextState();
                    sound.ToneGenerator.genButtonATone();

                } else {
                    alarmConfig.increaseTimeValue();
                }
                break;
            case STOPPER:
                deviceState = deviceState.nextState();
                sound.ToneGenerator.genButtonATone();
                break;
        }
    }

    public static void shortPressB() {
        //TODO Alarm Check
        switch (deviceState) {
            case TIME_A:
                if (!timeAConfig.getConfigState().equals(TimeAConfigState.DEFAULT)) {
                    timeAConfig.cycleConfigState();
                }
                break;
            case TIME_B:
                if (!timeBConfig.getConfigState().equals(TimeBConfigState.DEFAULT)) {
                    timeBConfig.cycleConfigState();
                }
                break;
            case ALARM:
                if (!alarmConfig.getConfigState().equals(AlarmConfigState.DEFAULT)) {
                    alarmConfig.cycleConfigState();
                }
                break;
            case DATE:
                if (!dateConfig.getConfigState().equals(DateConfigState.DEFAULT)) {
                    dateConfig.cycleConfigState();
                }
                break;
            case STOPPER:
                stopperConfig.cycleConfigState();
                sound.ToneGenerator.genButtonBTone();
                break;
        }
    }

    public static void longPressA() {
        //TODO Alarm Check
        switch (deviceState) {
            case TIME_A:
                if (timeAConfig.getConfigState().equals(TimeAConfigState.DEFAULT)) {
                    deviceState = deviceState.nextState();
                    sound.ToneGenerator.genButtonATone();
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
                    deviceState = deviceState.nextState();
                    sound.ToneGenerator.genButtonATone();
                } else {
                    for (int i = 0; i < 5; i++) {
                        timeBConfig.increaseTimeValue();
                    }
                }
                break;
            case ALARM:
                if (alarmConfig.getConfigState().equals(AlarmConfigState.DEFAULT)) {
                    deviceState = deviceState.nextState();
                    sound.ToneGenerator.genButtonATone();
                } else {
                    for (int i = 0; i < 5; i++) {
                        alarmConfig.increaseTimeValue();
                    }
                }
                break;
            case DATE:
                if (dateConfig.getConfigState().equals(DateConfigState.DEFAULT)) {
                    deviceState = deviceState.nextState();
                    sound.ToneGenerator.genButtonATone();
                } else {
                    for (int i = 0; i < 5; i++) {
                        alarmConfig.increaseTimeValue();
                    }
                }
                break;
            case STOPPER:
                deviceState = deviceState.nextState();
                sound.ToneGenerator.genButtonATone();
                break;
        }
    }

    public static void longPressB() {
        //TODO Alarm Check
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
                sound.ToneGenerator.genButtonBTone();
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
