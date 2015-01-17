package core;

import enums.AlarmConfigState;
import java.util.Calendar;

/**
 *
 * @author Konrad Welc
 */
public class AlarmConfig implements Config<AlarmConfigState> {

    static AlarmConfigState configState = AlarmConfigState.DEFAULT;

    @Override
    public void increaseTimeValue() {
        switch (configState) {
            case DEFAULT:
                break;
            case HOURS:
                Clock.alarmTime.add(Calendar.HOUR_OF_DAY, 1);
                break;
            case MINUTES:
                Clock.alarmTime.add(Calendar.MINUTE, 1);
                break;
            case SOUND:
                break;
        }
    }

    @Override
    public void cycleConfigState() {
        configState = configState.nextState();
    }

    @Override
    public AlarmConfigState getConfigState() {
        return configState;
    }

    public void cycleAlarmStates() {
        configState.nextState();
    }
}
