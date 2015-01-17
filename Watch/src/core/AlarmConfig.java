package core;

import enums.AlarmConfigState;
import enums.AlarmState;
import enums.SignalState;
import enums.SoundState;
import static enums.SoundState.ALARM_OFF_SOUND_OFF;
import static enums.SoundState.ALARM_OFF_SOUND_ON;
import static enums.SoundState.ALARM_ON_SOUND_OFF;
import static enums.SoundState.ALARM_ON_SOUND_ON;
import java.util.Calendar;

/**
 *
 * @author Konrad Welc
 */
public class AlarmConfig implements Config<AlarmConfigState> {

    static AlarmConfigState configState = AlarmConfigState.DEFAULT;
    static SoundState soundState = SoundState.ALARM_OFF_SOUND_OFF;

    @Override
    public void increaseTimeValue() {
        switch (configState) {
            case DEFAULT:
                break;
            case HOURS:
                Clock.alarmTime.roll(Calendar.HOUR_OF_DAY, 1);
                break;
            case MINUTES:
                Clock.alarmTime.roll(Calendar.MINUTE, 1);
                break;
            case SOUND:
                break;
        }
    }

    public void nextSoundState() {
        soundState = soundState.nextState();
        if (soundState == SoundState.ALARM_ON_SOUND_ON) {
            core.Clock.alarmState = AlarmState.SET;
            core.Clock.signalState = SignalState.SET;
        } else if (soundState == SoundState.ALARM_ON_SOUND_OFF) {
            core.Clock.alarmState = AlarmState.SET;
            core.Clock.signalState = SignalState.OFF;
        } else if (soundState == SoundState.ALARM_OFF_SOUND_ON) {
            core.Clock.alarmState = AlarmState.OFF;
            core.Clock.signalState = SignalState.SET;
        } else {
            core.Clock.alarmState = AlarmState.OFF;
            core.Clock.signalState = SignalState.OFF;
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

    public SoundState getSoundState() {
        return soundState;
    }

    public void cycleAlarmStates() {
        configState.nextState();
    }
}
