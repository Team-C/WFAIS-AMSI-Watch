package core;

import enums.TimeAConfigState;
import java.util.Calendar;

/**
 *
 * @author Konrad Welc
 */
public class TimeAConfig implements Config<TimeAConfigState> {

    static TimeAConfigState configState = TimeAConfigState.DEFAULT;

    @Override
    public void increaseTimeValue() {
        switch (configState) {
            case DEFAULT:
                break;
            case HOURS:
                Clock.timeA.add(Calendar.HOUR_OF_DAY, 1);
                break;
            case MINUTES:
                Clock.timeA.add(Calendar.MINUTE, 1);
                break;
            case SECONDS:
                Clock.timeA.add(Calendar.SECOND, 1);
                break;
            case TIMEMODE:
                change24hMode();
                break;
        }
    }

    @Override
    public void cycleConfigState() {
        configState = configState.nextState();
    }

    @Override
    public TimeAConfigState getConfigState() {
        return configState;
    }

    public void change24hMode() {
        Clock.timerModeIs24h = !Clock.timerModeIs24h;
    }
}
