package enums;

/*______________________________________________________________________________

 WARNING: Zmień ktoś formatowanie to uduszę :)

 Author: Wit
 _____________________________________________________________________________*/
public enum SoundState {

    ALARM_ON_SOUND_ON, ALARM_ON_SOUND_OFF, ALARM_OFF_SOUND_ON, ALARM_OFF_SOUND_OFF;

    public SoundState nextState() {
        if (this == ALARM_ON_SOUND_ON) {
            return ALARM_ON_SOUND_OFF;
        } else if (this == ALARM_ON_SOUND_OFF) {
            return ALARM_OFF_SOUND_ON;
        } else if (this == ALARM_OFF_SOUND_ON) {
            return ALARM_OFF_SOUND_OFF;
        } else {
            return ALARM_ON_SOUND_ON;
        }
    }

    public static String toString(SoundState state) {
        switch (state) {
            case ALARM_ON_SOUND_ON:
                return "Alarm ON Hour Sound ON";
            case ALARM_ON_SOUND_OFF:
                return "Alarm ON Hour Sound OFF";
            case ALARM_OFF_SOUND_ON:
                return "Alarm OFF Hour Sound ON";
            case ALARM_OFF_SOUND_OFF:
                return "Alarm OFF Hour Sound OFF";
            default:
                return "UNKNOWN";
        }
    }

    @Override
    public String toString() {
        return toString(this);
    }
}
