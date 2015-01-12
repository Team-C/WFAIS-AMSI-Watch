package core;

import enums.DateConfigState;
import java.util.Calendar;

/**
 *
 * @author Konrad Welc
 */
public class DateConfig implements Config {

    DateConfigState configState;

    @Override
    public void increaseTimeValue() {
        switch (configState) {
            case DEFAULT:
                break;
            case MONTH:
                Clock.timeA.add(Calendar.MONTH, 1);
                Clock.timeB.add(Calendar.MONTH, 1);
                break;
            case DAY:
                Clock.timeA.add(Calendar.DAY_OF_MONTH, 1);
                Clock.timeB.add(Calendar.DAY_OF_MONTH, 1);
                break;
        }
    }

    @Override
    public void cycleConfigState() {
        configState.nextState();
    }

    public DateConfigState getConfigState() {
        return configState;
    }

}
