package enums;

/*______________________________________________________________________________

 WARNING: Zmień ktoś formatowanie to uduszę :)

 Author: Wit
 _____________________________________________________________________________*/
public enum SignalState {

    OFF,
    SET;

    public SignalState toggleAlarm() {
        if (this == OFF) {
            return SET;
        } else {
            return OFF;
        }
    }

    public static String toString(SignalState state) {
        switch (state) {
            case OFF:
                return "OFF";
            case SET:
                return "SET";

            default:
                return "UNKNOWN";
        }
    }

    @Override
    public String toString() {
        return toString(this);
    }
}
