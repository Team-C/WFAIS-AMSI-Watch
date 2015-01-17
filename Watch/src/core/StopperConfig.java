package core;

import enums.StopperState;

/**
 *
 * @author Konrad Welc
 */
public class StopperConfig implements Config<StopperState> {

    static StopperState configState = StopperState.STOPPED;

    @Override
    public void increaseTimeValue() {
        throw new UnsupportedOperationException("Shouldn't happened.");
    }

    @Override
    public void cycleConfigState() {
        configState = configState.nextState();
        if (configState.equals(configState.RUNNING)) {
            run();
        }
        if (configState.equals(configState.STOPPED)) {
            stop();
        }
    }

    @Override
    public StopperState getConfigState() {
        return configState;
    }

    public void run() {
        Clock.startStopper();
    }

    public void stop() {
        Clock.stopStopper();
    }

    public void reset() {
        Clock.resetStopper();
    }
}
