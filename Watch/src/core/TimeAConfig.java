package core;

import enums.TimeAConfigState;
import java.util.Calendar;

/**
 *
 * @author Konrad Welc
 */
public class TimeAConfig implements Config {

    static TimeAConfigState configState;

    @Override
    public void increaseTimeValue() {
        switch (configState) {
            case DEFAULT:
                break; 
            case HOURS:
                Clock.timeA.add(Calendar.HOUR, 1);
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
        configState.nextState();
    }

    public TimeAConfigState getConfigState() {
        return configState;
    }

    public void change24hMode() {
        Clock.timerModeIs24h = !Clock.timerModeIs24h;
    }
}
