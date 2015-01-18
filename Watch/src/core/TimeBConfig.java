package core;

import enums.TimeBConfigState;
import java.util.Calendar;

/**
 *
 * @author Konrad Welc
 */
public class TimeBConfig implements Config<TimeBConfigState> {

    static TimeBConfigState configState = TimeBConfigState.DEFAULT;

    @Override
    public void increaseTimeValue() {
        switch (configState) {
            case DEFAULT:
                break;
            case HOURS:
                Clock.timeB.roll(Calendar.HOUR_OF_DAY, 1);
                break;
            case MINUTES:
                Clock.timeB.roll(Calendar.MINUTE, 1);
                break;
        }
    }

    @Override
    public void cycleConfigState() {
        configState = configState.nextState();
    }

    @Override
    public TimeBConfigState getConfigState() {
        return configState;
    }

}
