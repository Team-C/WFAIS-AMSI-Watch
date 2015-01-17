package core;

import enums.DateConfigState;
import java.util.Calendar;

/**
 *
 * @author Konrad Welc
 */
public class DateConfig implements Config<DateConfigState> {

    static DateConfigState configState = DateConfigState.DEFAULT;

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
        configState = configState.nextState();
    }

    @Override
    public DateConfigState getConfigState() {
        return configState;
    }

}
