package core;

import enums.TimeBConfigState;
import java.util.Calendar;

/**
 *
 * @author Konrad Welc
 */
public class TimeBConfig implements Config {

    static TimeBConfigState configState;

    @Override
    public void increaseTimeValue() {
        switch (configState) {
            case DEFAULT:
                break;
            case HOURS:
                Clock.timeB.add(Calendar.HOUR, 1);
                break;
            case MINUTES:
                Clock.timeB.add(Calendar.MINUTE, 1);
                break;
        }
    }

    @Override
    public void cycleConfigState() {
        configState.nextState();
    }

    public TimeBConfigState getConfigState() {
        return configState;
    }

}
